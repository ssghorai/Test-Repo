package TestCases; 

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;

import Pages.HomePage;
import Pages.LoginPage;

public class LoginPageTest extends BaseClass
{
 //public LoginPage LoginPage_Object;
  //HomePage HP_Object;
	
	
  public LoginPageTest()
	{
	   // By Super(), we are calling the Base class Constructor 
		super();
	}
	
	@BeforeMethod
	
		public void setup() throws FileNotFoundException 
		{
			initilization();
			HP_Object = new HomePage();
		    HP_Object.Clickon_LoginLink();	
		}
	
	
	@Test
	public void logintest() throws FileNotFoundException
	{
		LP_Object = new LoginPage();
		LP_Object.login();
	}

	
	
}
