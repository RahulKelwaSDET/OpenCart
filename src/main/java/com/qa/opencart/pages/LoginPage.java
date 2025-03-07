package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// Constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
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
		return eleUtil.waitForTitleContains(AppConstants.LOGIN_PAGE_TITLE_VALUE, AppConstants.SHORT_DEFAULT_VALUE);
	}

	public String getLoginPageURL() {
		return eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE, AppConstants.SHORT_DEFAULT_VALUE);
	}

	public boolean isForgotPwdLinkExist() {
		return eleUtil.checkElementIsDisplayed(forgotPasswordLink);

	}

	public List<String> getFooterLinksList() {
		List<WebElement> footerLinkList = eleUtil.waitForElementsPresence(footerLinks, AppConstants.MEDIUM_DEFAULT_VALUE);
		List<String> footerTextLink = new ArrayList<String>();
		for (WebElement e : footerLinkList) {
			String text = e.getText();
			footerTextLink.add(text);
		}
		return footerTextLink;

	}

	public List<String> getH2HeaderList() {
		List<WebElement> h2WebElement =eleUtil.waitForElementsPresence(h2Headers, AppConstants.MEDIUM_DEFAULT_VALUE);
		List<String> h2HeaderList = new ArrayList<String>();
		for (WebElement e : h2WebElement) {
			String headerName = e.getText();
			h2HeaderList.add(headerName);
		}
		
		return h2HeaderList;
	}

	public AccountsPage doLogin(String username, String pwd) {
		eleUtil.waitForElementVisible(emailID, AppConstants.MEDIUM_DEFAULT_VALUE).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.clickElementWhenReady(loginBtn, AppConstants.MEDIUM_DEFAULT_VALUE);
		return new AccountsPage(driver);

	}

}
