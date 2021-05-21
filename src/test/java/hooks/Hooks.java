
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static suporte.Driver.getNavegador;
import static suporte.Driver.setupDriver;

public class Hooks {

    @Before
    public void setUp(){
        setupDriver();
    }

    @After
    public void tearDown(){
        //Fechar o navegador
        getNavegador().quit();
    }
}
