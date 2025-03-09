package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// By locators
	private By logoutLink = By.linkText("Logout");
	private By myAccount = By.linkText("My Account");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	// public actions/methods.

	public String getaccPagetitle() {
		return eleUtil.waitForTitleContains(AppConstants.ACCOUNT_PAGE_TITLE_VALUE, AppConstants.SHORT_DEFAULT_VALUE);
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.checkElementIsDisplayed(logoutLink);
	}

	public boolean isMyAccountLinkExist() {
		return eleUtil.checkElementIsDisplayed(myAccount);
	}

	public List<String> getAccountPageHeaderList() {
		List<WebElement> headersList = eleUtil.waitForElementsPresence(accHeaders, AppConstants.MEDIUM_DEFAULT_VALUE);
		List<String> headerValList = new ArrayList<String>();
		for (WebElement e : headersList) {
			String text = e.getText();
			headerValList.add(text);
		}
		return headerValList;
	}

	public ResultsPage doSearch(String searchTerm) {
		eleUtil.waitForElementVisible(search, AppConstants.LONG_DEFAULT_VALUE);
		eleUtil.doSendKeys(search, searchTerm);
		eleUtil.doActionsClick(searchIcon);
		return new ResultsPage(driver);
	}
}
