package com.avianca.certificacion.prueba.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class LectorExcel {

        public List<Map<String, String>> getData(String excelFilePath, String sheetName)
                throws InvalidFormatException, IOException {
            Sheet sheet = getSheetByName(excelFilePath, sheetName);
            return readSheet(sheet);
        }

        public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
                throws InvalidFormatException, IOException {
            Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
            return readSheet(sheet);
        }

        public static LectorExcel deMiExcel() {
            return new LectorExcel();
        }

        private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
            Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
            return sheet;
        }

        private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
            Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
            return sheet;
        }

        private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
            return WorkbookFactory.create(new File(excelFilePath));
        }

        private List<Map<String, String>> readSheet(Sheet sheet) {
            Row row;
            int totalRow = sheet.getPhysicalNumberOfRows(); // -------------> se deja la ??ltima fila Se quita una de las
            // filas que la librer??a considera que tiene datos debido a que
            // deja una en blanco
            List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
            int headerRowNumber = getHeaderRowNumber(sheet);
            if (headerRowNumber != -1) {
                int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
                int setCurrentRow = 1;
                for (int currentRow = setCurrentRow; currentRow < totalRow; currentRow++) {
                    row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                    LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
                    for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                        columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
                    }
                    excelRows.add(columnMapdata);

                }
            }
            return excelRows;
        }

        @SuppressWarnings("deprecation")
        private int getHeaderRowNumber(Sheet sheet) {
            Row row;
            int totalRow = sheet.getLastRowNum();
            for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
                row = getRow(sheet, currentRow);
                if (row != null) {
                    int totalColumn = row.getLastCellNum();
                    for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                        Cell cell;
                        cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        if (cell.getCellTypeEnum() == CellType.STRING) {
                            return row.getRowNum();
                        } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                            return row.getRowNum();
                        } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                            return row.getRowNum();
                        } else if (cell.getCellTypeEnum() == CellType.ERROR) {
                            return row.getRowNum();
                        } else if (cell.getCellTypeEnum() == CellType.FORMULA) {
                            return row.getRowNum();
                        }
                    }
                }
            }
            return (-1);
        }

        private Row getRow(Sheet sheet, int rowNumber) {
            return sheet.getRow(rowNumber);
        }

        @SuppressWarnings("deprecation")
        private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
            LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
            Cell cell;
            if (row == null) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellTypeEnum() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else {
                cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    if (sheet.getRow(sheet.getFirstRowNum())
                            .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .getCellTypeEnum() != CellType.BLANK) {
                        String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                                .getStringCellValue();
                        columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                    }
                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    if (sheet.getRow(sheet.getFirstRowNum())
                            .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .getCellTypeEnum() != CellType.BLANK) {
                        String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                                .getStringCellValue();
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            columnMapdata.put(columnHeaderName, String.valueOf(dateFormat.format(cell.getDateCellValue())));
                        } else {
                            columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                        }
                    }
                } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                    if (sheet.getRow(sheet.getFirstRowNum())
                            .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .getCellTypeEnum() != CellType.BLANK) {
                        String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                                .getStringCellValue();
                        columnMapdata.put(columnHeaderName, "");
                    }
                } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                    if (sheet.getRow(sheet.getFirstRowNum())
                            .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .getCellTypeEnum() != CellType.BLANK) {
                        String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                                .getStringCellValue();
                        columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                    }
                } else if (cell.getCellTypeEnum() == CellType.ERROR) {
                    if (sheet.getRow(sheet.getFirstRowNum())
                            .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .getCellTypeEnum() != CellType.BLANK) {
                        String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                                .getStringCellValue();
                        columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                    }
                } else if (cell.getCellTypeEnum() == CellType.FORMULA) {
                    if (sheet.getRow(sheet.getFirstRowNum())
                            .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .getCellTypeEnum() != CellType.BLANK) {
                        String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                                .getStringCellValue();
                        //Muestra el resultaod de la formula, SOLO para cadenas de texto
                        columnMapdata.put(columnHeaderName, String.valueOf(cell.getStringCellValue()));
                    }
                }
            }
            return columnMapdata;
        }
}
