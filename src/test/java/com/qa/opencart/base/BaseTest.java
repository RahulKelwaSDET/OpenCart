package com.qa.opencart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	protected DriverFactory df;
	protected LoginPage loginPage;
	protected AccountsPage accPage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.getprop();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
