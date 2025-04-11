package com.qaautomation.stepdefinitions;


import Page.FormBugsPages.FormsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class BugsFormSteps {
    private WebDriver driver;
    private FormsPage formsPage;

    @Given("el usuario se encuentra en la home de BugsForm")
    public void elUsuarioSeEncuentraEnLaHomeDeBugsForm() {

        ChromeOptions options = new ChromeOptions();

        String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\driver\\chromedriver.exe";
        System.out.println("[Info] Ruta driver: " + pathChromeDriver);
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        driver = new ChromeDriver(options);
        driver.get("https://qa-practice.netlify.app/bugs-form");
        this.formsPage = new FormsPage(driver);

    }

    @When("el usuario ingresa First Name {string}")
    public void elUsuarioIngresaFirstName(String nombre) {
        this.formsPage.enviarFirstName(nombre);
    }

    @And("el usuario ingresa Last Name {string}")
    public void elUsuarioIngresaLastName(String apellido) {
        this.formsPage.enviarLastName(apellido);

    }

    @And("el usuario ingresa Phone number {string}")
    public void elUsuarioIngresaPhoneNumber(String telefono) {
        this.formsPage.enviarPhoneNumber(telefono);
    }

    @And("el usuario ingresa Country {string}")
    public void elUsuarioIngresaCountry(String arg0) {
        
    }

    @And("el usuario ingresa Email address {string}")
    public void elUsuarioIngresaEmailAddress(String Email) {
        this.formsPage.enviarEmail("Email");

    }
    @And("el usuario ingresa Email Password {string}")
    public void elUsuarioIngresaEmailPassword(String Password) {
        this.formsPage.enviarPassword("Password");

    }


    @And("el usuario hace clic boton Register")
    public void elUsuarioHaceClicBotonRegister() {
        this.formsPage.clicBtnRegister();

    }

    @Then("el usuario visualiza el mensaje {string}")
    public void elUsuarioVisualizaElMensaje(String msjEsperado) {
        String msjRecuperado = this.formsPage.verLblRegister();
        Assert.assertEquals("[Error] El mensaje no es lo esperado", msjEsperado, msjRecuperado);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("[Info] El navegador se cerró correctamente.");
        }
    }
}


