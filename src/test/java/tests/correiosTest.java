package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
//import suporte.Generator;
import suporte.screenshot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class correiosTest {
   private  WebDriver navegador;
//    @Before
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
//        navegador = new ChromeDriver();
//        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        //Navigar para pagina do correios
//        navegador.get("http://www.buscacep.correios.com.br/");
//        navegador.manage().window().maximize();
//    }

    @Test
    public void Teste(){
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Navigar para pagina do correios
        navegador.get("https://www.correios.com.br/");
        navegador.manage().window().maximize();

        //clicar em busca de cep
//        WebElement imgBusarCep = navegador.findElement(By.xpath("//img[@alt='Buscar CEP']"));
//        imgBusarCep.click();

        // Digitar o CEP no campo Busca CEP
        WebElement cmpBuscarCep = navegador.findElement(By.name("relaxation"));
        cmpBuscarCep.sendKeys("alto da mooca");


        // clicar na lupa de buscar

        WebElement lupaDeBusca = navegador.findElement(By.xpath("//input[@name='relaxation']//following::i[1]"));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].scrollIntoView(true);",lupaDeBusca);

        lupaDeBusca.click();
        ArrayList<String> tabs2 = new ArrayList<String> (navegador.getWindowHandles());
        navegador.switchTo().window(tabs2.get(1));


        //Validar o Resultado da Busca por Endereço ou CEP

        try {

            Thread.sleep(100);
        }catch (Exception e){

        }
        WebElement txtResultado = navegador.findElement(By.id("mensagem-resultado"));
        String txtResultadoDaBusca = txtResultado.getText();
//        assertEquals("Resultado da Busca por Endereço ou CEP",txtResultadoDaBusca);
//        String screenshotArquivo = "C:\\projects\\correiosTeste\\Test-repot";
//        screenshot.tirarScreenshot(navegador,screenshotArquivo);

        WebElement tabela = navegador.findElement(By.id("resultado-DNEC"));

        List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));

//        List<WebElement> td = tabela.tr.findElements(By.cssSelector("td"));


        for (WebElement linha : tr) {
            System.out.println(linha.getText());
        }





    }


    @After
    public void tearDown(){
        //fechar o navegador
        navegador.quit();
    }


}




