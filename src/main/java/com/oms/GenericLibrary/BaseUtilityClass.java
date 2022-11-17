package com.oms.GenericLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepository.loginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtilityClass  implements IAutoconstant{
	
WebDriver driver;
	
	@BeforeSuite
	public void connectToDB()
	{
		System.out.println("Connected to DB");
	}
	@AfterSuite
	public void disconnectToDB()
	{
		System.out.println("Disconnected to DB");

	}
	@BeforeClass
	public void launchBrowser()
	{
		String browser="chrome";
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Please Enter Valid Browser Name");
		}
		driver.get("https://omsdemo.medikabazaar.com/login");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void login()
	{
		loginPage log_page=new loginPage(driver);
		log_page.getLogin_app("irfan.pinjari@medikabazaar.com", "Hello@123");
	
	}
	
	@AfterClass
	public void close() throws Exception
	{
		Thread.sleep(2000);
        driver.findElement(By.id("navbarDropdown")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("(//button[@class=\"dropdown-item\"])[2]")).click();
        driver.close();
	}



}
