package oms.TestCases;

import java.util.List;
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

public class TC_004_SalesOrderTest {
	
	@Test
	public void create_sales_orderTest() throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://omsdemo.medikabazaar.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("irfan.pinjari@medikabazaar.com");
		driver.findElement(By.name("password")).sendKeys("Hello@123");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//a[text()=' Orders ']")).click();
		driver.findElement(By.xpath("//a[text()=' Sales Orders ']")).click();
		driver.findElement(By.xpath("//button[text()='+ Create Sales Order']")).click();

		Reporter.log("-Test case Id: xxxx",true);
		driver.findElement(By.id("customer_email")).sendKeys("TestCustomer1122@yopmail.com");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(500);
		driver.findElement(By.id("shipped_by")).sendKeys("MedO741");
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("2");
		driver.findElement(By.id("skusubmit")).click();
		Thread.sleep(20000);
		jse.executeScript("window.scrollBy(0,1800)");
		Thread.sleep(10000);
		driver.findElement(By.name("shipping_price")).clear();
		driver.findElement(By.name("shipping_price")).sendKeys("55");
		driver.findElement(By.xpath("//button[text()='UPDATE']")).click();
		Thread.sleep(500);
		jse.executeScript("window.scrollBy(0,800)");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		Thread.sleep(10000);
		WebElement SO_created_message = driver.findElement(By.xpath("//button[text()='View Order']"));
		
		if(SO_created_message.isDisplayed())
		{
			Reporter.log("Step:1 S.O is Created Successfully",true);
		}
		else
		{
			Reporter.log("Step:1 S.O is not Created",true);
		}
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='View Order']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("logisticDetailNavId")).click();
		driver.findElement(By.id("customer_feedback")).sendKeys("Good support by BDE");
		driver.findElement(By.id("customer-feedback-form_submit")).click();
		Thread.sleep(500);
		WebElement verification_status = driver.findElement(By.id("verification_status"));
		Select sc=new Select (verification_status);
		sc.selectByValue("11");
		Thread.sleep(500);
		jse.executeScript("window.scrollBy(0,800)");
		Thread.sleep(500);
		driver.findElement(By.id("full")).click();
		driver.findElement(By.id("logistic_form_submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id=\"activitySummaryNavId\"]")).click();
		Thread.sleep(1500);
		WebElement Validate_element = driver.findElement(By.xpath("//td[text()='Approved By Procurement']"));
		if(Validate_element.isDisplayed())
		{
			Reporter.log("Step:2 Procurement Verification Done And Verify Passed",true);
		}
		else
		{
			Reporter.log("Step:2 Procurement Verification is not Done And Verify Failed",true);

		}
		Thread.sleep(1000);
		driver.findElement(By.id("navbarDropdown")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath("(//button[@class=\"dropdown-item\"])[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.name("email")).sendKeys("kishor.dhuri@gmail.com");
		driver.findElement(By.name("password")).sendKeys("onward@123");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//a[text()=' Orders ']")).click();
		driver.findElement(By.xpath("//a[text()=' Sales Orders ']")).click();
		WebElement BDE_DD = driver.findElement(By.id("cbde"));
		Select sc1=new Select(BDE_DD);
		sc1.selectByValue("711");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//table//tr[1]//td[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.id("logisticDetailNavId")).click();
        Thread.sleep(500);
        WebElement verification_status_fin = driver.findElement(By.id("verification_status"));
        Select sc3=new Select(verification_status_fin);
        sc3.selectByValue("9");
        driver.findElement(By.id("full")).click();
        jse.executeScript("window.scrollBy(0,300)");
        Thread.sleep(500);
		driver.findElement(By.id("logistic_form_submit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id=\"activitySummaryNavId\"]")).click();
		Thread.sleep(1500);
		WebElement Validate_element_fin = driver.findElement(By.xpath("//td[text()='Approved By Finance']"));
		if(Validate_element_fin.isDisplayed())
		{
			Reporter.log("Step:3 Finance Verification Done And Verify Passed");
		}
		else
		{
			Reporter.log("Step:3 Finance Verification is not Done And Verify Failed");

		}
		driver.findElement(By.id("navbarDropdown")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath("(//button[@class=\"dropdown-item\"])[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.name("email")).sendKeys("kishor.dhuri82@gmail.com");
		driver.findElement(By.name("password")).sendKeys("onward@123");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//a[text()=' Orders ']")).click();
		driver.findElement(By.xpath("//a[text()=' Sales Orders ']")).click();
		WebElement BDE_DD_1 = driver.findElement(By.id("cbde"));
		Select sc4=new Select(BDE_DD_1);
		sc4.selectByValue("711");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//table//tr[1]//td[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.id("logisticDetailNavId")).click();
        Thread.sleep(500);
        driver.findElement(By.id("pickAndPack")).click();
        Thread.sleep(500);
        WebElement Select_warehouse_name = driver.findElement(By.id("fulfillmentcenter"));
        Select sc5=new Select(Select_warehouse_name);
        sc5.selectByValue("32");
        jse.executeScript("window.scrollBy(0,300)");
        Thread.sleep(500);
        driver.findElement(By.id("full")).click();
        Thread.sleep(500);
        driver.findElement(By.id("logistic_form_submit")).click();
        Thread.sleep(2000);
        String Dispatch_Qty_ = driver.findElement(By.xpath("(//td[@class=\"dispatchqty\"])[1]")).getText();
        int Dispatch_Qty=Integer.parseInt(Dispatch_Qty_);
        System.out.println("Dispatch Qty Are :"+Dispatch_Qty);
    
        jse.executeScript("window.scrollBy(0,300)");
        List<WebElement> available_stock = driver.findElements(By.xpath("//span[@class=\"availablestock\"]"));
        
        for(WebElement stock:available_stock) 
        {
        	
        	String available_value=stock.getText();
        	int ava_stock=Integer.parseInt(available_value);
        	if(ava_stock>=Dispatch_Qty)
        	{
        		System.out.println(ava_stock);
        		driver.findElement(By.xpath("(//input[@type=\"number\"]/ancestor::div[@class=\"col\"])[7]//input")).sendKeys(Dispatch_Qty_);
        		break;
        	}
        }
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
        driver.findElement(By.id("process-btn")).click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(1500);
        WebElement View_button = driver.findElement(By.xpath("//a[text()='View']"));
        if(View_button.isDisplayed())
        {
            Reporter.log("Step:4 Pick & Pack Created for S.O",true);
        }
        else
        {
            Reporter.log("Step:4 Pick & Pack Created for S.O",true);
        }
        driver.findElement(By.xpath("//a[text()='View']")).click();
        Thread.sleep(500);
        WebElement courier_type = driver.findElement(By.id("select2-courier_type-container"));
        courier_type.click();
        driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("Fedex",Keys.ENTER);
        driver.findElement(By.id("select2-gst-container")).click();
        driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("Yes",Keys.ENTER);
        driver.findElement(By.id("es_tat")).sendKeys("4");
        driver.findElement(By.id("distance")).sendKeys("250");
        driver.findElement(By.name("transporter_name")).sendKeys("tata");
        driver.findElement(By.id("gstno")).sendKeys("22AAAAA0000A1Z5");
        driver.findElement(By.id("comment")).sendKeys("Pick & Pack Done By Irfan");
        
        jse.executeScript("window.scrollBy(0,400)");
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[text()='Save']")).click();
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[text()='Generate Invoice']")).click();
        System.out.println(" Information sent successfully to finance.");
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[text()='Update Finance Info']")).click();
        
        Thread.sleep(500);
        driver.findElement(By.id("invoiceNumber")).sendKeys("7766554433");
        driver.findElement(By.id("invoiceDate")).click();
        driver.findElement(By.xpath("//td[@class=\"today day\"]")).click();
      
        driver.findElement(By.xpath("//input[@name=\"invoiceAttachment\"]")).sendKeys("C:/Users/irfan.pinjar/Desktop/Dummy.pdf");
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        Thread.sleep(500);
        
        driver.navigate().refresh();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()=' Orders ']")).click();
        driver.findElement(By.xpath("//a[text()=' Sales Orders ']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("cbde")).sendKeys("Irfan Pinjari");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//table//tr[*]//td[2]//a)[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[text()='Activity Summary']")).click();
        driver.findElement(By.xpath("//a[text()='View']")).click();
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[text()='Final Dispatch']")).click();
        Reporter.log("Step:5 Sales Order Shipment created successfully",true);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[text()='View'])[2]")).click();
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,450)");
        Thread.sleep(500);
        WebElement shipping_status = driver.findElement(By.id("order_status"));
        Select sc6=new Select(shipping_status);
        sc6.selectByValue("2");
        driver.findElement(By.id("shipping_comment")).sendKeys("done by Irfan");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(500);
        WebElement comfir_text = driver.findElement(By.xpath("//td[text()='Delivered']"));
        if(comfir_text.isDisplayed())
        {
        	Reporter.log("Step:6 Sales Order Product is Delivered",true);
        	Reporter.log("Step:7 Sales Order Flow Test Script is Passed",true);
        }
        else
        {
        	Reporter.log("Step:6 Sales Order Product is not Delivered",true);
        	Reporter.log("Step:7 Sales Order Flow Test Script is Failed",true);
        }
        Thread.sleep(2000);
        driver.findElement(By.id("navbarDropdown")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("(//button[@class=\"dropdown-item\"])[2]")).click();
        driver.close();
              
	}

}
