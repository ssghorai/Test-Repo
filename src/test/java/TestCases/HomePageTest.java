package TestCases;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;

public class HomePageTest extends BaseClass 
{
	 //public HomePage HP_Object;
	
	public HomePageTest() throws FileNotFoundException 
	{
		super();
	}

	
	@BeforeMethod
	
	public void openbrowser() 
	{
	initilization();
	}
	
	
	@Test
	public void loginmenutest() throws FileNotFoundException
	{
		
		//HP_Object.validate_PageTitle();
		HP_Object = new HomePage();
		HP_Object.Clickon_LoginLink();
		
		String LoginText = driver.findElement(By.xpath("//p[contains(text(),'Sign In to your account')]")).getText();
		
		Assert.assertEquals(LoginText, "Sign In to your account", "This is not the Login Page.");
	}
	
	
	
	@AfterMethod
	public void closewindow()
	{
		driver.quit();
	}
	
}
