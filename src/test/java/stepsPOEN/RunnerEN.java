package stepsPOEN;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {"src/test/resources/featuresPOEN"},       //onde estão os cenários em Gherkin
        glue = {"stepsPOEN"},                                  // Onde estão as definições de passos
        dryRun = false,                                       //Exibição de log
        monochrome = true,                                      // Detalhes do log
        plugin = {
                    "pretty",                                   //Fz formatação visual do Cucumber
                    "html:target/reports/extentreports",        // Saída HMTL do Relatório Simples
                    "json:target/reports/extentreports.json",    //Saída Json com os dados do relatório
                    "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"
        }

)
public class RunnerEN extends AbstractTestNGCucumberTests { // Equivale ao @RunWith do JUnit
    // Configuração de modelo de ralatório ou outa caracteristica
}
