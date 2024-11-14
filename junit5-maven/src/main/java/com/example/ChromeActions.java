package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

	public class ChromeActions {
		private WebDriver driver;

	    // Constructor to initialize the WebDriver
	    public ChromeActions(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Open the target webpage
	    public void open() {
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--remote-allow-origins=*");
	        driver.get("https://www.saucedemo.com/");

	    }

	    public void close() {
	    	if (driver != null) {
	            driver.quit();
	    	}
	    }

	    // Get the page title
	    public String getTitle() {
	        return driver.getTitle();
	    }
	}
