package com.qaautomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Page.FormBugsPages.FormsPage;

import java.time.Duration;

public class FormsStepDefinitions {

    private WebDriver driver;
    private FormsPage formsPage;

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        ChromeOptions options = new ChromeOptions();

        String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\driver\\chromedriver.exe";
        System.out.println("[Info] Ruta driver: " + pathChromeDriver);
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://buggy.justtestit.org/register"); // Alineado con el archivo .feature
        this.formsPage = new FormsPage(driver);
    }

    @When("I fill in the registration form with the following details:")
    public void iFillInTheRegistrationFormWithTheFollowingDetails(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMap(String.class, String.class);

        // Verificar y enviar solo si los datos no son nulos
        if (data.get("username") != null) {
            formsPage.enviarLogin(data.get("username"));
        }
        if (data.get("firstName") != null) {
            formsPage.enviarFirstName(data.get("firstName"));
        }
        if (data.get("lastName") != null) {
            formsPage.enviarLastName(data.get("lastName"));
        }
        if (data.get("password") != null) {
            formsPage.enviarPassword(data.get("password"));
        }
        if (data.get("confirmPassword") != null) {
            formsPage.enviarConfirmPassword(data.get("confirmPassword"));
        }
    }

    @And("I click the Register button")
    public void iClickTheRegisterButton() {
        formsPage.clickRegisterButton();
    }

    @Then("I should see the success message {string}")
    public void iShouldSeeTheSuccessMessage(String expectedMessage) {
        String actualMessage = formsPage.obtenerMensajeExito();
        Assert.assertEquals("The success message does not match", expectedMessage, actualMessage);
    }

   @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedMessage) {
        String actualMessage = formsPage.getErrorMessageByText(expectedMessage);

        if (actualMessage == null || actualMessage.equals("Elemento no encontrado")) {
            // Falla la prueba si el mensaje no se encuentra
            Assert.fail("El mensaje de error no se encontró en la página.");
        }

        System.out.println("[Debug] Mensaje esperado: " + expectedMessage);
        System.out.println("[Debug] Mensaje actual: " + actualMessage);
        Assert.assertTrue("El mensaje de error no contiene el texto esperado.",
                actualMessage.contains(expectedMessage)); // Compara el mensaje esperado con el real
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}