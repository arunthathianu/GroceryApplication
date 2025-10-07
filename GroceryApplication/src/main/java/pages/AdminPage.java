package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	
	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();
	
	public AdminPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//a[contains(@class,'btn-danger') and contains(text(),'New')]")WebElement new_button;
	public AdminPage ClickNewButton()
	{
		//WebElement new_button = driver.findElement(By.xpath("//a[contains(@class,'btn-danger') and contains(text(),'New')]"));
		//new_button.click();
		waitUtility.waitUntilClickable(driver, new_button);
		pageUtility.clickOnElement(new_button);
		return this;
	}
	
	@FindBy(xpath="//input[@id='username']")WebElement username_new;
	public AdminPage send_UserName(String randomname)
	{
		//WebElement username_new = driver.findElement(By.xpath("//input[@id='username']"));
		//username_new.sendKeys(randomname);
		waitUtility.waitUntilElementIsVisible(driver, username_new);
		pageUtility.sendDataToElement(username_new, randomname);
		return this;
	}
	
	@FindBy(xpath="//input[@id='password']")WebElement password_new;
	public AdminPage send_password(String randompassword)
	{
		//WebElement password_new = driver.findElement(By.xpath("//input[@id='password']"));
		//password_new.sendKeys(randompassword);
		waitUtility.waitUntilElementIsVisible(driver, password_new);
		pageUtility.sendDataToElement(password_new, randompassword);
		return this;
	}
	
	@FindBy(xpath =  "//Select[@id='user_type']")WebElement dropdown;
	public AdminPage send_UserType(String usertype)
	{
		//WebElement dropdown = driver.findElement(By.xpath("//Select[@id='user_type']"));
		//Select select = new Select(dropdown);
		//select.selectByVisibleText(usertype);
		waitUtility.waitUntilElementIsSelected(driver, dropdown);
		pageUtility.selectDataWithVisibleText(dropdown, usertype);
		return this;
	}
	
	@FindBy(xpath = "//button[@name='Create']")WebElement save;
	public AdminPage save_click()
	{
		//WebElement save = driver.findElement(By.xpath("//button[@name='Create']"));
		//save.click();
		waitUtility.waitUntilClickable(driver, save);
		pageUtility.clickOnElement(save);
		return this;
	}
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newUserAddedAlert;
	public boolean newAlert_isDisplayed()
	{
		//WebElement newUserAddedAlert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		waitUtility.waitUntilElementIsVisible(driver, newUserAddedAlert);
		boolean isNewUserAddedAlert = newUserAddedAlert.isDisplayed();
		return isNewUserAddedAlert;
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search_button;
	public AdminPage serachButtonClick()
	{
//		WebElement search_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
//		search_button.click();
		waitUtility.waitUntilClickable(driver, search_button);
		pageUtility.clickOnElement(search_button);
		return this;
	}
	
	@FindBy(xpath = "//input[@id='un']")WebElement search_username;
	public AdminPage searchUserName(String randomname)
	{
//		WebElement search_username = driver.findElement(By.xpath("//input[@id='un']"));
//		search_username.sendKeys(randomname);
		waitUtility.waitUntilElementIsVisible(driver, search_username);
		pageUtility.sendDataToElement(search_username, randomname);
		return this;
	}
	
	@FindBy(xpath = "//select[@id='ut']")WebElement userTypedropdown;
	public AdminPage selectUserType()
	{
//		WebElement dropdown = driver.findElement(By.xpath("//Select[@id='ut']"));
//		
//		Select select = new Select(dropdown);
//		
//		select.selectByVisibleText("Admin");
		waitUtility.waitUntilElementIsSelected(driver, userTypedropdown);
		pageUtility.selectDataWithVisibleText(userTypedropdown, Constants.ADMINUSER);
		return this;
	}
	
	@FindBy(xpath = "//button[@name='Search']")WebElement search_button_new;
	public AdminPage search_button() 
	{
//		WebElement search_button_new = driver.findElement(By.xpath("//button[@name='Search']"));
//		search_button_new.click();
		waitUtility.waitUntilClickable(driver, search_button_new);
		pageUtility.clickOnElement(search_button_new);
		return this;
		
	}
	
	@FindBy(xpath = "//h4[@class='card-title' and text()='Admin Users']")WebElement searchedUserTable;
	public boolean searchUserTableDisplay() 
	{
//		WebElement searchedUserTable = driver.findElement(By.xpath("//h4[@class='card-title' and text()='Admin Users']"));
//		
		waitUtility.waitUntilElementIsVisible(driver, searchedUserTable);
		boolean isSearchUserDisplayed = searchedUserTable.isDisplayed();
		
		return isSearchUserDisplayed;
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")WebElement reset_button;
	public AdminPage resetbuttonClick()
	{
		//WebElement reset_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
//		reset_button.click();
		waitUtility.waitUntilClickable(driver, reset_button);
		pageUtility.clickOnElement(reset_button);
		return this;
	}
	
	@FindBy(xpath = "//h4[@class='card-title' and text() ='Admin Users']")WebElement adminUserTableDisplayedOnClickOfReset;
	public boolean isAdminUserDisplayed()
	{
		//WebElement adminUserTableDisplayedOnClickOfReset = driver.findElement(By.xpath("//h4[@class='card-title' and text() ='Admin Users']"));
		waitUtility.waitUntilElementIsVisible(driver, adminUserTableDisplayedOnClickOfReset);
		boolean isAdminUserTableDisplayedOnClickOfReset = adminUserTableDisplayedOnClickOfReset.isDisplayed();
		return isAdminUserTableDisplayedOnClickOfReset;
	}
}
