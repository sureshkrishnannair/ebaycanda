package com.qa.ebay.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ebay.base.TestBase;
import com.qa.ebay.pages.Categories;
import com.qa.ebay.pages.ElectronicsPage;
import com.qa.ebay.pages.HomePage;
import com.qa.ebay.pages.Samsungcellphoneandsamortphone;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CategoriesTest extends TestBase
{
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	HomePage objhome;
	ElectronicsPage objele;
	Samsungcellphoneandsamortphone objsam;
	Categories objcat;
	
	public CategoriesTest()
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
		objele.CellphoneLinkSelection();
		objsam=objele.SamsungLinkSelection(); //SAMSUNGCellphoneObject
		objsam.Validates8search();
		objcat=objsam.submitsearch();  //category object
						
	}
	
	
	
	@Test(retryAnalyzer=com.qa.ebay.Analyzer.RetryAnalyzer.class)
	public void selects8searchresult1Test()
	{
		objcat.selects8searchresult1();
	}
	
	@AfterMethod()
	public void teardown()
	{
		driver.close();
	}

}
