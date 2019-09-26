package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.SFDC_LoginPage;

public class loginErrorTestmsg 
{		static int resultflag = 0;
private static WebDriver driver=null;

@BeforeTest
public  void setUpTest() {
	String ProjectPath=System.getProperty("user.dir");
	System.out.println("ProjectPath: "+ProjectPath);
	System.setProperty("webdriver.gecko.driver",ProjectPath+"/Drivers/GeickoDriver/geckodriver");
	//System.setProperty("webdriver.chrome.driver", ProjectPath+"/Drivers/ChromeDriver/chromedriver");
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.get("https://login.salesforce.com/");

}
@Test(priority=1)
public static void loginErrMsgTest() {
	SFDC_LoginPage.enterUsername(driver).sendKeys("raji_salesforce@sales.com");
	SFDC_LoginPage.selectPasswordBox(driver).clear();
	SFDC_LoginPage.loginbtn(driver).click();
	String errormessage = SFDC_LoginPage.errmsg(driver).getText();
	if (errormessage.equals("Please enter your password.")){
		resultflag = 1;
	}
	else {
		resultflag = 0;
	}
}
@Test(priority=2)
public static void logintoSFDC() {
	SFDC_LoginPage.enterUsername(driver).sendKeys("raji_salesforce@sales.com");
	SFDC_LoginPage.selectPasswordBox(driver).sendKeys("Test@2019!");
	SFDC_LoginPage.loginbtn(driver).click();
}
@Test(priority=3)
public static void remeberMeTest() {
	SFDC_LoginPage.enterUsername(driver).sendKeys("raji_salesforce@sales.com");
	SFDC_LoginPage.selectPasswordBox(driver).sendKeys("Test@2019!");
	SFDC_LoginPage.loginbtn(driver).click();
	SFDC_LoginPage.rememberMeChkbx(driver).click();
	SFDC_LoginPage.gotoprofile(driver).click();
	SFDC_LoginPage.logout(driver).click();
}
@AfterTest
public void tearDownTest() {
	driver.close();
	System.out.println("Test Sucessfully Completed");

}
}
