package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase{
	
	AdminPage adminPage;
	HomePage home_page;
	
	@Test(priority = 1)
	public void verifyAddUser() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		
//		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		
//		username.sendKeys(usernameValue);
//		password.sendKeys(passwordValue);
//		
//		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
//		signIn_button.click();
		
		LoginPage login = new LoginPage(driver);
//		login.enterUserName(usernameValue);
//		login.enterPassword(passwordValue);
//		login.clickSignIN();
		login.enterUserName(usernameValue).enterPassword(passwordValue);
		home_page = login.clickSignIN();
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		String usertype = ExcelUtility.getStringData(1, 2, Constants.HOMEPAGE_SHEET);
		
		
		
		adminPage = home_page.admin_moreInfo();
		adminPage.ClickNewButton().send_UserName(randomname).send_password(randompassword).send_UserType(Constants.ADMINUSER);
//		adminPage.ClickNewButton();
//		adminPage.send_UserName(randomname);
//		adminPage.send_password(randompassword);
		//adminPage.send_UserType(usertype);
//		adminPage.send_UserType(Constants.ADMINUSER);
		
//		WebElement adminmoreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
//		adminmoreinfo.click();
//		
//		WebElement new_button = driver.findElement(By.xpath("//a[contains(@class,'btn-danger') and contains(text(),'New')]"));
//		new_button.click();
//		
//		WebElement username_new = driver.findElement(By.xpath("//input[@id='username']"));
//		username_new.sendKeys(randomname);
//		
//		WebElement password_new = driver.findElement(By.xpath("//input[@id='password']"));
//		password_new.sendKeys(randompassword);
//		
//		WebElement dropdown = driver.findElement(By.xpath("//Select[@id='user_type']"));
//		
//		Select select = new Select(dropdown);
//		
//		select.selectByVisibleText(usertype);
//		
//		WebElement save = driver.findElement(By.xpath("//button[@name='Create']"));
//		save.click();
		
		//WebElement newUserAddedAlert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		
		boolean isNewUserAddedAlert = adminPage.newAlert_isDisplayed();
		
		Assert.assertTrue(isNewUserAddedAlert, Messages.ADMIN_ASSERT);
		
	}
	
	@Test(priority = 2, description  = "search the newly added user")
	public void verifysearchUser() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
//		
//		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		
//		username.sendKeys(usernameValue);
//		password.sendKeys(passwordValue);
//		
//		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
//		signIn_button.click();
		
		LoginPage login = new LoginPage(driver);
//		login.enterUserName(usernameValue);
//		login.enterPassword(passwordValue);
//		login.clickSignIN();
		
		login.enterUserName(usernameValue).enterPassword(passwordValue);
		home_page = login.clickSignIN();
		
		FakerUtility fakerUtility = new FakerUtility();
		String randomname = fakerUtility.createRandomUserName();
		
//		WebElement adminmoreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
//		adminmoreinfo.click();
		
//		WebElement search_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
//		search_button.click();
//		
//		WebElement search_username = driver.findElement(By.xpath("//input[@id='un']"));
//		search_username.sendKeys(randomname);
//		
//		WebElement dropdown = driver.findElement(By.xpath("//Select[@id='ut']"));
//		
//		Select select = new Select(dropdown);
//		
//		select.selectByVisibleText("Admin");
//		
//		WebElement search_button_new = driver.findElement(By.xpath("//button[@name='Search']"));
//		search_button_new.click();
				
		//adminPage.admin_moreInfo();
		
//		adminPage.search_button();
//		adminPage.searchUserName(randomname);
//		adminPage.selectUserType();
//		adminPage.search_button();
		
		adminPage.serachButtonClick().searchUserName(randomname).selectUserType().search_button();
		
		//WebElement searchedUserTable = driver.findElement(By.xpath("//h4[@class='card-title' and text()='Admin Users']"));
		
		boolean isSearchUserDisplayed = adminPage.searchUserTableDisplay();
		Assert.assertTrue(isSearchUserDisplayed, Messages.SEARCH_USER_ASSERT);
		 
	}
	
	@Test(description = "Reset the typed user in textbox")
	public void verifyresetUser() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
//		
//		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		
//		username.sendKeys(usernameValue);
//		password.sendKeys(passwordValue);
//		
//		WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
//		signIn_button.click();
		
		LoginPage login = new LoginPage(driver);
//		login.enterUserName(usernameValue);
//		login.enterPassword(passwordValue);
//		login.clickSignIN();
		login.enterUserName(usernameValue).enterPassword(passwordValue);
		home_page = login.clickSignIN();
		
//		WebElement reset_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
//		reset_button.click();
		
		 home_page = adminPage.resetbuttonClick();
		
		//WebElement adminUserTableDisplayedOnClickOfReset = driver.findElement(By.xpath("//h4[@class='card-title' and text() ='Admin Users']"));
		boolean isAdminUserTableDisplayedOnClickOfReset = adminPage.searchUserTableDisplay();
		
		Assert.assertTrue(isAdminUserTableDisplayedOnClickOfReset, Messages.RESET_USER_ASSERT);
		
		
	}
	
	

}
