package oms.TestCases;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepository.Create_PO_OMS_MedikabazaarPage;
import com.ObjectRepository.Getting_Started_OMS_MedikabazaarPage;
import com.ObjectRepository.PO_MasterModule_OMS_MedikabazaarPage;
import com.ObjectRepository.PO_OMS_MedikabazaarPage;
import com.ObjectRepository.Purchase_Order_OMS_MedikabazaarPage;
import com.ObjectRepository.loginPage;
import com.oms.GenericLibrary.BaseUtilityClass;
import com.oms.GenericLibrary.WebdriverActionclass;

public class TC_002_CreatePurchaseOrderTest extends BaseUtilityClass {

	@Test
	public void purchase_order() throws InterruptedException, AWTException{
		
		Getting_Started_OMS_MedikabazaarPage homepage=new Getting_Started_OMS_MedikabazaarPage(driver);
		Purchase_Order_OMS_MedikabazaarPage puchase_order=new Purchase_Order_OMS_MedikabazaarPage(driver);
		Create_PO_OMS_MedikabazaarPage create_PO_page=new Create_PO_OMS_MedikabazaarPage(driver);
		WebdriverActionclass webaction=new WebdriverActionclass(driver);
		PO_OMS_MedikabazaarPage PO_created_page=new PO_OMS_MedikabazaarPage(driver);
		PO_MasterModule_OMS_MedikabazaarPage PO_master_page=new PO_MasterModule_OMS_MedikabazaarPage(driver);
		Purchase_Order_OMS_MedikabazaarPage purchase_order=new Purchase_Order_OMS_MedikabazaarPage(driver);


		Reporter.log("Test Case Id: XXXXXX",true);
		
		homepage.getPurchase_tab().click();
		homepage.getPurchase_order_option().click();
		puchase_order.getCreate_Purchase_Order_button().click();
		create_PO_page.getSupplier_email_textfield().sendKeys("TestSupplier1122@yopgmail.com");
		create_PO_page.getSubmit_button().click();
		webaction.select_dd_by_index(create_PO_page.getPayment_terms_DD(),3);
		webaction.scrolldown_By_element(create_PO_page.getProduct_sku_textfield());
		Thread.sleep(1000);
		create_PO_page.getProduct_sku_textfield().sendKeys("MedO741");
		Thread.sleep(500);
		webaction.scrollBy_value("0","-150");
		Thread.sleep(300);
		create_PO_page.getQuantity_textfield().clear();
		create_PO_page.getQuantity_textfield().sendKeys(Keys.NUMPAD1);
		create_PO_page.getAdd_product_button().click();
		Thread.sleep(2000);
		webaction.scrolldown_By_element(create_PO_page.getProduct_sku_textfield());
		Thread.sleep(1000);
		create_PO_page.getHSN_Code_textfield().sendKeys("989885544");
		create_PO_page.getFirstIteam_check_box().click();
		create_PO_page.getUpdate_cart_button().click();
		webaction.scrollBy_bottom();
		Thread.sleep(4000);
		create_PO_page.getShipping_charge_textfield().clear();
		create_PO_page.getShipping_charge_textfield().sendKeys("55");
		create_PO_page.getShipping_update_button().click();
		webaction.scrollBy_bottom();
		Thread.sleep(500);
		create_PO_page.getCreate_purchase_order_button().click();
		webaction.alert_accept();
		String PO_number = PO_created_page.getPO_ID().getText();
		Reporter.log(PO_number,true);
		if(PO_created_page.getConfirm_img().isDisplayed())
		{
			Reporter.log("Step:1 P.O Created Successfully And Verify Passed ",true);
		}
		else
		{
			Reporter.log("Step:1 Parches Order is not created verify Failed",true);
		}
		Thread.sleep(500);
		PO_created_page.getView_PO_details().click();
		Thread.sleep(1000);
		webaction.select_dd_by_value(PO_master_page.getVerification_status_dd(),"13");
		PO_master_page.getComment_textfield().sendKeys("Approverd By Irfan");
		PO_master_page.getSumbit_button().click();	
		Thread.sleep(500);
		PO_master_page.getPO_status_and_comment_bucket().click();
		Thread.sleep(500);
		if(PO_master_page.getProcure_approved_text().isDisplayed())
		{
			Reporter.log("Step:3 P.O Approved By Procurement And Verify Passed ",true);	
		}
		else
		{
			Reporter.log("Step:3 P.O is Not Approve By Procurement And Verify Failed ",true);
		}
		Thread.sleep(2000);
		homepage.getUser_logo().click();
		Thread.sleep(400);
		homepage.getLogout_button().click();
		Thread.sleep(500);
		loginPage log_page=new loginPage(driver);
		log_page.getLogin_app("kishor.dhuri@gmail.com", "onward@123");
		webaction.maximumWindow();
		homepage.getPurchase_tab().click();
		homepage.getPurchase_order_option().click();
		Thread.sleep(500);
		purchase_order.getPO_master_item_bucket().click();
		purchase_order.getPrepared_by_dd().sendKeys("Irfan Pinjari",Keys.ENTER);
		purchase_order.getSearch_button().click();
		purchase_order.getFirst_PO_Id().click();
		Thread.sleep(500);
		webaction.select_dd_by_value(PO_master_page.getVerification_status_dd(),"9");
		PO_master_page.getComment_textfield().sendKeys("Approverd By Irfan");
		PO_master_page.getSumbit_button().click();
		Thread.sleep(500);
		PO_master_page.getPO_status_and_comment_bucket().click();
		Thread.sleep(500);
		if(PO_master_page.getFinance_approve_text().isDisplayed())
		{
			Reporter.log("Step:4 P.O Approved By Finance And Verify Passed ",true);	
		}
		else
		{
			Reporter.log("Step:4 P.O is Not Approve By Finance And Verify Failed  ",true);
		}
		Thread.sleep(2000);
		homepage.getUser_logo().click();
		Thread.sleep(400);
		homepage.getLogout_button().click();
		Thread.sleep(500);
		log_page.getLogin_app("irfan.pinjari@medikabazaar.com", "Hello@123");
		webaction.maximumWindow();
        homepage.getPurchase_tab().click();
        homepage.getPurchase_order_option().click();
        Thread.sleep(400);
        puchase_order.getPO_master_item_bucket().click();
        purchase_order.getPrepared_by_dd().sendKeys("Irfan Pinjari",Keys.ENTER);
		purchase_order.getSearch_button().click();
		purchase_order.getFirst_PO_Id().click();
		Thread.sleep(500);
		webaction.scrollBy_value("0","500");
        Thread.sleep(500);
		PO_master_page.getQa_check_box().click();
		PO_master_page.getInvoice_number_textfield().sendKeys("56432091");
		PO_master_page.getInvoice_amount_textfield().clear();
		PO_master_page.getInvoice_amount_textfield().sendKeys("2100");
		PO_master_page.getInvoice_attachment_textfield().sendKeys("C:/Users/irfan.pinjar/Desktop/Dummy.pdf");
		webaction.scrollBy_value("0","500");
		Thread.sleep(400);
		PO_master_page.getSelect_all_checkbox().click();
		PO_master_page.getSumbit_button().click();
		webaction.alert_accept();
		Thread.sleep(500);
		webaction.scrollBy_value("0","500");
		Thread.sleep(300);
		PO_master_page.getSumbit_button().click();
		Thread.sleep(500);
		PO_master_page.getPO_inward_history_bucket().click();
		Thread.sleep(500);
		if(PO_master_page.getAccepet_order_text().isDisplayed())
		{
			Reporter.log("Step:5 Stock Inwarded Successfully And Verify Passed ",true);
		}
		else
		{
			Reporter.log("Step:5 Stock Inward is Not Done and Verify Failed ",true);

		}
		String PO_Number = PO_master_page.getPO_number().getText();
		String GRN_Number=PO_master_page.getGRN_number().getText();
		Reporter.log("PO ID : "+PO_Number+" GRN number : "+GRN_Number,true);
		
	}

}
