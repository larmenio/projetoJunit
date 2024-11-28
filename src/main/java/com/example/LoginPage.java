package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage {
    private WebDriver driver;
    // Define locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By credentialsList = By.id("login_credentials");
    //Was not working to logout using the next two tags
    private By sideBar = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");
    private By loginVerify = By.id("react-burger-menu-btn");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<String> getUsers() {
    	WebElement credentialsElement = driver.findElement(credentialsList);
    	String credentialsText = credentialsElement.getText();

    	Pattern pattern = Pattern.compile("(?m)^\\s*(\\S+)$"); // Matches each line containing a single word (username)
        Matcher matcher = pattern.matcher(credentialsText);

        List<String> usernames = new ArrayList<>();

        // Add each matched username to the list
        while (matcher.find()) {
            usernames.add(matcher.group(1).trim());
        }
    	return usernames;
    }

    public List<String> getPass() {
    	WebElement passLocal = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[2]"));
    	String passText = passLocal.getText();

    	Pattern pattern = Pattern.compile("(?m)^\\s*(\\S+)$"); // Matches each line containing a single word (username)
        Matcher matcher = pattern.matcher(passText);

        List<String> passwords = new ArrayList<>();
        while (matcher.find()) {
        	passwords.add(matcher.group(1));
        }
		return passwords;
    }

    public void insertingData(String user, String pass) {
        // Locate the input field by its ID and enter the username
        WebElement username = driver.findElement(usernameField);
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
}
