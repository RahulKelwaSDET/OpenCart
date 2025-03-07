package com.qa.opencart.pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String, String> productInfoMap;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);

	}

	public String getProductHeaderName() {
		return eleUtil.doElementGetText(productHeader);
	}

	public int getProductImagesCount() {
		return eleUtil.waitForElementsVisible(productImages, 10).size();
	}

	public Map<String, String> getProductInfo() {
		getProductMetaData();
		getProuctPriceData();
		return productInfoMap;
	}

	private void getProductMetaData() {
		List<WebElement> metaList = eleUtil.waitForElementsVisible(productMetaData, 5);
		productInfoMap = new LinkedHashMap<String, String>();
		for (WebElement e : metaList) {
			String metaText = e.getText();
			String metaInfo[] = metaText.split(":");
			String key = metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfoMap.put(key, value);

		}
	}

	private void getProuctPriceData() {
		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String priceValue = priceList.get(0).getText();// $2000
		String exTaxPrice = priceList.get(1).getText();
		String exTaxPriceValue = exTaxPrice.split(":")[1].trim();
		productInfoMap.put("productprice", priceValue);
		productInfoMap.put("extaxprice", exTaxPriceValue);
	}

}
