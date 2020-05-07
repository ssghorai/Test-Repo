package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class HomePage extends BaseClass
{
	// Page factory - OR
	
	@FindBy(xpath="//li[@class='red']//a[contains(text(),'Login / Signup')]") 
	WebElement LoginLink;
	
	// Creating the constructor of the Home Page
	public HomePage() throws FileNotFoundException
	{
		// Initializing the Page Factory / Page Objects
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions OR Metohds
	
	public String validate_PageTitle()
	{
		return driver.getTitle();
		
		
	}
	
	public LoginPage Clickon_LoginLink() throws FileNotFoundException
	{
		LoginLink.click();
		return new LoginPage();
	}
}

