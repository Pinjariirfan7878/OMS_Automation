package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_MasterModule_OMS_MedikabazaarPage {
	
	@FindBy(xpath="//select[@id=\"verification_status\"]") private WebElement verification_status_dd;
	@FindBy(xpath="//input[@name=\"comment\"]") private WebElement comment_dd;
	@FindBy(xpath="//button[text()='Submit']") private WebElement sumbit_button;
	@FindBy(xpath="//button[text()='PO Status And Comment']") private WebElement PO_status_and_comment_bucket;
	@FindBy(xpath="//td[text()='Approved By Finance']") private WebElement finance_approve_text;
	@FindBy(xpath="//td[text()='approved By Irfan']") private WebElement procure_approve_text;
	@FindBy(xpath="//input[@id=\"qa_check\"]") private WebElement qa_check_box;
	@FindBy(xpath="//input[@id=\"invoice_id\"]") private WebElement invoice_number_textfield;
	@FindBy(xpath="//input[@id=\"invoice_date\"]") private WebElement invoice_date_textfield;
	@FindBy(xpath="//input[@id=\"invoice_amount\"]") private WebElement invoice_amount_textfield;
	@FindBy(xpath="//input[@id=\"invoice_attachment\"]") private WebElement invoice_attachment_textfield;
	@FindBy(xpath="//input[@id=\"full\"]") private WebElement select_all_checkbox;
	@FindBy(xpath="//button[text()='PO Inward History']") private WebElement PO_inward_history_bucket;
	@FindBy(xpath="//button[text()='Accepted Order']") private WebElement accepet_order_text;



	public PO_MasterModule_OMS_MedikabazaarPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getVerification_status_dd() {
		return verification_status_dd;
	}
	public WebElement getComment_dd() {
		return comment_dd;
	}
	public WebElement getSumbit_button() {
		return sumbit_button;
	}
	public WebElement getPO_status_and_comment_bucket() {
		return PO_status_and_comment_bucket;
	}
	public WebElement getFinance_approve_text() {
		return finance_approve_text;
	}
	public WebElement getProcure_approve_text() {
		return procure_approve_text;
	}
	public WebElement getQa_check_box() {
		return qa_check_box;
	}
	public WebElement getInvoice_number_textfield() {
		return invoice_number_textfield;
	}
	public WebElement getInvoice_date_textfield() {
		return invoice_date_textfield;
	}
	public WebElement getInvoice_amount_textfield() {
		return invoice_amount_textfield;
	}
	public WebElement getInvoice_attachment_textfield() {
		return invoice_attachment_textfield;
	}
	public WebElement getSelect_all_checkbox() {
		return select_all_checkbox;
	}
	public WebElement getPO_inward_history_bucket() {
		return PO_inward_history_bucket;
	}
	public WebElement getAccepet_order_text() {
		return accepet_order_text;
	}


}
