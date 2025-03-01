package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle= accPage.getaccPagetitle();
		
	}
	
	@Test
	public void accPageHeaderListCount() {
		List<String> actHeaderList= accPage.getAccountPageHeaderList();
		Assert.assertEquals(actHeaderList.size(), 4);
	}
	
	@Test
	public void accPageHeadersList() {
		List<String> actAccHeaderList= accPage.getAccountPageHeaderList();
		List<String> expAccHeaderList = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
		Assert.assertEquals(actAccHeaderList, expAccHeaderList);
	}
	
	
}
