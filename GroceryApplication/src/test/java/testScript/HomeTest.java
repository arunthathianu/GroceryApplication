package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase{
	
	
	@Test(description = "verify the logout")
	public void verifyLogout() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		
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
		
//		WebElement admin_button = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
//		admin_button.click();
//		
//		WebElement logout_button = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
//		logout_button.click();
		
		HomePage home_page = new HomePage(driver);
		
		home_page.admin_Login();
		home_page.admin_Logout();
		
		
		String actual = "https://groceryapp.uniqassosiates.com/admin/login";
		
		String expected = driver.getCurrentUrl();
		
		Assert.assertEquals(actual, expected,"Not succuessfully Logout");
	}
	


}
