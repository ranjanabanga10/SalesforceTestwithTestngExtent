package Test;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.SFDC_LoginPageObject;

public class SFDC_LoginPageTest {

	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test;
	
	static WebDriver driver=null;
	@BeforeSuite
	public void setUp() {
		 htmlReporter = new ExtentHtmlReporter("extent.html");
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	}
	@BeforeTest
	public void setUpTest() {
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath: "+projectPath);
		//		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver");
		//		driver=new ChromeDriver();

		System.setProperty("webdriver.gecko.driver",projectPath+"/Drivers/GeickoDriver/geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public static void loginErrMsgTest() throws Exception {
		SFDC_LoginPageObject sfdcloginpage=new SFDC_LoginPageObject(driver);

		test = extent.createTest("Launch Firefox browser", "To validate if password field blank..");
		driver.get("https://login.salesforce.com/");
		sfdcloginpage.enterUsername("raji_salesforce@sales.com");
        test.log(Status.PASS, "Username entered Sucessfully.");
        
        sfdcloginpage.selectPasswordBox();
        test.pass("Clear the password field");
        
        sfdcloginpage.loginbtn();
        test.pass("Login Button clicked");
        
        sfdcloginpage.errmsg();
        test.pass("Validated error message");
        // log with snapshot
        test.fail("Error display at blank password field", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");

	}
	@Test(priority=2)
	public static void logintoSFDC() {

		SFDC_LoginPageObject sfdcloginpage=new SFDC_LoginPageObject(driver);
		test = extent.createTest("Login to SFDC", "Validate for login sucessfully.");
		sfdcloginpage.enterUsername("raji_salesforce@sales.com");
		test.pass("Entered username");
		sfdcloginpage.enterPassword("Test@2019!");
		test.pass("Password entered");
		sfdcloginpage.loginbtn();
		test.pass("Login button clicked.");
		//sfdcloginpage.gotoprofile();
		//sfdcloginpage.logout();

	}
	@Test(priority=3)
	public static void remeberMeTest() {
		SFDC_LoginPageObject sfdcloginpage=new SFDC_LoginPageObject(driver);
		test = extent.createTest("Login to SFDC", "Validate for rememberme checkbox clicked.");
		sfdcloginpage.enterUsername("raji_salesforce@sales.com");
		test.pass("Entered username");
		sfdcloginpage.enterPassword("Test@2019!");
		test.pass("Password entered");
		sfdcloginpage.rememberMebx();
		test.pass("Remember me checkbox clicked sucessfully.");
		sfdcloginpage.loginbtn();
		test.pass("Login button clicked.");
		sfdcloginpage.gotoprofile();
		test.info("Selected user menu options..");
		sfdcloginpage.logout();
		test.pass("Logout button clicked");
		

	}
	@Test(priority=4)
	public static void forgotpassword4ATest() {
		SFDC_LoginPageObject sfdcloginpage=new SFDC_LoginPageObject(driver);
		test = extent.createTest("Login to SFDC", "Validate for forgot password.");
		sfdcloginpage.forgotPassword4A();
		test.info("Clicked on forgot password");
		sfdcloginpage.enterUserName("raji_salesforce@sales.com");
		test.info("Enter username for forgot password.");
		sfdcloginpage.continuebtn();
		test.pass("Continue button clicked");
	}
	
	@Test(priority=5)
	public static void forgotpassword4BTest() {
		SFDC_LoginPageObject sfdcloginpage=new SFDC_LoginPageObject(driver);
		test = extent.createTest("Login to SFDC", "Validate for wrong username and wrong password.");
		sfdcloginpage.enterUsername("123");
		test.info("Enter wrong username.");
		sfdcloginpage.enterPassword("22131");
		test.info("Enter wrong password");
		sfdcloginpage.loginbtn();
		test.pass("Login button clicked.");
		sfdcloginpage.errmsgwrongusrpwd();
		test.info("validate error message.");
		
	}
	@Test(priority=6)
	public static void usrmenuDropDownTest() {
		SFDC_LoginPageObject sfdcloginpage=new SFDC_LoginPageObject(driver);
		test = extent.createTest("Login to SFDC", "Validate for select user drop down menu.");
		sfdcloginpage.enterUsername("raji_salesforce@sales.com");
		test.pass("Entered username");
		sfdcloginpage.enterPassword("Test@2019!");
		test.pass("Entered password.");
		sfdcloginpage.loginbtn();
		test.pass("Clicked Login button");
		sfdcloginpage.gotoprofile();
		test.info("Displayed user menu options");
		
	}
	@AfterTest
	public void teardownTest() {

		driver.close();
		
		System.out.println("Test cases sucessfully completed....");
	}
	@AfterSuite
	public void tearDown() {
		extent.flush();
		
	}

}
