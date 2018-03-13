package com.qa.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ebay.base.TestBase;

public class Samsungcellphoneandsamortphone extends TestBase {
	
	@FindBy(id="gh-ac")
	WebElement SearchField;
	
	@FindBy(id="gh-btn")
	WebElement SearchButton;
	
	
	public Samsungcellphoneandsamortphone()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void Validates8search()
	{
		SearchField.sendKeys("s8");
	}
	
	public Categories submitsearch()
	{
		SearchButton.click();
		return new Categories();
	}
	

}
