package TestCases;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageClients;
import utilities.ExcelUtility;

public class ManageClientTest extends BaseClass
{
	//LoginPage LoginPage_Object;
	//HomePage HP_Object;
	//ManageClients MC_Object;
	 
	 
	// Creating the constructor
	public ManageClientTest()
	{
	// By Super keyword, we are using the base Class Constructor 	
		super();
	}
	
	@BeforeMethod
	public void setup() throws FileNotFoundException, InterruptedException
	{
		initilization();
		HP_Object = new HomePage();
	    HP_Object.Clickon_LoginLink();
	    
	    LP_Object = new LoginPage();
	    LP_Object.login();
	    Thread.sleep(3000);
	    
	    MC_Object = new ManageClients();
	}
	
	
	@Test(enabled = false)
	public void OpenManageClientPage() throws InterruptedException
	{
	
		MC_Object.ClickOnManageClient();
	}
	
	@Test(enabled = false)
	public void addclienttest() throws InterruptedException
	{
		
		MC_Object.ClickOnManageClient();
		MC_Object.AddClient("Amit", "Ghorai", "ag@mailinator.com","Female", "22/08/1991", "0201010110");
	}
	
	@Test(priority=1)
	public void addclienttestfromexcel() throws InterruptedException
	{
		ExcelUtility utility = new ExcelUtility("E:\\workspace\\Interview_TCG\\src\\main\\java\\TestData\\ClientSheet.xlsx");
		int rowno =utility.getRowCount("Client info");
		
		for(int i=2; i<=rowno; i++)
		{
			String FirstName = utility.getCellData("Client info", "First Name", i);
			String LastName=utility.getCellData("Client info", "Last Name", i);
			String Email =utility.getCellData("Client info", "Email", i);
			String Phone=utility.getCellData("Client info", "Phone", i);
			String Gender=utility.getCellData("Client info", "Gender", i);
			String DOB=utility.getCellData("Client info", "DOB", i);
			
			System.out.println("The vaules are " +FirstName +LastName);
			MC_Object.ClickOnManageClient();
			MC_Object.AddClient(FirstName, LastName, Email,Gender, DOB, Phone);
		}
		
		
	}
		
	@Test(enabled = false)
	public void SearchClientTest() throws InterruptedException
	{
		MC_Object.ClickOnManageClient();
		MC_Object.SearchClient("agfdfsdf@mailinator.com");
	}
	
	@Test(enabled= false)
	public void ViewProfileTest() throws InterruptedException
	{
	  MC_Object.ClickOnManageClient();
	  MC_Object.SearchClient("cbillanyb@wunderground.com");
	  MC_Object.ViewProfile();
	}
	
	@Test(enabled=false)
	public void FlieUploadTest() throws InterruptedException
	{
	  MC_Object.ClickOnManageClient();
	  MC_Object.SearchClient("cbillanyb@wunderground.com");
      MC_Object.ViewProfile();
      MC_Object.AddFiles("New Test File 3", "This is only for testing purpose", "C:\\Users\\SHYAM\\Desktop\\Add Client.docx");
	}
	
	@Test(enabled=false)
	public void GetClietnListbyStatusTest() throws InterruptedException
	{
		MC_Object.ClickOnManageClient();
	    Thread.sleep(1000);
	    MC_Object.GetClietnListbyStatus("Inactive");
	}
	
	@Test(enabled=false)	
	public void ExportAllClientListTest() throws InterruptedException
	{
	 MC_Object.ClickOnManageClient();
	 Thread.sleep(1000);
	 MC_Object.ExportClientList();	
	}
	
	@Test(enabled=false)
	public void ExportActiveClientListTest() throws InterruptedException
	{
	 MC_Object.ClickOnManageClient();
	 Thread.sleep(1000);
	 MC_Object.GetClietnListbyStatus("Active");
	 Thread.sleep(2000);
	 MC_Object.ExportClientList();
	}
	
	@Test(enabled=false)	
	public void ExportInactiveClientListTest() throws InterruptedException
	{
	 MC_Object.ClickOnManageClient();
	 Thread.sleep(1000);
	 MC_Object.GetClietnListbyStatus("Inactive");
	 Thread.sleep(2000);
	 MC_Object.ExportClientList();
		
	}
	
	
}
