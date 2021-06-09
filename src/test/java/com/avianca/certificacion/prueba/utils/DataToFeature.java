package com.avianca.certificacion.prueba.utils;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataToFeature {

    private static List<String> setExcelDataToFeature(File featureFile) throws InvalidFormatException, IOException {
        List<String> fileData = new ArrayList<String>();
        try (BufferedReader buffReader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), "UTF-8"))) {
            String data;
            List<Map<String, String>> excelData = null;
            boolean foundHashTag = false;
            boolean scenarioFound = false;
            boolean isNotDataScenario = true;
            boolean hastTagScenario = false;
            List<String> scenarioData = new ArrayList<String>();
            List<String> scenarioNew = new ArrayList<String>();
            String tag = "";

            while ((data = buffReader.readLine()) != null) {

                String sheetName = null;
                String excelFilePath = null;

                if (data.trim().contains("Example")) {
                    scenarioFound = false;
                }
                if (CucumberWithSerenity.currentRuntimeOptions().getTagFilters().isEmpty()) {
                    if (CucumberWithSerenity.currentRuntimeOptions().getTagFilters().get(0).trim().contains("@Todo")
                            && tag.isEmpty()
                            || CucumberWithSerenity.currentRuntimeOptions().getTagFilters().isEmpty()) {
                        tag = "@TestCase";
                    } else {
                        if (tag.isEmpty())
                            tag = CucumberWithSerenity.currentRuntimeOptions().getTagFilters().get(0);
                    }
                    if (data.trim().contains(tag)) {
                        scenarioData = new ArrayList<>();
                        scenarioFound = true;
                        isNotDataScenario = false;
                        hastTagScenario = true;
                    }
                } else {

                    if (verificarInTags(data)) {
                        scenarioData = new ArrayList<>();
                        scenarioFound = true;
                        isNotDataScenario = false;
                        hastTagScenario = true;
                    }
                }

                if (isNotDataScenario) {
                    fileData.add(data);
                }
                if (scenarioFound) {
                    scenarioData.add(data);
                }
                if (data.trim().contains("##@externaldata") && hastTagScenario) {
                    excelFilePath = data.substring(StringUtils.ordinalIndexOf(data, "@", 2) + 1, data.lastIndexOf("@"));
                    sheetName = data.substring(data.lastIndexOf("@") + 1, data.length());
                    foundHashTag = true;
                    hastTagScenario = false;
                }

                if (foundHashTag) {
                    excelData = new LectorExcel().getData(excelFilePath.trim(), sheetName.trim());
                    for (int rowNumber = 0; rowNumber < excelData.size(); rowNumber++) {
                        scenarioNew = new ArrayList<String>();
                        for (String line : scenarioData) {
                            scenarioNew.add(line);
                        }
                        for (String line : scenarioNew) {
                            String dataExcel = "";
                            if (line.contains("|")) {
                                String[] lineaData = line.split("\\|");
                                for (int i = 1; i < lineaData.length; i++) {
                                    if (!lineaData[i].trim().isEmpty())
                                        dataExcel += "|" + excelData.get(rowNumber).get(lineaData[i].trim());
                                }
                                dataExcel += "|";
                                scenarioNew.set(scenarioNew.indexOf(line), line + "\n" + dataExcel);
                            }
                            if (line.contains(" Outline:")) {
                                scenarioNew.set(scenarioNew.indexOf(line),
                                        line.replace(" Outline:", ": Numero " + (rowNumber + 1)));
                            }
                        }
                        for (String line : scenarioNew) {
                            fileData.add(line);
                        }
                    }
                    foundHashTag = false;
                }
            }
        }
        return fileData;
    }

    private static boolean verificarInTags(String tag) {
        String[] tags = CucumberWithSerenity.currentRuntimeOptions().getTagFilters().get(0).split(",");

        for (int i = 0; i < tags.length; i++) {
            if (tags[i].trim().contains(tag.trim()) && !tag.trim().isEmpty())
                return true;
        }
        return false;
    }


    public static void restoreBackUpFeatures() {
        try {
            FileUtils.copyDirectory(new File("./src/test/resources/backup/features/"),
                    new File("./src/test/resources/features/"));
            FileUtils.deleteDirectory(new File("./src/test/resources/backup/features/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void overrideFeatureFiles() throws IOException, InvalidFormatException {

        String featurePath = CucumberWithSerenity.currentRuntimeOptions().getFeaturePaths().get(0);
            List<String> featureWithExcelData = setExcelDataToFeature(new File(featurePath));
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(featurePath), "UTF-8"));) {
            for (String line : featureWithExcelData) {
                writer.write(line);
                writer.write("\n");
            }
        }
    }

    public static void backUpFeaturesFile() {
        try {
            FileUtils.copyDirectory(new File("./src/test/resources/features/"),
                    new File("./src/test/resources/backup/features/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
