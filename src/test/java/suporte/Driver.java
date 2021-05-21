package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    static WebDriver navegador;

    public static WebDriver setupDriver(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        navegador.manage().window().maximize();
        return navegador;
    }

    public static  WebDriver getNavegador() {
        return navegador;
    }

}
