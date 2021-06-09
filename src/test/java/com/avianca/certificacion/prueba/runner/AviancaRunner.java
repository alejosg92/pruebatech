package com.avianca.certificacion.prueba.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;


@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = "src/test/resources/features/search.feature",
        snippets = SnippetType.CAMELCASE,
        glue = "com.avianca.certificacion.prueba.stepdefinition",
        tags = "@prueba"
)
public class AviancaRunner {
}
