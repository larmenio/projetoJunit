package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;

public class WebPageTest {

	private static WebDriver driver;
	private static ChromeActions cActions;
    Logger logger = LoggerFactory.getLogger(WebPageTest.class);
    private static LoginPage login;

	@BeforeEach
    public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "C:.\\chromedriver-win64\\chromedriver.exe");
		logger.info("--- Testing Login Process For All Users Available In The List ---");
		logger.info("------------------Starting Test---------------------");
	    // Set Chrome options
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*"); // Allow remote connections
//	    options.addArguments("--headless=new"); // Run in headless mode, optional
	    options.addArguments("--disable-dev-shm-usage"); // Good for containerized environments
	    options.addArguments("--no-sandbox"); // Disable sandbox for stability on some systems
	    options.addArguments("--disable-gpu"); // Disable GPU, useful for headless mode
	    options.addArguments("--remote-debugging-port=9222"); // Specify a debugging port

	    // Initialize ChromeDriver with options
	    driver = new ChromeDriver(options);

	    cActions = new ChromeActions(driver);
        cActions.open();

    }

	@Test
    public void testLoginInPage() {
		cActions = new ChromeActions(driver);
		logger.info(cActions.getTitle());
		logger.info("--------------------------Starting Login Process---------------------------");
		login = new LoginPage(driver);
		List<String> users = login.getUsers();
		users.forEach(username -> {
		    logger.info("=========> Username: " + username + " <============");
		    List<String> password = login.getPass();
		    password.forEach(pass -> {
		        logger.info("=========> Password: " + pass + " <============");
		        login.insertingData(username, pass);
				boolean loginVerified = login.verifyLoggin();
				if(loginVerified) {
					logger.info("User: " + username + "is loging correctly.");
					assertTrue(loginVerified);
				} else {
					logger.info("User: " + username + "is blocked correctly.");
					assertFalse(loginVerified);
				}
//Initial idea here was to return to login page with logout tag, but for some reason I was not
//to open the side tab and click the logout button, so as the page turn possible to go directly I did this way.
		        driver.get("https://www.saucedemo.com/");


		    });

		});
		}

//Closing browser
	@AfterAll
	public static void tearDown() {
		// Close the browser
		cActions = new ChromeActions(driver);
		cActions.close();

	}
}
