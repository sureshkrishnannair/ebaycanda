package com.qa.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ebay.base.TestBase;

public class BuyProduct extends TestBase
{
	
	@FindBy(id="isCartBtn_btn")
	WebElement AddtoCart;
	
	
	public BuyProduct()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void ValiateAddtoCart()
	{
		AddtoCart.click();
	}

}
