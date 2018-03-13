package com.qa.ebay.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ebay.base.TestBase;
import com.qa.ebay.pages.HomePage;
import com.qa.ebay.utilis.TestUtil;

public class HomePageTest extends TestBase

{
	HomePage objhome;
	
	public HomePageTest() //constructer
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objhome=new HomePage();
	}
	
	@Test
	public void ValidateHomeTitleTest()
	{
			String Actual_HomeTitle=objhome.ValidateHomeTitle();
			String Expected_HomeTitle="Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
			Assert.assertEquals(Actual_HomeTitle, Expected_HomeTitle);
			//TestUtil.Capturescreenshot("HomeTitlePass");
			//TestUtil.Capturescreenshot("ValidateHomeTitleTest");
			
		/*try{
			Assert.assertEquals(Actual_HomeTitle, Expected_HomeTitle);
			TestUtil.Capturescreenshot("HomeTitle_Pass");
		}
		catch(Exception e){
			TestUtil.Capturescreenshot("HomeTitle_Fail");
			
		}*/
		
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		//TestUtil.Capturescreenshot("TearDown");
		driver.close();
	}
	

}
