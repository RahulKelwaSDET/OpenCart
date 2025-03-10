package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.frameworkexception.FrameworkException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;

	private OptionsManager op;

	public WebDriver initDriver(Properties prop) {
		String browsername = prop.getProperty("browser");
		op = new OptionsManager(prop);
		
		switch (browsername.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(op.getChromeOptions());

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(op.getFirefoxOptions());
			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(op.getEdgeOptions());
			break;

		default:
			System.out.println("please pass the right browser" + browsername);
			throw new FrameworkException("DRIVERNOTFOUNDEXCEPTION");

		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	public Properties getprop() {
		Properties prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");

		try {

			if (envName == null) {
				ip = new FileInputStream("./src/main/resources/config/qa.config.properties");
			} else {

				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/main/resources/config/qa.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/main/resources/config/dev.config.properties");
					break;

				case "uat":
					ip = new FileInputStream("./src/main/resources/config/uat.config.properties");
					break;
				default:
					throw new FrameworkException("INVALIDENVNAME");

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
