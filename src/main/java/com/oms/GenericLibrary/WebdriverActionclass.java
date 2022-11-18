package com.oms.GenericLibrary;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
     public void select_dd_by_value(WebElement element,String value)
     {
    	 Select sc=new Select(element);
    	 sc.selectByValue(value);
     }
     public void select_dd_by_visibletext(String visible_text,WebElement element)
     {
    	 Select sc=new Select(element);
    	 sc.selectByValue(visible_text);
     }
     public void select_dd_by_index(WebElement element,int a)
     {
    	 Select sc=new Select (element);
    	 sc.selectByIndex(a);
     }
   
     public void scrolldown_By_element(WebElement element)
     {
    	 Point loc = element.getLocation();
    	 JavascriptExecutor jse=(JavascriptExecutor)driver;
    	 jse.executeScript("window.scrollBy"+loc);
     }
     public void scrollBy_value(String x,String y)
     {
    	 JavascriptExecutor jse=(JavascriptExecutor)driver;
    	 jse.executeScript("window.scrollBy("+x+","+y+")");
    	
     }
     public void scrollBy_bottom()
     {
    	 JavascriptExecutor jse=(JavascriptExecutor)driver;
    	 jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
     }
     public void alert_accept()
     {
    	driver.switchTo().alert().accept(); 
     }
     public void alert_dismiss()
     {
    	 driver.switchTo().alert().dismiss();
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
