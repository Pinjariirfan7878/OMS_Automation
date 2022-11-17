package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_PO_OMS_MedikabazaarPage {
	
	@FindBy(xpath="//input[@type=\"email\"]") private WebElement supplier_email_textfield;
	@FindBy(xpath="//button[text()='Submit']") private WebElement submit_button;
	@FindBy(xpath="//select[@id=\"payment_terms\"]") private WebElement payment_terms_DD;
	@FindBy(xpath="//input[@id=\"shipped_by\"]") private WebElement product_sku_textfield;
	@FindBy(xpath="//input[@id=\"qty\"]") private WebElement quantity_textfield;
	@FindBy(xpath="//button[text()='+ Add product']") private WebElement add_product_button;
	@FindBy(xpath="//input[@class=\"form-control text-center numbers hsn_class\"]") private WebElement HSN_Code_textfield;
	@FindBy(xpath="//input[@name=\"updateitemlist[]\"]") private WebElement firstIteam_check_box;
	@FindBy(xpath="//button[@id=\"btnplaneorder\"]") private WebElement create_purchase_order_button;


	public Create_PO_OMS_MedikabazaarPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getSupplier_email_textfield() {
		return supplier_email_textfield;
	}


	public WebElement getSubmit_button() {
		return submit_button;
	}


	public WebElement getPayment_terms_DD() {
		return payment_terms_DD;
	}


	public WebElement getProduct_sku_textfield() {
		return product_sku_textfield;
	}


	public WebElement getQuantity_textfield() {
		return quantity_textfield;
	}


	public WebElement getAdd_product_button() {
		return add_product_button;
	}


	public WebElement getHSN_Code_textfield() {
		return HSN_Code_textfield;
	}


	public WebElement getFirstIteam_check_box() {
		return firstIteam_check_box;
	}


	public WebElement getCreate_purchase_order_button() {
		return create_purchase_order_button;
	}



	

}
