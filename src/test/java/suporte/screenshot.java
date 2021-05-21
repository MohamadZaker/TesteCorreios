package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class screenshot {
    public static void tirarScreenshot(WebDriver navegador,String arquivo){
        File sceenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sceenshot,new File(arquivo));
        }catch (Exception e){

        }

    }
}
