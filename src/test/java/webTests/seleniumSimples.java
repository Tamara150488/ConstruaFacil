// 1 - Pacote
package webTests;

// 2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


// 3 - Classe
public class seleniumSimples {
    // 3.1 - Atributos

    WebDriver driver;                           // declarar o objeto do Selenium WebDriver

    // 3.2 - M�todos e Fun��es
    @BeforeMethod
    public void iniciar(){
        // A - In�cio
        // Aponta para onde est� o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/91/chromedriver.exe");
        // Instancia o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

    }

    @AfterMethod
    public void finalizar(){
        // C - Encerramento

        driver.quit();  // Fecha a janela ao finalizar

    }

    @Test(priority = 2, dependsOnMethods = {"consultarCursoPreparatorioCTFL"})
    public void consultarCurso(){
        // B - Realizar o teste
        driver.get("https://www.iterasys.com.br");                              // Abre o site alvo informado

        driver.findElement(By.id("searchtext")).click();                        // Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                        // Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis");  // Escreve "mantis" no campo

        driver.findElement(By.id("btn_form_search")).click();                   // Clique na lupa

        //assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos � \"mantis\"");
        assertTrue(driver.findElement(By.cssSelector("h3")).getText().contains("mantis"));

        driver.findElement(By.cssSelector("span.comprar")).click();

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99");

    }

    @Test(priority = 1)
    public void consultarCursoPreparatorioCTFL(){

        // B - Realizar o teste
        driver.get("https://www.iterasys.com.br");                              // Abre o site alvo informado

        driver.findElement(By.id("searchtext")).click();                        // Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                        // Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("preparat�rio ctfl");  // Escreve "mantis" no campo

        driver.findElement(By.id("btn_form_search")).click();                   // Clique na lupa

        //assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos � \"mantis\"");
        assertTrue(driver.findElement(By.cssSelector("h3")).getText().contains("preparat�rio ctfl"));

        driver.findElement(By.cssSelector("span.comprar")).click();

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Preparat�rio CTFL");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 169,00");

    }
}
