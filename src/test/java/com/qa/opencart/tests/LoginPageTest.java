package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}

	@Test
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginPageURL();
		Assert.assertTrue(actUrl.contains("route=account/login"));
	}

	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test
	public void checkH2HeaderListTest() {
		List<String> expectedHeaderList = new ArrayList<String>();
		expectedHeaderList.add("New Customer");
		expectedHeaderList.add("Returning Customer");
		List<String> actualHeaderList = loginPage.getH2HeaderList();
		Assert.assertEquals(actualHeaderList, expectedHeaderList);

	}

	@Test(priority = 1)
	public void LoginTest() {
		 accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
