package stepsPOEN;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {"src/test/resources/featuresPOEN"},       //onde est�o os cen�rios em Gherkin
        glue = {"stepsPOEN"},                                  // Onde est�o as defini��es de passos
        dryRun = false,                                       //Exibi��o de log
        monochrome = true,                                      // Detalhes do log
        plugin = {
                    "pretty",                                   //Fz formata��o visual do Cucumber
                    "html:target/reports/extentreports",        // Sa�da HMTL do Relat�rio Simples
                    "json:target/reports/extentreports.json",    //Sa�da Json com os dados do relat�rio
                    "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"
        }

)
public class RunnerEN extends AbstractTestNGCucumberTests { // Equivale ao @RunWith do JUnit
    // Configura��o de modelo de ralat�rio ou outa caracteristica
}
