package com.example;

import java.io.InputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage extends yamlPull{
    private WebDriver driver;
    // Define locators
    // private By usernameField = By.id("user-name");
    // private By passwordField = By.id("password");
    // private By loginButton = By.id("login-button");
    // private By credentialsList = By.id("login_credentials");
    // //Was not working to logout using the next two tags
    // private By sideBar = By.id("react-burger-menu-btn");
    // private By logout = By.id("logout_sidebar_link");
    // private By loginVerify = By.id("react-burger-menu-btn");
    // private By chooseBackpack = By.id("add-to-cart-sauce-labs-backpack");
    // private By chooseBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    // private By removeBikeLight = By.id("remove-sauce-labs-bike-light");
    // private By checkout = By.id("checkout");
    // private By firstNameTag = By.id("first-name");
    // private By lastNameTag = By.id("last-name");
    // private By postalTag = By.id("postal-code");
    // private By continueTag = By.id("continue");
    // private By finishTag = By.id("finish");

        // Print the entire content for verification

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void insertingData(String user, String pass) {
        // Locate the input field by its ID and enter the username
        WebElement username = driver.find(usernameField);
        username.sendKeys(user); // Replace "your_username" with the actual username

        // Optionally, locate and enter the password
        WebElement password = driver.findElement(passwordField);
        password.sendKeys(pass); // Replace "your_password" with the actual password

        // Submit the form, if necessary
        WebElement clickLogin = driver.findElement(loginButton);
        clickLogin.click();

    }

    public boolean verifyLoggin() {
        boolean elementPresent = !driver.findElements(loginVerify).isEmpty();
        return elementPresent;
    }

    public void chooseItem() {
        WebElement backpack = driver.findElement(chooseBackpack);
        backpack.click();

        WebElement bikeLight = driver.findElement(chooseBikeLight);
        bikeLight.click();
    }

    public void cart() {
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement bikeLightDelete = driver.findElement(removeBikeLight);
        bikeLightDelete.click();
    }

    public void finalizingOrder(String firstName, String lastName, String postalCode) {
        WebElement checkoutButton = driver.findElement(checkout);
        checkoutButton.click();

        WebElement firstNameSpace = driver.findElement(firstNameTag);
        firstNameSpace.sendKeys(firstName);
        WebElement lastNameSpace = driver.findElement(lastNameTag);
        lastNameSpace.sendKeys(lastName);
        WebElement postal = driver.findElement(postalTag);
        postal.sendKeys(postalCode);

        WebElement continueButton = driver.findElement(continueTag);
        continueButton.click();
        WebElement finishButton = driver.findElement(finishTag);
        finishButton.click();

    }

}
