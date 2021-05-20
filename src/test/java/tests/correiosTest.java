package tests;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class correiosTest {
    @Test
    public void Teste(){
        // Abrindo navegador
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Navigar para pagina do correios
        navegador.get("https://www.correios.com.br");
        navegador.manage().window().maximize();

        // Digitar o CEP no campo Busca CEP
        WebElement cmpBuscarCep = navegador.findElement(By.name("relaxation"));
        cmpBuscarCep.sendKeys("03195100");


        // clicar na lupa de buscar

        WebElement lupaDeBusca = navegador.findElement(By.xpath("//input[@name='relaxation']//following::i[1]"));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].scrollIntoView(true);",lupaDeBusca);

        lupaDeBusca.click();
        ArrayList<String> tabs2 = new ArrayList<String> (navegador.getWindowHandles());
        navegador.switchTo().window(tabs2.get(1));


        //Validar o Resultado da Busca por Endereço ou CEP
        WebElement txtResultado = navegador.findElement(By.id("mensagem-resultado"));
        String txtResultadoDaBusca = txtResultado.getText();
        assertEquals("Resultado da Busca por Endereço ou CEP",txtResultadoDaBusca);



    }

}
