package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PimPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By pimMenu = By.cssSelector("a[href*='viewPimModule']");
    private final By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private final By searchButton = By.xpath("//button[@type='submit']");

    // Constructor
    public PimPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navegar al módulo PIM
    public void navigateToPIM() {
        WebElement pimElement = wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
        pimElement.click();
    }

    // Buscar empleado por nombre
    public void searchEmployee(String nombre) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput));
        input.clear(); // buena práctica: limpiar antes de escribir
        input.sendKeys(nombre);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        button.click();
    }
}