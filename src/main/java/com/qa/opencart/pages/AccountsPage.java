package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}

	// By locators
	private By logoutLink = By.linkText("Logout");
	private By myAccount = By.linkText("My Account");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	//public actions/methods.
	
public String getaccPagetitle()
{
	return driver.getTitle();
}
	public boolean isLogoutLinkExist() {
		 return driver.findElement(logoutLink).isDisplayed();
	}
	
	
	public boolean isMyAccountLinkExist()
	{
		return driver.findElement(myAccount).isDisplayed();
	}
	
	public List<String> getAccountPageHeaderList(){
		List<WebElement> headersList = driver.findElements(accHeaders);
		List<String> headerValList = new ArrayList<String>();
		for(WebElement e : headersList ) {
			String text = e.getText();
			headerValList.add(text);
		}
		return headerValList;
	}
	
	public ResultsPage doSearch(String searchTerm) {
		driver.findElement(search).sendKeys(searchTerm);
		driver.findElement(searchIcon).click();
		return new ResultsPage(driver);
	}
}
