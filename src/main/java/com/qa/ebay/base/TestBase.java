package com.qa.ebay.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.ebay.utilis.TestUtil;





public class TestBase 
{
	
	public static Properties prop;
	public static WebDriver driver;


	public TestBase(){ //Constructer
	try 
	{

		prop = new Properties();

		FileInputStream ip = new FileInputStream("C:/Users/suresh/workspace1/ebay/src/main/java/com/qa/ebay/config/config.properties");

		//C:\Users\suresh\workspace1\ebay\src\main\java\com\qa\ebay\config\config.properties
		prop.load(ip); //establish connection with config file

	} catch (FileNotFoundException e)
	{

		e.printStackTrace();

	} catch (IOException e)	
	
	{

		e.printStackTrace();

	}

}
	
public static void initialization()
	
	{

		String browserName = prop.getProperty("browser");

		

		if(browserName.equals("chrome")){

			System.setProperty("webdriver.chrome.driver", "C:/Suresh/Selenium Configuration/chromedriver.exe");	
			
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("disable-infobars");

			driver = new ChromeDriver(options); 
			//driver=new HtmlUnitDriver();

		}

		else if(browserName.equals("FF")){

			System.setProperty("webdriver.gecko.driver", "C:/Suresh/Selenium Configuration/geckodriver.exe");	

			driver = new FirefoxDriver(); 

		}
		
		else if(browserName.equals("IE")){

			System.setProperty("webdriver.ie.driver", "C:/Suresh/Selenium Configuration/IEDriverServer.exe");	

			driver = new InternetExplorerDriver(); 

		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

}


}
