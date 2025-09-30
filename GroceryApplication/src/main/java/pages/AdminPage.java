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
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
	public void admin_moreInfo()
	{
		//WebElement adminmoreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		//adminmoreinfo.click();
		waitUtility.waitUntilClickable(driver, adminmoreinfo);
		pageUtility.clickOnElement(adminmoreinfo);
	}
	
	@FindBy(xpath = "//a[contains(@class,'btn-danger') and contains(text(),'New')]")WebElement new_button;
	public void ClickNewButton()
	{
		//WebElement new_button = driver.findElement(By.xpath("//a[contains(@class,'btn-danger') and contains(text(),'New')]"));
		//new_button.click();
		waitUtility.waitUntilClickable(driver, new_button);
		pageUtility.clickOnElement(new_button);
	}
	
	@FindBy(xpath="//input[@id='username']")WebElement username_new;
	public void send_UserName(String randomname)
	{
		//WebElement username_new = driver.findElement(By.xpath("//input[@id='username']"));
		//username_new.sendKeys(randomname);
		pageUtility.sendDataToElement(username_new, randomname);
	}
	
	@FindBy(xpath="//input[@id='password']")WebElement password_new;
	public void send_password(String randompassword)
	{
		//WebElement password_new = driver.findElement(By.xpath("//input[@id='password']"));
		//password_new.sendKeys(randompassword);
		pageUtility.sendDataToElement(password_new, randompassword);
	}
	
	@FindBy(xpath =  "//Select[@id='user_type']")WebElement dropdown;
	public void send_UserType(String usertype)
	{
		//WebElement dropdown = driver.findElement(By.xpath("//Select[@id='user_type']"));
		//Select select = new Select(dropdown);
		//select.selectByVisibleText(usertype);
		pageUtility.selectDataWithVisibleText(dropdown, usertype);
	}
	
	@FindBy(xpath = "//button[@name='Create']")WebElement save;
	public void save_click()
	{
		//WebElement save = driver.findElement(By.xpath("//button[@name='Create']"));
		//save.click();
		waitUtility.waitUntilClickable(driver, save);
		pageUtility.clickOnElement(save);
	}
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newUserAddedAlert;
	public boolean newAlert_isDisplayed()
	{
		//WebElement newUserAddedAlert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		boolean isNewUserAddedAlert = newUserAddedAlert.isDisplayed();
		return isNewUserAddedAlert;
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search_button;
	public void serachButtonClick()
	{
//		WebElement search_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
//		search_button.click();
		waitUtility.waitUntilClickable(driver, search_button);
		pageUtility.clickOnElement(search_button);
	}
	
	@FindBy(xpath = "//input[@id='un']")WebElement search_username;
	public void searchUserName(String randomname)
	{
//		WebElement search_username = driver.findElement(By.xpath("//input[@id='un']"));
//		search_username.sendKeys(randomname);
		pageUtility.sendDataToElement(search_username, randomname);
	}
	
	@FindBy(xpath = "//select[@id='ut']")WebElement userTypedropdown;
	public void selectUserType()
	{
//		WebElement dropdown = driver.findElement(By.xpath("//Select[@id='ut']"));
//		
//		Select select = new Select(dropdown);
//		
//		select.selectByVisibleText("Admin");
		waitUtility.waitUntilElementIsSelected(driver, userTypedropdown);
		pageUtility.selectDataWithVisibleText(userTypedropdown, Constants.ADMINUSER);
	}
	
	@FindBy(xpath = "//button[@name='Search']")WebElement search_button_new;
	public void search_button() 
	{
//		WebElement search_button_new = driver.findElement(By.xpath("//button[@name='Search']"));
//		search_button_new.click();
		waitUtility.waitUntilClickable(driver, search_button_new);
		pageUtility.clickOnElement(search_button_new);
		
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
	public void resetbuttonClick()
	{
		//WebElement reset_button = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
//		reset_button.click();
		waitUtility.waitUntilClickable(driver, reset_button);
		pageUtility.clickOnElement(reset_button);
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
