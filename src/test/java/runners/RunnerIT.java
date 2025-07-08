package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"}, // Asegúrate de incluir hooks si los usas
        plugin = {"pretty"},
        tags = "@all" // Ejecuta solo los escenarios marcados con @all
)
public class RunnerIT {
}