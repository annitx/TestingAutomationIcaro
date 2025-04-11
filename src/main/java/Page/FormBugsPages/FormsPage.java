package Page.FormBugsPages;

import Page.BasePage;
import org.openqa.selenium.WebDriver;

public class FormsPage extends BasePage {

    private String inputFirstName = "firstName";
    private String inputLastName = "lastName";
    private String inputPhoneNumber = "//input[@type=\"tel\"]";
    private String inputEmail = "emailAddress";
    private String inputPassword = "password";
    private String btnRegister = "registerBtn";
    private String lblMsj = "message";

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void enviarFirstName(String nombre) {
        sendKeysById(nombre, inputFirstName);
    }

    public void enviarLastName(String apellido) {
        sendKeysById(apellido, inputLastName);
    }

    public void enviarPhoneNumber(String numero) {
        sendKeysByXpath(numero, inputPhoneNumber);
    }

    public void enviarEmail(String email) {
        sendKeysById(email, inputEmail);
    }

    public void enviarPassword(String password) {
        sendKeysById(password, inputPassword);
    }

    public void clicBtnRegister() {
        clicByID(btnRegister);
    }

    public String verLblRegister() {
        return getTextById(lblMsj);
    }
}
