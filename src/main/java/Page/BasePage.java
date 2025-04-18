package Page;

// === Importaciones necesarias ===
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

// === Clase BasePage ===
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // === Métodos utilizados en el proyecto según los pasos del feature ===

    // Método para enviar texto a un campo por ID
    public void sendKeysById(String texto, String idElement) {
        WebElement webElement = this.driver.findElement(By.id(idElement));
        webElement.clear(); // Limpia antes de escribir
        webElement.sendKeys(texto);
    }
    // Método para enviar texto a un campo por XPaths
    public void sendKeysByXpath(String texto, String xpath) {
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.clear();
        webElement.sendKeys(texto);
    }
    // Método para clicBoton Registrarse
    public void clicByID(String idElement) {
        WebElement webElement = driver.findElement(By.id(idElement));
        webElement.click();
    }

    // Método para Recuperar mensaje de validación
    public String getTextById(String idElement) {
        WebElement elemento = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idElement)));
        return elemento.getText();
    }



    /**
     * Hace clic en un elemento identificado por su XPath.
     *
     * @param xpath El XPath del elemento
     */
    public void clicByXpath(String xpath) {
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.click();
    }

    /**
     * Recupera el texto de un elemento identificado por su clase.
     *
     * @param className El nombre de la clase del elemento
     * @return El texto del elemento
     */
    public String getTextByClass(String className) {
        System.out.println("[Debug] Buscando mensaje por clase: " + className);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
            return elemento.getText();
        } catch (Exception e) {
            System.err.println("[Error] No se encontró el elemento con clase: " + className);
            return ""; // Devuelve una cadena vacía si ocurre una excepción
        }
    }
}