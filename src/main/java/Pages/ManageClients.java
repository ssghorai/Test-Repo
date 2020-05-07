package Pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseClass;

public class ManageClients extends BaseClass

{
	@FindBy(xpath="//li[@id='liClients']") WebElement ClientMenu;
	@FindBy(xpath="//*[@id='liClients']/div/div/ul[1]/li/a") WebElement ManageClient;
	@FindBy(xpath="//input[@id='btnOffLineClientAdd']") WebElement AddNewButton;
	@FindBy(xpath="//*[@id='txtCustomID_AddNew']") WebElement ID;
	@FindBy(xpath="//input[@id='txtFirstName_AddNew']") WebElement FName;
	@FindBy(xpath="//input[@id='txtLastName_AddNew']") WebElement LName;
	@FindBy(xpath="//input[@id='txtEmail_AddNew']")WebElement Email;                
	@FindBy(xpath="//input[@id='DateOfBirth']") WebElement DateOfBirth;
	@FindBy(xpath=" //input[@id='txtPhoneNo_AddNew']") WebElement Phone;
	@FindBy(xpath="//input[@id='btnclientsave']") WebElement Submitbtn;
	@FindBy(xpath="//input[@id='txtSearchClient']") WebElement SearchBox;
	@FindBy (xpath="//input[@id='btnSearch']") WebElement SearchBtn;
	@FindBy(xpath="//a[text()='View Profile']") WebElement ViewProfileLink;
	@FindBy(xpath="//h2[@id='ClientName']") WebElement ClientNameOnProfilePage;
	@FindBy(xpath="//h4[@id='h4Document']") WebElement CP_Files;
	@FindBy(xpath="//i[@class='fa ctrl-add-document']")WebElement CP_Files_Addbtn;
	@FindBy(xpath="//input[@id='txtDocumentTitle']") WebElement CP_Files_Title;
	@FindBy(xpath="//textarea[@id='txtDocumentdesc']")WebElement CP_Files_Desc;
	@FindBy(xpath="//input[@name='fileChooseFile']")WebElement CP_Files_ChooseFile;
	@FindBy(xpath="//input[@id='btnUpload']") WebElement CP_Files_Uploadbtn;
	@FindBy(xpath="//*[@id='ddlActiveType_chosen']/a/span") WebElement Status_dd;
	@FindBy(xpath="//input[@id='btnExportClientList']") WebElement Export_btn;
	
	// Creating the constructor of manageClients
	public ManageClients()
	{
		//Initializing the Page factory
		PageFactory.initElements(driver, this);
	}
	
	// Actions or Methods  
	
	public void ClickOnManageClient() throws InterruptedException
	{
		// Doing mouse hover on the Client Menu
		Actions action=new Actions(driver);
		action.moveToElement(ClientMenu).build().perform();
		Thread.sleep(1000);
		ManageClient.click();	
	}

    public void AddClient(String FirstName, String LastName,String Emailid,String Gender,String DOB,String PhoneNo) throws InterruptedException
    {
    	AddNewButton.click();
    	Thread.sleep(2000);
    	FName.sendKeys(FirstName);
    	LName.sendKeys(LastName);
    	Email.sendKeys(Emailid);
    	
    	// This line is for scroll down
    	((JavascriptExecutor)driver).executeScript("scroll(0,500)");
    	
    	driver.findElement(By.xpath("//div[@id='divGender']//i[@data-value='"+Gender+"']")).click();
    	
    	// This line is to send value to DOB field. 
    	calendardatepicker(DateOfBirth,DOB);
    	
    	Phone.sendKeys(PhoneNo);
    	Submitbtn.click();
    	
    	
    }

	public void SearchClient(String Cleintemail) throws InterruptedException
	{
		SearchBox.sendKeys(Cleintemail);
		Thread.sleep(2000);
	    List <WebElement> searchlist = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a/span[3]"));
	    
	    int listsize = searchlist.size();
	    
	    String  flag = "F";
	    
	    for(int i=0; i< listsize; i++)
	    {
	       String vaule =  searchlist.get(i).getText();
	       
	      //System.out.println("the result is" + vaule );
	       
	       if(vaule.equals(Cleintemail))
	       {
	    	   searchlist.get(i).click();
	    	   SearchBtn.click();
	    	   flag = "T";
	    	   break;
	       }        
	    }	
	    
	    if(flag.equals("F"))
	       {
	    	   System.out.println("Sorry. No result found");
	       }
		
	}	
	
    public void ViewProfile() throws InterruptedException
    {
    	// To get the Parent Window id
    	String ParentWindow = driver.getWindowHandle();
    	System.out.println("The parent window id is" +ParentWindow);
    	
    	// Clicking on View Profile Link
    	ViewProfileLink.click();
    	
    	Set<String> AllWindows = driver.getWindowHandles();
    	int count = AllWindows.size();
    	System.out.println("No of windows are" + count);
    	
    	for(String ChildWindow :AllWindows)
    	{
    		if(!ParentWindow.endsWith(ChildWindow))
    		{
    			driver.switchTo().window(ChildWindow);
    			String ClientName = ClientNameOnProfilePage.getText();
    			System.out.println("The Client name is" + ClientName);
    			Thread.sleep(2000);
    			
    			// This line is for scroll down
    	    	((JavascriptExecutor)driver).executeScript("scroll(0,600)");
    	    	
    	    	//Thread.sleep(2000);
    	    	//AddFiles("New Test File 2", "This is only for testing purpose", "C:/Users/SHYAM/Desktop/Add Client.docx");
    			
    		}
    	}
    	
    	
    }
    
    public void AddFiles(String Title, String Desc, String filepath) throws InterruptedException
    {
    	Thread.sleep(2000);
        CP_Files.click();
    	CP_Files_Addbtn.click();
    	CP_Files_Title.sendKeys(Title);
    	CP_Files_Desc.sendKeys(Desc);
    	CP_Files_ChooseFile.sendKeys(filepath);
    	Thread.sleep(3000);
        CP_Files_Uploadbtn.click();  			
    }

    public void GetClietnListbyStatus(String Statusvalue)
    {
    	Status_dd.click();
    	List<WebElement>dd_values=driver.findElements(By.xpath("//ul[@class='chosen-results']//li"));
    	
    	for(int i=0; i<dd_values.size(); i++)
    	{
    	 //Get the values
    		String innerHTML_Values=dd_values.get(i).getAttribute("innerHTML");
    		
    		//System.out.println("The drop down values are" + innerHTML_Values);
    		
    		if(innerHTML_Values.contentEquals(Statusvalue))
    		{
    			dd_values.get(i).click();
    		}
    		
    	}
    	
    	SearchBtn.click();
      }
    
    public void ExportClientList()
    {
    	Export_btn.click();
    }
}

