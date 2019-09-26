package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SFDC_LoginPage 
{
	
	private static WebElement element=null;
	public static WebElement enterUsername(WebDriver driver) {
		element=driver.findElement(By.id("username"));
		return element;
	}
	public static WebElement selectPasswordBox(WebDriver driver) {
		element=driver.findElement(By.id("password"));
		return element;

	}
	public static WebElement loginbtn(WebDriver driver) {
		element=driver.findElement(By.id("Login"));
		return element;
	}
	public static WebElement errmsg(WebDriver driver) {
		element=driver.findElement(By.xpath("//div[@id='error']"));
		return element;
	}
	public static WebElement rememberMeChkbx(WebDriver driver) {
		element=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		return element;
	}
	public static WebElement gotoprofile(WebDriver driver) {
		element=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(element).click().perform();
		return element;
	}
	public static WebElement logout(WebDriver driver) {
		element=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		return element;
	}
	
		
}
