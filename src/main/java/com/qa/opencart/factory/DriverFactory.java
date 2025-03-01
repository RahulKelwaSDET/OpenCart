package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	WebDriver driver;

	public WebDriver initDriver(Properties prop) {
		String browsername = prop.getProperty("browser");
		switch (browsername.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("please pass the right browser" + browsername);

		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	public Properties getprop() {
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/main/resources/config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;

	}


}
