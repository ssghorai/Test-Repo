// Author:Shyam

package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageClients;

public class BaseClass 
{
  public static WebDriver driver;
  public static Properties prop;
  
  public HomePage HP_Object;
  public LoginPage LP_Object;
  public  ManageClients MC_Object;
  public DashboardPage DP_Object;
  
  // Creating the constructor of the base Class
     public BaseClass() 
     {
    	 // Reading the Properties File
    	 
    	 prop = new Properties();
    	 FileInputStream input;
    	 
		try
		{
			input = new FileInputStream("E:\\workspace\\Interview_TCG\\src\\main\\java\\"
			 		+ "Config\\config.properties");
			
			prop.load(input);
		} 
		
		catch (FileNotFoundException e1) 
		{
			
			e1.printStackTrace();
			
		} catch (IOException e) 
		
		 {
		
			e.printStackTrace();
		}
    	 
    	 
     }
	
     public void initilization()
     {
    	 String BrowserName = prop.getProperty("browser");
    	 
    	 if(BrowserName.equalsIgnoreCase("chrome"))
    	 {
    		 System.setProperty("webdriver.chrome.driver", "E:\\workspace\\Interview_TCG\\Drivers\\Chromedriver\\chromedriver.exe");
    		 driver = new ChromeDriver();
    	 }
    	 else
    	 {
         System.out.println("Your browser name in not getting matched");
    	 }
    	 
    	 driver.manage().window().maximize();
    	 //driver.manage().deleteAllCookies();
    	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	 driver.get(prop.getProperty("url"));
     }
     
    public static void calendardatepicker(WebElement element, String value)
     {
    	JavascriptExecutor js =((JavascriptExecutor)driver);
    	js.executeScript("arguments[0].value='"+ value +"';", element);
    	
     }
     
     
     
}
