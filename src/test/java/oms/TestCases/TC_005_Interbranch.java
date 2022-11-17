package oms.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_005_Interbranch {
	
	@Test
	public void interbranch() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://omsdemo.medikabazaar.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("irfan.pinjari@medikabazaar.com");
		driver.findElement(By.name("password")).sendKeys("Hello@123");
		driver.findElement(By.xpath("//button")).click();

		Reporter.log("TEST CASE ID: XXXXXX",true);
		WebElement order_tab = driver.findElement(By.xpath("//a[text()=' Orders ']"));
		order_tab.click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//a[text()=' Interbranch Orders ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Inter Branch Order']")).click();
		WebElement Source_warehouse = driver.findElement(By.id("from_location"));
		Select sc=new Select (Source_warehouse);
		sc.selectByValue("32");
		WebElement to_warehouse = driver.findElement(By.id("to_location"));
		Select sc1=new Select(to_warehouse);
		sc1.selectByValue("17");
		driver.findElement(By.id("recipient_email")).clear();
		driver.findElement(By.id("recipient_email")).sendKeys("irfan.pinjari@medikabazaar.com",Keys.ENTER);
		driver.findElement(By.id("logistic_form_submit")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Select from Product List']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//input[@placeholder=\"Search\"]")).sendKeys("MedO741");
		Thread.sleep(7000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"85629\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"product_85629\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"product_85629\"]")).sendKeys("2");
		jse.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(500);
		driver.findElement(By.id("mass-add-to-cart")).click();
		Thread.sleep(7000);
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Save Product']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("shipped_by")).sendKeys("Irfan pinjari",Keys.ENTER);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(1000); 
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table//tr[2]//td[1]//a")).click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,350)");
		Thread.sleep(500);
		WebElement order_status_ = driver.findElement(By.xpath("//td[text()='Pick and Pack']"));
        if(order_status_.isDisplayed())
        {
        	Reporter.log("Step:1 InterBranch order is created successfuly and verify Passed",true);
        }
        else
        {
        	Reporter.log("Step:1 InterBranch order is not created successfuly and verify Failed",true);
        }
		jse.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(500);
		WebElement courier_type = driver.findElement(By.id("courier_type"));
		Select sc2=new Select (courier_type);
		sc2.selectByValue("1");
		WebElement GST = driver.findElement(By.id("gst_available"));
		Select sc3=new Select(GST);
		sc3.selectByVisibleText("Yes");
		driver.findElement(By.id("es_tat")).sendKeys("4");
		driver.findElement(By.id("distance_in_km")).sendKeys("250");
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//table//td[@class=\"day\" and text()='15']")).click();
		WebElement order_status = driver.findElement(By.id("order_status"));
		Select sc4=new Select(order_status);
		sc4.selectByValue("22");
		driver.findElement(By.id("comment")).sendKeys("Created by Irfan ");
		driver.findElement(By.id("transporter_gst_no")).sendKeys("22AAAAA0000A1Z5");
		driver.findElement(By.id("transporter_name")).sendKeys("TaTa");
		driver.findElement(By.id("logistic_form_submit")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()='Update Finance Info']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("invoiceNumber")).sendKeys("554433");
		driver.findElement(By.id("invoiceDate")).click();
		driver.findElement(By.xpath("//td[@class=\"today day\"]")).click();
		driver.findElement(By.id("invoiceAttachment")).sendKeys("C:\\Users\\irfan.pinjar\\Desktop\\Dummy.pdf");
		driver.findElement(By.id("update_tally_details_form_btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()=' Orders ']")).click();
		driver.findElement(By.xpath("//a[text()=' Interbranch Orders ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("shipped_by")).sendKeys("Irfan pinjari",Keys.ENTER);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(1000); 
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table//tr[2]//td[1]//a")).click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,350)");
		Thread.sleep(1000);
		WebElement Validate_message = driver.findElement(By.xpath("//a[text()='Download Invoice']"));
        if(Validate_message.isDisplayed())
        {
        	Reporter.log("Step:2 InterBranch Order Invoice is Generated and Verify Passed ",true);
        }
        else
        {
        	Reporter.log("Step:2 InterBranch Order Invoice is not Generated and Verify Failed ",true);
        }
        jse.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(500);
		WebElement order = driver.findElement(By.id("order_status"));
		Select sc8=new Select (order);
		sc8.selectByValue("1");
		driver.findElement(By.name("comment")).sendKeys("Dispatched By Irfan");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		WebElement dispatched_message = driver.findElement(By.xpath("//td[text()='Dispatched']"));
		if(dispatched_message.isDisplayed())
		{
			Reporter.log("Step:3 InterBranch order Dispatched Done and verify Passed ",true);
		}
		else
		{
			Reporter.log("Step:3 InterBranch order Dispatched Failed",true);

		}
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(500);
		WebElement order_Status = driver.findElement(By.name("order_status"));
		Select sc10=new Select (order_Status);
		sc10.selectByValue("2");
		driver.findElement(By.name("comment")).sendKeys("Delivered By Irfan");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		WebElement delivered_message = driver.findElement(By.xpath("//td[text()='Delivered']"));
		if(delivered_message.isDisplayed())
		{
			Reporter.log("Step:4 InterBranch order Delivered and verify Passed ",true);
		}
		else
		{
			Reporter.log("Step:4 InterBranch order is not Delivered Failed",true);

		}
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(500);
		driver.findElement(By.name("comment")).sendKeys("Inward By Irfan");
		jse.executeScript("window.scrollBy(0,350)");
		Thread.sleep(500);
		driver.findElement(By.id("product_id_select_all")).click();
		driver.findElement(By.id("inward_stock_submit")).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		WebElement inward_message = driver.findElement(By.xpath("//td[text()='Stock Inwarded']"));
		if(inward_message.isDisplayed())
		{
			Reporter.log("Step:5 InterBranch order stock Inwarded and Verify Passed",true);
		}
		else
		{
			Reporter.log("Step:5 InterBranch order stock is not  Inwarded and Verify Failed",true);
		}
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()='Update Finance Info']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Approve']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(500);
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		WebElement GRN_Report = driver.findElement(By.xpath("//a[text()='Download GRN Report']"));
		if(GRN_Report.isDisplayed())
		{
			Reporter.log("Step:6 InterBranch Finance Info is Updated and Verify Passed",true);
			Reporter.log("Step:7 InterBranch Test Script is Passed ",true);
		}
		else
		{
			Reporter.log("Step:6 InterBranch Finance Info is not Updated and Verify Failed",true);
			Reporter.log("Step:7 InterBranch Test Script is Failed ",true);
		}
			    Thread.sleep(2000);
		        driver.findElement(By.id("navbarDropdown")).click();
		        Thread.sleep(400);
		        driver.findElement(By.xpath("(//button[@class=\"dropdown-item\"])[2]")).click();
		        driver.close();
	}
}
