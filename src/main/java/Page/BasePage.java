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

}


