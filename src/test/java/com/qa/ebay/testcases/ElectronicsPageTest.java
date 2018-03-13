package com.qa.ebay.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ebay.base.TestBase;
import com.qa.ebay.pages.ElectronicsPage;
import com.qa.ebay.pages.HomePage;
import com.qa.ebay.pages.Samsungcellphoneandsamortphone;
import com.qa.ebay.utilis.TestUtil;

public class ElectronicsPageTest extends TestBase {
	
	HomePage objhome;
	ElectronicsPage objele;
	Samsungcellphoneandsamortphone objsam;
	
	public ElectronicsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objhome=new HomePage();
		objele=new ElectronicsPage();
		objhome.ElectronicsLinkClick();
		//objsam=new Samsungcellphoneandsamortphone();
		
	}
	
	@Test
	public void verifyElectronicspagetitleTest()
	{
		String Expected=objele.verifyElectronicspagetitle();
		String Actual="Electronics - Cell Phones, Computers, Cameras, TV, Audio | eBay";
		Assert.assertEquals(Actual, Expected);
	}
	
	@Test
	public void CellphoneLinkSelectionTest()
	{
		objele.CellphoneLinkSelection();
	}
	
	@Test
	public void SamsungLinkSelectionTest()
	{
		objele.CellphoneLinkSelection();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		objele.SamsungLinkSelection();
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.close();
	}
	

}
