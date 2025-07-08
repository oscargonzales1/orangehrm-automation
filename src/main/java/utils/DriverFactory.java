package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    // Método para inicializar el driver si aún no existe
    public static void initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    // Obtener la instancia actual del driver
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver no ha sido inicializado. Llama a initDriver() antes.");
        }
        return driver;
    }

    // Cerrar y limpiar el driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}