package com.oms.GenericLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverActionclass extends BaseUtilityClass {
	
	public WebdriverActionclass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void maximumWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void implicitlywait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void explicitywait(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
     public void moveToElement(WebElement element)
     {
    	Actions ac=new Actions(driver);
    	ac.moveToElement(element).perform();
     }
}
