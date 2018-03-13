package com.qa.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ebay.base.TestBase;

public class ElectronicsPage extends TestBase

{
	
	//Page Objects
	@FindBy(id="mainTitle")
	WebElement ElectronicsLabel;
	
	@FindBy(linkText="Cell Phones")
	WebElement CellPhoneLink;
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Samsung')]")
	WebElement SamsungLink;
	
	@FindBy(xpath="//img[@alt='Samsung Galaxy S8+ G955 64GB Unlocked Smartphone']")
	WebElement Samsung8plus;
	
	@FindBy(xpath="//a[contains(text(),'your cart')]")
	WebElement Cart;
	
	@FindBy(xpath="//img[@id='gh-logo']")
	WebElement HomeReturn;
	
	//Initiate Page Objects
	public ElectronicsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyElectronicspagetitle()
	{
		return driver.getTitle();
	}
	
	public String verifyElectronicsPageLabel()
	{
		return ElectronicsLabel.getText();
	}
	
	public void CellphoneLinkSelection()/////
	{
		CellPhoneLink.click();
	}
	
	public Samsungcellphoneandsamortphone SamsungLinkSelection()
	{
		SamsungLink.click();
		return new Samsungcellphoneandsamortphone();
	}
	
	public void Samsung8plusLinkSelection()
	{
		Samsung8plus.click();
	}
	
	public void AddtoCart()
	{
		Cart.click();
	}
	
	public void HomepagefmElectronicsbuyflow()
	{
		HomeReturn.click();
	}
	
	
	

}
