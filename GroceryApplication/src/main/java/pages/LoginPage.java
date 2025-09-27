package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")WebElement username;
	public void enterUserName(String usernameValue)
	{
		//WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		//username.sendKeys(usernameValue);
		waitUtility.waitUntilElementIsVisible(driver, username);
		pageUtility.sendDataToElement(username, usernameValue);
		
	}
	
	@FindBy(xpath="//input[@name='password']")WebElement password;
	public void enterPassword(String passwordValue)
	{
		//WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		//password.sendKeys(passwordValue);
		waitUtility.waitUntilElementIsVisible(driver, password);
		pageUtility.sendDataToElement(password, passwordValue);
	}
	
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signIn_button;
	public void clickSignIN()
	{
		//WebElement signIn_button = driver.findElement(By.xpath("//button[text()='Sign In']"));
		//signIn_button.click();
		waitUtility.waitUntilClickable(driver, signIn_button);
		pageUtility.clickOnElement(signIn_button);
	}

}
