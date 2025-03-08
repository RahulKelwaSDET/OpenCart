package com.qa.opencart.pojo;

public class Product {
	private String searchKey;
	private String productName;
	private int productImageCount;

	public Product(String searchKey, String productName, int productImages) {
		this.searchKey = searchKey;
		this.productName = productName;
		this.productImageCount = productImages;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductImageCount() {
		return productImageCount;
	}

	public void setProductImageCount(int productImages) {
		this.productImageCount = productImages;
	}

	@Override
	public String toString() {
		return "Product [searchKey=" + searchKey + ", productName=" + productName + ", productImages=" + productImageCount
				+ "]";
	}

}
