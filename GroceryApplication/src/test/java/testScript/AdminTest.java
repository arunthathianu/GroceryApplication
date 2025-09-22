package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.Select;

import base.TestNGBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase{
	
	@Test(priority = 1)
	public void verifyAddUser() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		
		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signIn_button.click();
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		String usertype = ExcelUtility.getStringData(1, 2, "HomePage");
		
		WebElement adminmoreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminmoreinfo.click();
		
		WebElement new_button = driver.findElement(By.xpath("//a[contains(@class,'btn-danger') and contains(text(),'New')]"));
		new_button.click();
		
		WebElement username_new = driver.findElement(By.xpath("//input[@id='username']"));
		username_new.sendKeys(randomname);
		
		WebElement password_new = driver.findElement(By.xpath("//input[@id='password']"));
		password_new.sendKeys(randompassword);
		
		WebElement dropdown = driver.findElement(By.xpath("//Select[@id='user_type']"));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText(usertype);
		
		WebElement save = driver.findElement(By.xpath("//button[@name='Create']"));
		save.click();
		
	}
	
	@Test(priority = 2, description  = "search the newly added user")
	public void verifysearchUser() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		
		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signIn_button.click();
		
		WebElement adminmoreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminmoreinfo.click();
		
		WebElement search_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		search_button.click();
		
		WebElement search_username = driver.findElement(By.xpath("//input[@id='un']"));
		search_username.sendKeys("margaretta.christiansen");
		
		WebElement dropdown = driver.findElement(By.xpath("//Select[@id='ut']"));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText("Admin");
		
		WebElement search_button_new = driver.findElement(By.xpath("//button[@name='Search']"));
		search_button_new.click();
		 
	}
	
	

}
