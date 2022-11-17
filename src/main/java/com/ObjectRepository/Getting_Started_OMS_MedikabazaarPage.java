package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Getting_Started_OMS_MedikabazaarPage {
	
	@FindBy (xpath="//a[text()=' Purchases ']") private WebElement purchase_tab ;
	@FindBy (xpath="//a[text()=' Purchase Orders ']") private WebElement purchase_order_option;
	@FindBy(xpath="//a[@id=\"navbarDropdown\"]") private WebElement user_logo;
	@FindBy(xpath="(//button[@class=\"dropdown-item\"])[2]") private WebElement logout_button;


	public Getting_Started_OMS_MedikabazaarPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getPurchase_tab() {
		return purchase_tab;
	}


	public WebElement getPurchase_order_option() {
		return purchase_order_option;
	}


	public WebElement getUser_logo() {
		return user_logo;
	}


	public WebElement getLogout_button() {
		return logout_button;
	}


}
