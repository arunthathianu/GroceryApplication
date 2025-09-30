package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase{
	
	@Test(priority = 1, description = "verify login with valid credentials", retryAnalyzer = retry.Retry.class, groups = {"smoke"})	//flaky testcase
	public void verifyValidUserNamePasswordLoginCredentials() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		
		//WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.clickSignIN();
		
		//WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		//username.sendKeys(usernameValue);
		//password.sendKeys(passwordValue);
		
		//WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
		//signIn_button.click();
		
		String expected = "https://groceryapp.uniqassosiates.com/admin"; //after signin
		
		String actual = driver.getCurrentUrl(); //after signin
		
		Assert.assertEquals(actual,expected,Messages.VALID_LOGIN_ASSERT);
	}
	
	@Test(priority = 2, description = "verfiy with invalid username and valid password", groups = {"smoke"})
	public void verifyInValidUserNameValidPasswordLoginCredentials() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		
//		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		
//		username.sendKeys(usernameValue);
//		password.sendKeys(passwordValue);
//		
//		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
//		signIn_button.click();
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.clickSignIN();
		
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		
		String actual = driver.getCurrentUrl();
		
		Assert.assertEquals(actual, expected, Messages.INVALID_LOGIN_ASSERT);
		
	}
	
	@Test(priority = 3, description = "verify with valid username and invalid password ", groups = {"smoke"})
	public void verifyValidUserNameInValidPasswordLoginCredentials() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);
		
//		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		
//		username.sendKeys(usernameValue);
//		password.sendKeys(passwordValue);
//		
//		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
//		signIn_button.click();
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.clickSignIN();
		
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		
		String actual = driver.getCurrentUrl();
		
		Assert.assertEquals(actual, expected, Messages.INVALID_LOGIN_ASSERT);
		
	}
	
	@Test(priority = 4, description = "verify with invalid username and invaild password", dataProvider = "loginProvider", groups = {"smoke"})
	public void verifyInValidUserNameInValidPasswordLoginCredentials(String usernameValue, String passwordValue) throws IOException
	{
//		String usernameValue = ExcelUtility.getStringData(4, 0, "LoginPage");
//		String passwordValue = ExcelUtility.getStringData(4, 1, "LoginPage");
		
//		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		
//		username.sendKeys(usernameValue);
//		password.sendKeys(passwordValue);
//		
//		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
//		signIn_button.click();
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(usernameValue);
		login.enterPassword(passwordValue);
		login.clickSignIN();
		
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		
		String actual = driver.getCurrentUrl();
		
		Assert.assertEquals(actual, expected, Messages.INVALID_LOGIN_ASSERT);
		
	}
	
	@DataProvider(name="loginProvider")	//returns two dimensional object array
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"user","password"},
			new Object[] {"username","pass"},
			new Object[] {"user1","password1"}
		};
	}

}
