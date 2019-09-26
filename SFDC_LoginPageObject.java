package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SFDC_LoginPageObject {
	
	static int resultflag = 0;
	WebDriver driver=null;
	By Uname=By.id("username");
	By password=By.id("password");
	By loginbtn=By.id("Login");
	By errmsg=By.xpath("//div[@id='error']");
	By rememberMe=By.xpath("//input[@id='rememberUn']");
	By gotoProfile=(By.xpath("//span[@id='userNavLabel']"));
	By logout=By.xpath("//a[contains(text(),'Logout')]");
	By forgotPassword=By.xpath("//*[@id='forgot_password_link']");
	By Uname1=By.xpath("//input[@id='un']");
	By Continuebtn=By.xpath("//input[@id='continue']");
	
	
	public SFDC_LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void enterUsername(String text) {
		driver.findElement(Uname).sendKeys(text);
	}
	public void selectPasswordBox() {
		driver.findElement(password).clear();
	}
	public void enterPassword(String text) {
		driver.findElement(password).sendKeys(text);
	}
	public void loginbtn() {
		driver.findElement(loginbtn).click();
	}
	public void errmsg() {
		String errormessage = 	driver.findElement(errmsg).getText();
		if (errormessage.equals("Please enter your password.")){
			resultflag = 1;
			System.out.println(errormessage);
		}
		else {
			resultflag = 0;
		}
	}
	public void errmsgwrongusrpwd() {
		String Errormsg=driver.findElement(errmsg).getText();
		String ActualError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		if(ActualError.equals(Errormsg)) {
	        System.out.println("Test Case Passed");
	    }else{
	        System.out.println("Test Case Failed");
	    }
		
	}
	public void rememberMebx() {
		driver.findElement(rememberMe).click();
	}
	public void gotoprofile() {
		WebElement usrmenu=driver.findElement(gotoProfile);
		Actions actions=new Actions(driver);
		actions.moveToElement(usrmenu).click().perform();
		
	}
	public void forgotPassword4A() {
		driver.findElement(forgotPassword).click();
	}
	public void enterUserName(String text) {
		driver.findElement(Uname1).sendKeys(text);
	}
	public void continuebtn() {
		driver.findElement(Continuebtn).click();
	}
	public void logout() {
		driver.findElement(logout).click();
	}
	

}
