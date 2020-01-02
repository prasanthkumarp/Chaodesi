package DriverFactory;

import org.testng.annotations.Test;

public class AppTest 
{
	@Test
	public void KickStart() throws Throwable
	{
DriverScript ds=new DriverScript();
		
		try
		{
			ds.StartTest();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args) throws Throwable 
	{
		DriverScript ds=new DriverScript();
		
		try
		{
			ds.StartTest();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/

}
