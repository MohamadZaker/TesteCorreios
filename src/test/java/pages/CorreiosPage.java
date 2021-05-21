package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import suporte.Generator;
import suporte.Screenshot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static suporte.Driver.getNavegador;

public class CorreiosPage {
    public void entrarNoSiteDosCorreios() {
        getNavegador().get("https://www.correios.com.br/");
    }

    public void realizarABusca(String arg0) {
        WebElement cmpBuscarCep = getNavegador().findElement(By.name("relaxation"));
        cmpBuscarCep.sendKeys(arg0);

        // Clicar na lupa de buscar

        WebElement lupaDeBusca = getNavegador().findElement(By.xpath("//input[@name='relaxation']//following::i[1]"));
        ((JavascriptExecutor) getNavegador()).executeScript("arguments[0].scrollIntoView(true);",lupaDeBusca);

        lupaDeBusca.click();
        ArrayList<String> tabs2 = new ArrayList<String> (getNavegador().getWindowHandles());
        getNavegador().switchTo().window(tabs2.get(1));
    }

    public void mostrarResultadoLog() {
        //Validar o Resultado da Busca por Endereço ou CEP
        try {

            Thread.sleep(2000);
        }catch (Exception e){

        }
        WebElement txtResultado = getNavegador().findElement(By.id("mensagem-resultado"));
        String txtResultadoDaBusca = txtResultado.getText();
        assertEquals("Resultado da Busca por Endereço ou CEP",txtResultadoDaBusca);
        String screenshotArquivo = "C:\\projects\\correiosTeste\\Test-repot\\"+ Generator.dataHoraParaArquivo()+".jpg";
        Screenshot.tirarScreenshot(getNavegador(),screenshotArquivo);

        //Output das informações retornadas
        WebElement tabela = getNavegador().findElement(By.id("resultado-DNEC"));
        List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));

        for (WebElement linha : tr) {
            System.out.println(linha.getText());
        }

    }
}
