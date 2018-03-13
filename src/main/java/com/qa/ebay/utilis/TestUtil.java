package com.qa.ebay.utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ebay.base.TestBase;



public class TestUtil extends TestBase
{
	public static int PAGE_LOAD_TIMEOUT=20;
	public static int IMPLICIT_WAIT=20;
	
	
	//Switch Frame
		public static void switchframe()
		{
			driver.switchTo().frame("mainpanel");
		}
		
		//Implicit wait
		public void Implicitwait()
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		
		//Read Excel Data
		
		
			public static String ReadExcelData(String sheetname, int rownum, int colnum) throws IOException
			{
				
				DataFormatter df=new DataFormatter();
				String result="";
				
				//read excel
				try {
				FileInputStream fis=new FileInputStream(new File("C:/Users/suresh/workspace1/CRM/src/main/java/com/crm/qa/testdata/TestData.xlsx").getAbsolutePath());
				
				XSSFWorkbook w = new XSSFWorkbook(fis);
				XSSFSheet s=w.getSheet(sheetname);
				XSSFRow r=s.getRow(rownum);
				XSSFCell col=r.getCell(colnum);
				
				if(col!=null)
				{
					result=df.formatCellValue(col);
				
			}
				}
				
			catch (NullPointerException e) {
					result="";
			}
				
				return result;
			}
			
			
			//Write Excel File
			
			public static String WriteExcelData(String Sheetname,int RowNum,int ColNum,String Policy) throws IOException
			{
				//policy is the data captured through get text method
				
				String result="";
				try
				{
					File src=new File("C:\\Users\\suresh\\workspace1\\CRM\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx");
					FileInputStream fis=new FileInputStream(src);
					XSSFWorkbook wb=new XSSFWorkbook(fis);
					XSSFSheet sh=wb.getSheet(Sheetname);
					sh.getRow(RowNum).createCell(ColNum).setCellValue(Policy);
					
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					fout.close();
				}
				
				catch(NullPointerException e)
				{
					result="";
				}
				
				return result;
				
			}
			
		//Close Browser
			
			public static void closebrowser()
			{
				driver.close();
				driver.quit();
			}
		
			//Screenshot capture
			
			public static void Capturescreenshot(String screenshotname)
			{
				//C:\Users\suresh\workspace1\ebay\src\main\java\com\qa\ebay\screenshot
				try{
					TakesScreenshot ts=(TakesScreenshot)driver;
					File source=ts.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(source, new File("C:/Users/suresh/workspace1/ebay/src/main/java/com"
							+ "/qa/ebay/screenshot/"	+screenshotname+".png"));
					}
				
				catch(Exception e)
				{
					System.out.println("Exception taking screenshot"+e.getMessage());
				}
				
			}
			
			//Select Dropdown
			
			public static void selectdropdown(WebElement element,String option)
			{
				new Select(element).selectByVisibleText(option);
			}
			
			//Explicit Wait
			
			public static void visible(int seconds,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver,seconds);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			
			public static void clickable(int seconds,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver,seconds);
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
			
			public static void loaded(int seconds,String title)
			{
				WebDriverWait wait=new WebDriverWait(driver,seconds);
				wait.until(ExpectedConditions.titleContains(title));
				driver.manage();
			}
			
			//Calender Today
			
			public static void calender_Home() throws IOException
			
			{	
				String date=TestUtil.ReadExcelData("Sheet1",1,2);
				//System.out.println(date1);
				//String date="28-March-2018";
				String dateArr[]=date.split("-");
				String day= dateArr[0];
				String month=dateArr[1];
				String year= dateArr[2];
				
				Select select=new Select(driver.findElement(By.name("slctMonth")));
				select.selectByVisibleText(month);
				
				Select select1=new Select(driver.findElement(By.name("slctYear")));
				select1.selectByVisibleText(year);
				
				String beforexpath="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
				String afterxpath="]/td[";
				boolean flag=false;
				String dayVal=null;
				
				final int totalWeekDays=7;
				
				for (int rowNum=2;rowNum<7;rowNum++)
				{
					//System.out.println(rowNum);				
					for(int ColNum=1;ColNum<totalWeekDays;ColNum++)
					{
						//System.out.println(ColNum);	
						try{
						dayVal=driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+ColNum+"]")).getText();
						System.out.println(dayVal);
						}catch(NoSuchElementException e)
						{
							flag=false;
						}
						if(dayVal.equals(day))
						{
							driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+ColNum+"]")).click();
							flag=true;
							break;
						}
					}
					if(flag)
					{
						break;
					}
				}
				
				//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
				
			}
			
			//Calender Today ends
			
			//Screenshot for extend report
			public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				// after execution, you could see a folder "FailedTestsScreenshots"
				// under src folder
				String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
						+ ".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);
				return destination;
			}
	
			
			

}
