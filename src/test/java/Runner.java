import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/features/",
        glue = {"stepdefinition","hooks"},
        tags = "@1")
public class Runner {
}
