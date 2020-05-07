package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class LoginPage extends BaseClass
{

// Page factory - OR
   @FindBy(xpath="//input[@id='txtEmail']") 
   WebElement Email_field ; 
   
   @FindBy (xpath="//input[@id='txtPassword']") 
   WebElement Password_field;
   
   @FindBy(xpath="//input[@id='btnLogin']") 
   WebElement Login_button;
	
   
   // Constructor of Login Page
	public LoginPage() throws FileNotFoundException
	{
		// Initialize the Page factory 
		PageFactory.initElements(driver, this);
	}

	
	
	// Methods or Actions 
	
	public DashboardPage login()
	{
		Email_field.sendKeys(prop.getProperty("email"));
		Password_field.sendKeys(prop.getProperty("password"));
		Login_button.click();
		return new DashboardPage();
		
	}
	

}
