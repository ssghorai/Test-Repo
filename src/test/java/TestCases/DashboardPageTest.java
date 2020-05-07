package TestCases;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;

public class DashboardPageTest extends BaseClass
{

	public DashboardPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() throws FileNotFoundException
	{
	  initilization();
	  LP_Object= new LoginPage();
	  
	}
	
	@Test
	public void GoToDashboardTest()
	{
		DP_Object=LP_Object.login();
		
	}
}
