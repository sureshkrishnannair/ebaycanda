package com.qa.ebay.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ebay.base.TestBase;
import com.qa.ebay.pages.ElectronicsPage;
import com.qa.ebay.pages.HomePage;
import com.qa.ebay.pages.Samsungcellphoneandsamortphone;
import com.qa.ebay.utilis.TestUtil;

public class SamsungcellphoneandsamortphoneTest extends TestBase

{

	
	HomePage objhome;
	ElectronicsPage objele;
	Samsungcellphoneandsamortphone objsam;
	
	public SamsungcellphoneandsamortphoneTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objhome=new HomePage();
		objele=new ElectronicsPage();
		//objsam=new Samsungcellphoneandsamortphone();
		
		objhome.ElectronicsLinkClick();
		objele.CellphoneLinkSelection();
		objsam=objele.SamsungLinkSelection();
						
	}
	
	
	@Test(priority=1)
	public void Validates8searchTest()
	{
		objsam.Validates8search();
	}
	
	@Test(priority=2)
	public void submitsearchTest()
	{
		objsam.Validates8search();
		objsam.submitsearch();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	@AfterMethod()
	public void teardown()
	{
		driver.close();
	}
	
	
}
