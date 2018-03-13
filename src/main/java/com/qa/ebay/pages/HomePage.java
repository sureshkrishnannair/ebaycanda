package com.qa.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ebay.base.TestBase;

public class HomePage extends TestBase
{
	
	//Page Objects
	
	@FindBy(xpath="//li[@class='hl-cat-nav__active']")
	WebElement Homepage_Click;
	
	@FindBy(xpath="//li[@class='saved']")
	WebElement Save_Click;
	
	@FindBy(linkText = "Fashion")
	WebElement Fashion_Click;
	
	@FindBy(linkText = "Auto Parts")
	WebElement AutoParts_Click;
	
	@FindBy(linkText = "Electronics")
	WebElement Electronics_Click;
	
	@FindBy(linkText = "Sporting Goods")
	WebElement SportingGoods_Click;
	
	@FindBy(linkText = "Toys & Hobbies")
	WebElement ToysHobbies_Click;
	
	@FindBy(linkText = "Home & Garden")
	WebElement HomeGarden_Click;
	
	@FindBy(linkText = "Collectibles & Art")
	WebElement CollectiblesArt_Click;
	
	@FindBy(linkText = "Deals")
	WebElement Deals_Click;
	
	@FindBy(linkText = "Gift Cards")
	WebElement GiftCards_Click;
	
	
	//Initialize
	public  HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions 
	
	public String ValidateHomeTitle()
	{
		return driver.getTitle();
	}
	
	public SavePage SavedLinkClick()
	{
		 Save_Click.click();
		 return new SavePage();
	}
	
	public ElectronicsPage ElectronicsLinkClick()
	{
		Electronics_Click.click();
		 return new ElectronicsPage();
	}
	

}
