package DriverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFunctionLibrary.FunctionLibrary;
import Utilities.ExcelFileUtil;

public class DriverScript 
{
	WebDriver driver;
	ExtentHtmlReporter path;
	ExtentReports report;
	ExtentTest logger;

	public void StartTest() throws Throwable
	{
		ExcelFileUtil excel=new ExcelFileUtil();
		//Module Sheet
	for(int i=1;i<=excel.rowCount("MasterTestCases");i++)
	{
		String ModuleStatus= " ";
		if(excel.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y"))
		
	{
			//Define Module Name
			String TCModule = excel.getData("MasterTestCases", i, 1);
			//Generate Extent Reports 
			path=new ExtentHtmlReporter("./Reports/"+TCModule+".html"+"_"+FunctionLibrary.generateDate());
			report=new ExtentReports();
			report.attachReporter(path);
			logger=report.createTest(TCModule);
			
			int rowcount=excel.rowCount(TCModule);
			//Corresponding Sheet
			for(int j=1;j<=rowcount;j++)
			{
				String Description = excel.getData(TCModule, j, 0);
				String Object_Type = excel.getData(TCModule, j, 1);
				String Locator_Type = excel.getData(TCModule, j, 2);
				String Locator_Value = excel.getData(TCModule, j, 3);
				String Test_Data = excel.getData(TCModule, j, 4);
								
				try
				{
				if(Object_Type.equalsIgnoreCase("StartBrowser"))
				{
					driver = FunctionLibrary.StartBrowser(driver);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("openAppliclation"))
				{
					FunctionLibrary.openAppliclation(driver);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("clickAction"))
				{
					FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("waitForElement"))
				{
					FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("typeAction"))
				{
					FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("closeApplication"))
				{
					FunctionLibrary.closeApplication(driver);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("quitApplication"))
				{
					FunctionLibrary.quitApplication(driver);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("titleValidation"))
				{
					FunctionLibrary.titleValidation(driver, Test_Data);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("captureData"))
				{
					FunctionLibrary.captureData(driver, Locator_Type, Locator_Value);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("tableValidation"))
				{
					FunctionLibrary.tableValidation(driver, Test_Data);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("tableValidation1"))
				{
					FunctionLibrary.tableValidation1(driver, Locator_Value, Test_Data);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("mouseActionStockItems"))
				{
					FunctionLibrary.mouseActionStockItems(driver);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("mouseActionStockItems"))
				{
					FunctionLibrary.mouseActionStockItems(driver);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("mouseAction"))
				{
					FunctionLibrary.mouseAction(driver, Locator_Value, Test_Data);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("chainAction"))
				{
					FunctionLibrary.chainAction(driver, Locator_Type, Locator_Value, Test_Data);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("uomIdValidation"))
				{
					FunctionLibrary.uomIdValidation(driver, Locator_Type, Locator_Value);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("dropDownAction"))
				{
					FunctionLibrary.dropDownAction(driver, Locator_Type, Locator_Value, Test_Data);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("dateAction"))
				{
					FunctionLibrary.dateAction(driver, Locator_Value, Test_Data);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("buttonAction"))
				{
					FunctionLibrary.buttonAction(driver, Locator_Type, Locator_Value);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("threadAction"))
				{
					FunctionLibrary.threadAction(driver);
					logger.log(Status.INFO	, Description);
				}
				if(Object_Type.equalsIgnoreCase("Backkey"))
				{
					FunctionLibrary.Backkey(driver);
					logger.log(Status.INFO	, Description);
				}
				
				if(Object_Type.equalsIgnoreCase("forward"))
				{
					FunctionLibrary.forward(driver);
					logger.log(Status.INFO	, Description);
				}
								
				
				if(Object_Type.equalsIgnoreCase("dropDownAction1"))
				{
					FunctionLibrary.dropDownAction1(driver);
					logger.log(Status.INFO	, Description);
				}
				
				if(Object_Type.equalsIgnoreCase("scrollDown"))
				{
					FunctionLibrary.scrollDown(driver);
					logger.log(Status.INFO, Description);
				}
				if(Object_Type.equalsIgnoreCase("scrollDown2"))
				{
					FunctionLibrary.scrollDown2(driver, Locator_Value);
					logger.log(Status.INFO, Description);
				}
				if(Object_Type.equalsIgnoreCase("captureDatatext"))
				{
					FunctionLibrary.captureDatatext(driver, Locator_Type, Locator_Value);
					logger.log(Status.INFO, Description);
				}
				if(Object_Type.equalsIgnoreCase("MultiTimeButton"))
				{
					FunctionLibrary.MultiTimeButton(driver, Locator_Type, Locator_Value);
					logger.log(Status.INFO, Description);
				}
				if(Object_Type.equalsIgnoreCase("WindowHandle"))
				{
					FunctionLibrary.WindowHandle(driver);
					logger.log(Status.INFO, Description);
				}
				if(Object_Type.equalsIgnoreCase("Screenshot"))
				{
					FunctionLibrary.Screenshot(driver, Description);
					logger.log(Status.INFO, Description);
				}
				excel.setData(TCModule, j, 5, "Pass");
				ModuleStatus="true";	
				logger.log(Status.PASS, Description+ " Pass"); 
				
				}
				catch (Exception e) 
				{
					// TODO: handle exception
					excel.setData(TCModule, j, 5, "Fail");
					ModuleStatus="false";
					logger.log(Status.FAIL, Description+ " Fail");
					//Generate ScreenShorts
					File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(srcFile, new File("./Screenshorts/"+Description+"_"+FunctionLibrary.generateDate()+".jpg"));
					break;
				}
				catch (AssertionError e) 
				{
					// TODO: handle exception
					excel.setData(TCModule, j, 5, "Fail");
					ModuleStatus="false";
					logger.log(Status.FAIL, Description+" Fail");
					//Generate ScreenShorts
					File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(srcFile, new File("./Screenshorts/"+Description+"_"+FunctionLibrary.generateDate()+".jpg"));
					break;
				}
				}
			if(ModuleStatus.equalsIgnoreCase("true"))
			{
				excel.setData("MasterTestCases", i, 3, "Pass");
			}
			else
			if(ModuleStatus.equalsIgnoreCase("false"))
			{
				excel.setData("MasterTestCases", i, 3, "Fail");
			}
			report.flush();
		}
		else
		{
			excel.setData("MasterTestCases", i, 3, "Not Executed");
		}
		
		} } }
