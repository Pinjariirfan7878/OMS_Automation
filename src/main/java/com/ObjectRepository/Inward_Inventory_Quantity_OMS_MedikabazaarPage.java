package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inward_Inventory_Quantity_OMS_MedikabazaarPage {
	
	@FindBy(xpath="//button[text()='Submit']") private WebElement submit_button;


	public Inward_Inventory_Quantity_OMS_MedikabazaarPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getSubmit_button() {
		return submit_button;
	}

}
