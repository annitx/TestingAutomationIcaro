package Page.FormBugsPages;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormsPage extends BasePage {

    private String inputLogin = "username";
    private String inputFirstName = "firstName";
    private String inputLastName = "lastName";
    private String inputPassword = "password";
    private String inputConfirmPassword = "confirmPassword";
    private String btnRegister = "//button[text()='Register']";
    private String alertSuccess = "alert-success";
    private String alertDanger = "alert-danger";

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void enviarLogin(String login) {
        if (login != null && !login.isEmpty()) {
            sendKeysById(login, inputLogin);
        }
    }

    public void enviarFirstName(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            sendKeysById(nombre, inputFirstName);
        }
    }

    public void enviarLastName(String apellido) {
        if (apellido != null && !apellido.isEmpty()) {
            sendKeysById(apellido, inputLastName);
        }
    }

    public void enviarPassword(String password) {
        if (password != null && !password.isEmpty()) {
            sendKeysById(password, inputPassword);
        }
    }

    public void enviarConfirmPassword(String confirmPassword) {
        if (confirmPassword != null && !confirmPassword.isEmpty()) {
            sendKeysById(confirmPassword, inputConfirmPassword);
        }
    }

    public void clickRegisterButton() {
        clicByXpath(btnRegister);
    }

    public String obtenerMensajeExito() {
        return getTextByClassConEspera(alertSuccess);
    }

    public String obtenerMensajeError() {
        return getTextByClassConEspera(alertDanger);
    }

    private String getTextByClassConEspera(String className) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Aumentar tiempo de espera
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
            return element.getText();
        } catch (Exception e) {
            System.err.println("[Error] El elemento con clase " + className + " no fue encontrado dentro del tiempo límite.");
            return "Elemento no encontrado";
        }
    }


    public String getErrorMessageByText(String expectedText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Tiempo de espera aumentado
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'alert-danger') and contains(text(), '" + expectedText + "')]")
            ));
            return element.getText().trim(); // Elimina espacios adicionales
        } catch (TimeoutException e) {
            System.err.println("[Error] El elemento con el texto '" + expectedText + "' no fue encontrado dentro del tiempo límite.");
            return "Elemento no encontrado"; // Devuelve un mensaje personalizado
        }
    }
}
