package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase{
	
	@Test
	public void verifyValidUserNamePasswordLoginCredentials() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		
		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signIn_button.click();
		
	}
	
	@Test
	public void verifyInValidUserNameValidPasswordLoginCredentials() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		
		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signIn_button.click();
		
	}
	
	@Test
	public void verifyValidUserNameInValidPasswordLoginCredentials() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		
		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signIn_button.click();
		
	}
	
	@Test
	public void verifyInValidUserNameInValidPasswordLoginCredentials() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(4, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		
		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signIn_button.click();
		
	}

}
