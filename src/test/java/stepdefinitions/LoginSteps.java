package stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Properties;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    Properties config;

    @Before
    public void setup() {
        DriverFactory.initDriver(); // inicializa
        driver = DriverFactory.getDriver(); // asigna
        config = ConfigReader.initProperties();
    }

    @Given("que el usuario accede a la aplicación")
    public void usuario_accede() {
        driver.get(config.getProperty("baseUrl"));
        loginPage = new LoginPage(driver);
    }

    @When("inicia sesión con usuario válido")
    public void login_valido() {
        loginPage.login(config.getProperty("username"), config.getProperty("password"));
    }

    @When("inicia sesión con usuario inválido")
    public void login_invalido() {
        loginPage.login("fake", "123");
    }

    @Then("debe visualizar el dashboard")
    public void validar_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Validamos por ejemplo la visibilidad del "Dashboard" heading
        boolean isDashboardVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[text()='Dashboard']"))).isDisplayed();
        assertTrue(isDashboardVisible);
    }

    @Then("debe mostrarse un mensaje de error")
    public void validar_error() {
        assertTrue("El mensaje de error no fue visible", loginPage.isLoginErrorDisplayed());
    }

    @After
    public void teardown() {
        DriverFactory.quitDriver();
    }
}