package com.qa.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ebay.base.TestBase;

public class Categories extends TestBase
{

	@FindBy(linkText="Samsung Galaxy S8 G950U 64gb 4G LTE Unlocked Smartphone")
	WebElement S8searchresult1;
	
	public Categories()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public BuyProduct selects8searchresult1()
	{
		S8searchresult1.click();
		return new BuyProduct();
	}
		
	
	
}
