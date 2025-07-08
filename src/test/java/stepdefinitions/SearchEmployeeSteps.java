package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.PimPage;
import utils.DriverFactory;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class SearchEmployeeSteps {

    WebDriver driver;
    LoginPage loginPage;
    PimPage pimPage;
    Properties config = ConfigReader.initProperties();

    @Given("que el usuario inicia sesión en OrangeHRM")
    public void login() {
        driver = DriverFactory.getDriver(); // Solo obtener el driver, no inicializar
        driver.get(config.getProperty("baseUrl"));
        loginPage = new LoginPage(driver);
        loginPage.login(config.getProperty("username"), config.getProperty("password"));
    }

    @When("busca el empleado {string}")
    public void busca_empleado(String nombre) {
        pimPage = new PimPage(driver);
        pimPage.navigateToPIM();
        pimPage.searchEmployee(nombre);
    }

    @Then("se deben mostrar los resultados")
    public void validar_resultados() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions
                .textToBePresentInElementLocated(By.cssSelector(".orangehrm-container"), "Alexa")));
        // Ya no hagas quit aquí
        // DriverFactory.quitDriver();
    }
}