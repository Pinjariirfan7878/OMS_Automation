package oms.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_003_Create_MIB_OrderTest {
	
	@Test
	public void create_MIB_order() throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://omsdemo.medikabazaar.com/login");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("irfan.pinjari@medikabazaar.com");
		driver.findElement(By.name("password")).sendKeys("Hello@123");
		driver.findElement(By.xpath("//button")).click();

		WebElement order_tab = driver.findElement(By.xpath("//a[text()=' Orders ']"));
		order_tab.click();	
		driver.findElement(By.xpath("//a[text()=' MIB Orders ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Create MIB Order']")).click();
		driver.findElement(By.id("customer_email")).sendKeys("TestCustomer1122@yopmail.com");
		driver.findElement(By.id("change_email")).click();
		driver.findElement(By.id("reference_order_no")).sendKeys("");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		driver.findElement(By.name("sku")).sendKeys("MBKRISON001");
		driver.findElement(By.name("qty")).sendKeys("0");
		driver.findElement(By.xpath("//button[text()='Add product']")).click();

		Thread.sleep(10000);

		jse.executeScript("window.scrollBy(0,700)");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name=\"updateitemlist[]\"]")).click();
		driver.findElement(By.xpath("//button[text()='Update Cart']")).click();
		Thread.sleep(10000);
		jse.executeScript("window.scrollBy(0,800)");
		Thread.sleep(700);
		driver.findElement(By.xpath("//input[@name=\"total_warranty_period_year\"]")).sendKeys("");
		driver.findElement(By.xpath("//button[text()=' Save']")).click();
		jse.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		jse.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(),'Request to Verify Budget')]")).click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,1100)");
		WebElement MIB_status = driver.findElement(By.xpath("//span[text()='Sent For Approval']"));
		String confir_message="Sent For Approval";
		String actual_message=MIB_status.getText();
		Assert.assertEquals(confir_message,actual_message);
		Reporter.log("Step:1 MIB Order Sent For Approval ",true);

		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,-1200)");
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=' Orders ']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=' MIB Orders ']")).click();
		WebElement BDE_dropdown = driver.findElement(By.id("bde"));
		Select sc= new Select(BDE_dropdown);
		String BDE_Name="Irfan Pinjari";
		sc.selectByValue(BDE_Name);

		String Approval_text="Sent For Approval";
		WebElement Approval_status = driver.findElement(By.id("approval_status"));
		Select sc1=new Select(Approval_status);
		sc1.selectByVisibleText(Approval_text);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table//tr[*]//td[2]//a")).click();
		Thread.sleep(1000);
		WebElement status_dropdown = driver.findElement(By.id("verification_status"));
		Select sc2=new Select(status_dropdown);
		sc2.selectByVisibleText("Approved");
		driver.findElement(By.id("comment")).sendKeys("Approved By Irfan");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		WebElement comfir_message1 = driver.findElement(By.xpath("(//span[text()='Approved'])[1]"));
		String Actual_status=comfir_message1.getText();
		String Expected_status="Approved";
		Assert.assertEquals(Expected_status, Actual_status);
		Reporter.log("Step:2 MIB Order Budget is Approved ",true);
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=' Orders ']")).click();	

		driver.findElement(By.xpath("//a[text()=' MIB Orders ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Create MIB Order']")).click();
		driver.findElement(By.id("customer_email")).sendKeys("TestCustomer1122@yopmail.com");
		driver.findElement(By.id("change_email")).click();
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name=\"updateitemlist[]\"]")).click();
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement confir_place_order_message = driver.findElement(By.xpath("//p[contains(text(),'ORDER ID :')]"));

		if(confir_place_order_message.isDisplayed())
		{
			Reporter.log(" Step:3 MIB Order is Created Successfully",true);
		}
		else
		{
			Reporter.log("Step:3 MIB Order is not Created Successfully",true);
		}
		WebElement confir_msg = driver.findElement(By.xpath("//h3"));
		String actual_msg=confir_msg.getText();
		String expected_msg="Thank You! Irfan Pinjari";
		Assert.assertEquals(expected_msg,actual_msg);
		Reporter.log("Step:4 MIB Order Placed and Verified Pass",true);

		Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='View Order']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Logistic Detail']")).click();
        driver.findElement(By.id("pickAndPack")).click();
        WebElement select_warehouse_name_DD = driver.findElement(By.id("fulfillmentcenter"));
      
        Select sc3=new Select(select_warehouse_name_DD);
        sc3.selectByValue("32");
       
        jse.executeScript("window.scrollBy(0,250)");
        Thread.sleep(500);
        driver.findElement(By.id("full")).click();
        driver.findElement(By.id("logistic_form_submit")).click();
        Thread.sleep(2000);
       
        String Value = driver.findElement(By.xpath("(//td[@class=\"dispatchqty\"])[1]")).getText();
        int Dispatch_Qty=Integer.parseInt(Value);
        System.out.println("Dispatch Qty Are "+Dispatch_Qty);
        jse.executeScript("window.scrollBy(0,300)");
        List<WebElement> available_stock = driver.findElements(By.xpath("//span[@class=\"availablestock\"]"));
        
        for(WebElement stock:available_stock) 
        {
        	
        	String available_value=stock.getText();
        	
        	System.out.println(available_value);
        	int ava_stock=Integer.parseInt(available_value);
        	if(ava_stock>=Dispatch_Qty)
        	{
        		System.out.println(ava_stock);
        		driver.findElement(By.xpath("(//input[@type=\"number\"]/ancestor::div[@class=\"col\"])[3]//input")).sendKeys(Value);
        		break;
        	}
        }
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        driver.findElement(By.id("process-btn")).click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(1500);
        Reporter.log("Step:5 MIB Order Pick & Pack Successfully Created ",true);
        driver.findElement(By.xpath("//a[text()='View']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("select2-courier_type-container")).click();
        driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("Fedex",Keys.ENTER);
        driver.findElement(By.id("select2-gst-container")).click();
        driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("Yes",Keys.ENTER);
        driver.findElement(By.id("es_tat")).sendKeys("2");
        driver.findElement(By.id("distance")).sendKeys("270");
        driver.findElement(By.name("transporter_name")).sendKeys("auto");
        driver.findElement(By.name("gstno")).sendKeys("22AAAAA0000A1Z5");
        driver.findElement(By.id("comment")).sendKeys("Pick & pack Done By Irfan ");
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
       // driver.findElement(By.xpath("//a[text()='Update Tally Info']")).click();
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
        Reporter.log("Step:6 MIB Order Shipment created successfully",true);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[text()='View'])[2]")).click();
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,450)");
        Thread.sleep(500);
        WebElement shipping_status = driver.findElement(By.id("order_status"));
        Select sc4=new Select(shipping_status);
        sc4.selectByValue("2");
        driver.findElement(By.id("shipping_comment")).sendKeys("done by Irfan");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(500);
        WebElement comfir_text = driver.findElement(By.xpath("//td[text()='Delivered']"));
        if(comfir_text.isDisplayed())
        {
        	Reporter.log("Step:7 MIB Order Product is Delivered",true);
        	Reporter.log("Step:8 MIB Order Flow Test Script is Passed",true);
        }
        else
        {
        	Reporter.log("Step:7 MIB Order Product is not Delivered",true);
        	Reporter.log("MIB Order Flow Test Script is Failed",true);
        }
        Thread.sleep(2000);
        driver.findElement(By.id("navbarDropdown")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("(//button[@class=\"dropdown-item\"])[2]")).click();
        driver.close();
        
           
        
        
	}

}
