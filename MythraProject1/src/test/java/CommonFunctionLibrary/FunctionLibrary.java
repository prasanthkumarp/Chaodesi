package CommonFunctionLibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.PropertyFileUtil;

public class FunctionLibrary 
{
	//Any type Browser Open this format
	public static WebDriver StartBrowser(WebDriver driver) throws Throwable, Throwable
	{
		if(PropertyFileUtil.getValueForkey("Browser").equalsIgnoreCase("FireFox"))
		{
			driver =new FirefoxDriver();
		}
		else
			if(PropertyFileUtil.getValueForkey("Browser").equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "CommonJarFiles/chromedriver.exe");
				driver =new ChromeDriver();				
			}
			else
				if(PropertyFileUtil.getValueForkey("Browser").equalsIgnoreCase("IE"))
				{
					System.setProperty("webdriver.ie.driver", "CommonJarFiles/IEDriverServer.exe");
					driver =new InternetExplorerDriver();
				}
		return driver;
	}
	
	// Application open using maximize browser window and enter URL
	public static void openAppliclation(WebDriver driver) throws Throwable, Throwable
	{
		driver.manage().window().maximize();
		driver.get(PropertyFileUtil.getValueForkey("URL"));
	}
	
	//Close Application is using Particular Window Close
	public static void closeApplication(WebDriver driver)
	{
		driver.close();
	}
	
	//Quit Application is using all Windows Close
	public static void quitApplication(WebDriver driver)
	{
		driver.quit();
	}
	
	//click method is using Click any button  
	public static void clickAction(WebDriver driver, String locatortype, String locatorValue)
	{
		if(locatortype.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).click();
		}
		else
			if(locatortype.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorValue)).click();
			}
			else
				if(locatortype.equalsIgnoreCase("xpath"))
				{
					driver.findElement(By.xpath(locatorValue)).click();
				}
				else
					if(locatortype.equalsIgnoreCase("className"))
					{
						driver.findElement(By.className(locatorValue)).click();
					}
					else
						if(locatortype.equalsIgnoreCase("linkText"))
						{
							driver.findElement(By.linkText(locatorValue)).click();
						}
	}
	
	//Sending(Enter) data different path calling TypeAction
	public static void typeAction(WebDriver driver, String locatorType,String locatorValue, String data )
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).clear();
			driver.findElement(By.id(locatorValue)).sendKeys(data);
		}
		else
			if(locatorType.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorValue)).clear();
				driver.findElement(By.name(locatorValue)).sendKeys(data);
			}
			else
				if(locatorType.equalsIgnoreCase("Xpath"))
				{
					driver.findElement(By.xpath(locatorValue)).clear();
					driver.findElement(By.xpath(locatorValue)).sendKeys(data);
				}	}
	
	// Wait Element is using some time waiting 
	public static void waitForElement(WebDriver driver, String locatorType,String locatorValue )
	{
		WebDriverWait wait=new WebDriverWait(driver, 40);
		
		if(locatorType.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		}
		else
			if(locatorType.equalsIgnoreCase("name"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			}
			else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				}
			}
	
	//Project Title Validation method
	public static void titleValidation(WebDriver driver, String act_title)
	{
		String exp_title =driver.getTitle();
		Assert.assertEquals(act_title, exp_title);
	}
	
	//Date format Method
	public static String generateDate()
	{
		Date date= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_SS");
		return sdf.format(date);
	}
	
	//Auto generation Value store text file using Get Attribute
	public static void captureData(WebDriver driver,String locatorType,String locatorValue) throws Throwable
	{
		Thread.sleep(2000);
		String data= "";
		if(locatorType.equalsIgnoreCase("id"))
		{
			data = driver.findElement(By.id(locatorValue)).getAttribute("value");
		}
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				data = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
			}
			else
				if(locatorType.equalsIgnoreCase("name"))
				{
					data = driver.findElement(By.name(locatorValue)).getAttribute("value");
				}
		FileWriter fw=new FileWriter("./CaptureData/Data.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(data);
		bw.flush();
		bw.close();
	}
	
	public static void captureDatatext(WebDriver driver,String locatorType,String locatorValue) throws Throwable
	{
		Thread.sleep(2000);
		String data1= "";
	//	String data2="";
		if(locatorType.equalsIgnoreCase("id"))
		{
			data1 = driver.findElement(By.id(locatorValue)).getText();
			//data2 = driver.findElement(By.id(data)).getText();
		}
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				data1 = driver.findElement(By.xpath(locatorValue)).getText();
			}
			else
				if(locatorType.equalsIgnoreCase("name"))
				{
					data1 = driver.findElement(By.name(locatorValue)).getText();
				}
					
		FileWriter fw=new FileWriter("./CaptureData/Data.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(data1);
		//bw.write(data2);
		bw.flush();
		bw.close();
	}
	
	//Table Validaytion
	public static void tableValidation(WebDriver driver,String colNum) throws Throwable
	{
		FileReader fr=new FileReader("./CaptureData/Data.txt");
		BufferedReader br=new BufferedReader(fr);
		String exp_data=br.readLine();
		
		//Converstion from String to int
		int colNum1=Integer.parseInt(colNum);
		if(driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box"))).isDisplayed())
		{
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box"))).clear();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box"))).sendKeys(exp_data);
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.btn"))).click();
			Thread.sleep(2000);
		}
		else {
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.panel"))).click();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box"))).clear();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box"))).sendKeys(exp_data);
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.btn"))).click();
			Thread.sleep(2000);			
		}
		WebElement webtable=driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Webtable.path")));
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		for(int i=0;i<=rows.size();i++)
		{
			String act_data=driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/form/div/div//table[@class='table ewtable']/tbody/tr["+i+"]/td["+colNum1+"]/div/span/span")).getText();
			Assert.assertEquals(act_data, exp_data);
			break;
		}
	}
	
	//Table Validaytion
	public static void tableValidation1(WebDriver driver,String colNum,String exp_data) throws Throwable
	{
		//Converstion from String to int
		int colNum1=Integer.parseInt(colNum);
		if(driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box1"))).isDisplayed())
		{
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box1"))).clear();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box1"))).sendKeys(exp_data);
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.btn1"))).click();
			Thread.sleep(2000);
		}
		else {
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.panel1"))).click();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box11"))).clear();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.box"))).sendKeys(exp_data);
			//driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Search.btn1"))).click();
			
			//Incase any Button is not working this logic is using
			((JavascriptExecutor)driver).executeScript("document.getElementById('btnSubmit').click()");
			Thread.sleep(2000);			
		}
		WebElement webtable=driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Webtable.path")));
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		for(int i=0;i<=rows.size();i++)
		{
			String act_data=driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/form/div/div//table[@class='table ewtable']/tbody/tr["+i+"]/td["+colNum1+"]/div/span/span")).getText();
			Assert.assertEquals(act_data, exp_data);
			break;
		}
	}
	
	// Mouse Action1
	public static void mouseActionStockItems(WebDriver driver) throws Throwable, Throwable
	{
		WebElement act1=driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("mous1")));
		WebElement act2=driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("mous2")));
		Actions action=new Actions(driver);
		action.moveToElement(act1).build().perform();
		action.moveToElement(act2).click().build().perform();
	}
	// Mouse Action2
		public static void mouseAction(WebDriver driver,String locatorValue,String data) throws Throwable, Throwable
		{
			WebElement act1=driver.findElement(By.xpath(locatorValue));
			WebElement act2=driver.findElement(By.xpath(data));
			Actions action=new Actions(driver);
			action.moveToElement(act1).build().perform();
			action.moveToElement(act2).click().build().perform();
		}	
	// chain Action Test
		public static void chainAction(WebDriver driver,String locatortype,String locatorValue,String data) throws Throwable, Throwable
		{
			WebElement mov_1=driver.findElement(By.xpath(locatortype));
			WebElement mov_2=driver.findElement(By.xpath(locatorValue));
			WebElement mov_3=driver.findElement(By.xpath(data));
			Actions chain=new Actions(driver);
			chain.moveToElement(mov_1).pause(1000).moveToElement(mov_2).pause(1000).moveToElement(mov_3).click().build().perform();
			
		}
	// Duplicate replace new number using random method
	public static void uomIdValidation(WebDriver driver,String locatorType,String locatorValue) throws Throwable
	{
		String act_text = " ";//strorage
		if(locatorType.equalsIgnoreCase("id"))
		{
			act_text = driver.findElement(By.id(locatorValue)).getText();
		}
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				act_text = driver.findElement(By.id(locatorValue)).getText();
			}
			if(act_text.contains("Duplicate primary key")) //duplicate alert inspect name copy past
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("Second_Ok"))).click();
				int randomNum = (int) (Math.random()*9999999); //store 
				String duplicateData = String.valueOf(randomNum);//converting string
				driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("UOM_ID"))).clear();
				driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("UOM_ID"))).sendKeys(duplicateData);
				
			}
	}
	// Drop Down Process 1
	public static void dropDownAction(WebDriver driver, String locatorType,String locatorValue, String data) throws Throwable
	{
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			Select drpdow= new Select(driver.findElement(By.xpath(locatorValue)));
			drpdow.selectByVisibleText(data);
			Thread.sleep(1000);
			drpdow.selectByValue(data);
			Thread.sleep(1000);
		}
		else
		if(locatorType.equalsIgnoreCase("id"))
		{
			Select drpdow= new Select(driver.findElement(By.id(locatorValue)));
			drpdow.selectByVisibleText(data);
			Thread.sleep(1000);
			drpdow.selectByValue(data);
			Thread.sleep(1000);
		}
		else
			if(locatorType.equalsIgnoreCase("name"))
			{
				Select drpdow= new Select(driver.findElement(By.name(locatorValue)));
				drpdow.selectByVisibleText(data);
				drpdow.selectByValue(data);
				Thread.sleep(1000);
			}
			
	}
	// Drop Down Process 2
	public static void dropDownAction1(WebDriver driver) throws Throwable
	{

			Select drpdow= new Select(driver.findElement(By.xpath(PropertyFileUtil.getValueForkey("mous_xpath"))));
			drpdow.selectByVisibleText(PropertyFileUtil.getValueForkey("mous_value"));
			Thread.sleep(1000);
	}
	// Ok Button Click Process 1
	public static void okButton(WebDriver driver,String locatorType,String locatorValue) throws Throwable
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			Thread.sleep(2000);
			List<WebElement> OKS=driver.findElements(By.id(locatorValue));
			for(int i=0;i<OKS.size();i++)
			{
				if(OKS.get(i).getText().equalsIgnoreCase("OK"))
				{
					OKS.get(i).click();
					break;
				}
			}
		}
		else
			if(locatorType.equalsIgnoreCase("name"))
			{
				Thread.sleep(2000);
				List<WebElement> OKS=driver.findElements(By.name(locatorValue));
				for(int i=0;i<OKS.size();i++)
				{
					if(OKS.get(i).getText().equalsIgnoreCase("OK"))
					{
						OKS.get(i).click();
						break;
					}
				}
			}
			else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					Thread.sleep(2000);
					List<WebElement> OKS=driver.findElements(By.xpath(locatorValue));
					for(int i=0;i<OKS.size();i++)
					{
						if(OKS.get(i).getText().equalsIgnoreCase("OK"))
						{
							OKS.get(i).click();
							break;
						}
					}
				}
	}
	// Ok Button Click Process 2
	public static void ok1Button(WebDriver driver,String locatorType,String locatorValue) throws Throwable
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			Thread.sleep(2000);
			List<WebElement> OKS=driver.findElements(By.id(locatorValue));
			for(int i=0;i<OKS.size();i++)
			{
				if(OKS.get(i).getText().equalsIgnoreCase("OK!"))
				{
					OKS.get(i).click();
					break;
				}
			}
		}
		else
			if(locatorType.equalsIgnoreCase("name"))
			{
				Thread.sleep(2000);
				List<WebElement> OKS=driver.findElements(By.name(locatorValue));
				for(int i=0;i<OKS.size();i++)
				{
					if(OKS.get(i).getText().equalsIgnoreCase("OK!"))
					{
						OKS.get(i).click();
						break;
					}
				}
			}
			else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					Thread.sleep(2000);
					List<WebElement> OKS=driver.findElements(By.xpath(locatorValue));
					for(int i=0;i<OKS.size();i++)
					{
						if(OKS.get(i).getText().equalsIgnoreCase("OK!"))
						{
							OKS.get(i).click();
							break;
						}
					}
				}
	}
	
	//Date Handling method Excel Sheet
	public static void dateAction(WebDriver driver,String locatorValue,String data) throws Throwable
	{
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("document.getElementbyId('"+locatorValue+"').value='"+data+"'");
	}
	public static void Screenshot(WebDriver driver,String description) throws Throwable
	{
		Thread.sleep(1000);
		//Generate ScreenShorts
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./Screenshorts/"+description+"_"+FunctionLibrary.generateDate()+".jpg"));
	}
	
	//Particular button click method on Excel Sheet
	public static void buttonAction(WebDriver driver,String locatorType,String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			((JavascriptExecutor)driver).executeScript("document.getElementbyId('"+locatorValue+"').click()");
		}
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				((JavascriptExecutor)driver).executeScript("document.getelementbyxpath('"+locatorValue+"').click()");
			}
				
	}
	// Thread Action Process (This process using Waiting For seconds )
	public static void threadAction(WebDriver driver) throws Throwable
	{
		Thread.sleep(2000);
	}
	// Application Back process
	public static void Backkey(WebDriver driver)
	{
		driver.navigate().back();
	}
	// Application Forward Process
	public static void forward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	//Page Scroll Down Total
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	//Page Scroll Down Given Value Size
	public static void scrollDown2(WebDriver driver, String locatorValue)
	{
		 ((JavascriptExecutor)driver).executeScript("scroll(0,"+locatorValue+")");
	}
	
	//windows Handle is using child window or parent windows handling
	public static void WindowHandle(WebDriver driver)
	{
				//home window page handling
				String homepage=driver.getWindowHandle();
											
				//child window page handling
				Set<String> windows=driver.getWindowHandles();
			
				for (String child : windows) 
				{
					//capturing window id's
					System.out.println(child);
			
					//geving focus to child window
					if(!child.equals(homepage))
					{
						driver.switchTo().window(child);
						driver.manage().window().maximize();
					}}	
	}
	
	// Multiple times Click on Button
	public static void MultiTimeButton(WebDriver driver,String locatorType,String locatorValue) throws Throwable
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
		 WebElement clickElement = driver.findElement(By.id(locatorValue)); 
		 for(int i = 0; i<=5; i++)
		 {
		 clickElement.click();
		 Thread.sleep(3000);
		 }
		 }
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
			 WebElement clickElement = driver.findElement(By.xpath(locatorValue)); 
			 for(int i = 0; i<=5; i++)
			 {
			 clickElement.click();
			 Thread.sleep(3000);
			 }
			 }
			
	}
	
	}
