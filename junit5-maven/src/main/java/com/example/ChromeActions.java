package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

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

		public void screenshot() throws IOException{
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Specify the location to save the screenshot
			File destinationFile = new File("C:.\\screenshot.png");

			// Copy the screenshot to the destination
			FileUtils.copyFile(screenshot, destinationFile);
		}
	}
