package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;

public class WebPageTest {
	
	private static WebDriver driver;
	private static ChromeActions cActions;
    Logger logger = LoggerFactory.getLogger(WebPageTest.class);
    private static LoginPage login;
	
	@BeforeEach
    public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
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
		    logger.info("=========> Username: " + username + "<============");
		    List<String> password = login.getPass();
		    password.forEach(pass -> {
		        logger.info("=========> Password: " + pass + "<============");
		        login.insertingData(username, pass);
		        driver.get("https://www.saucedemo.com/");
//		        login.backToLogin();
		        
		    });
		       
		});
		}
    
	
	@AfterAll
	public static void tearDown() {
		// Close the browser
		cActions = new ChromeActions(driver);
		cActions.close();
        
	}
}
