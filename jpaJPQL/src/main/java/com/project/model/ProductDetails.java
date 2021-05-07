package com.project.model;

public class ProductDetails {

	private String productName;
	
	private double unitPrice;
	
	private int avaible;
	
	private String brandName;
	
	private String categoryName;
	
	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}

	public ProductDetails(String productName, double unitPrice, int avaible, String brandName, String categoryName) {
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.avaible = avaible;
		this.brandName = brandName;
		this.categoryName = categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getAvaible() {
		return avaible;
	}

	public void setAvaible(int avaible) {
		this.avaible = avaible;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ProductDetails [productName=" + productName + ", unitPrice=" + unitPrice + ", avaible=" + avaible
				+ ", brandName=" + brandName + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
