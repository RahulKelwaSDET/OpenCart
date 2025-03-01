package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// Constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Private By locators
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");
	private By h2Headers = By.xpath("//h2");

	// public page actions/method

	public String getLoginPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();

	}

	public List<String> getFooterLinksList() {
		List<WebElement> footerLinkList = driver.findElements(footerLinks);
		List<String> footerTextLink = new ArrayList<String>();
		for (WebElement e : footerLinkList) {
			String text = e.getText();
			footerTextLink.add(text);
		}
		return footerTextLink;

	}

	public List<String> getH2HeaderList() {
		List<WebElement> h2WebElement = driver.findElements(h2Headers);
		List<String> h2HeaderList = new ArrayList<String>();
		for (WebElement e : h2WebElement) {
			String headerName = e.getText();
			h2HeaderList.add(headerName);
		}
		
		return h2HeaderList;
	}

	public AccountsPage doLogin(String username, String pwd) {
		driver.findElement(emailID).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AccountsPage(driver);

	}

}
