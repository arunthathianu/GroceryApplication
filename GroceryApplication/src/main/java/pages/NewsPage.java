package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;


public class NewsPage {
	public WebDriver driver;
	
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();
	
	public NewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement addNew_News;
	public NewsPage addNewNews()
	{
		//WebElement addNew_News = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		//addNew_News.click();
		waitUtility.waitUntilClickable(driver, addNew_News);
		pageUtility.clickOnElement(addNew_News);
		return this;
	}
	
	@FindBy(xpath = "//textarea[@id='news']")WebElement new_News;
	public NewsPage enterNewNews()
	{
		//WebElement new_News = driver.findElement(By.xpath("//textarea[@id='news']"));
		//new_News.sendKeys("This is sample News");
		waitUtility.waitUntilElementIsVisible(driver, new_News);
		pageUtility.sendDataToElement(new_News, "This is a sample News");
		return this;
	}
	
	@FindBy(xpath = "//button[@name='create']")WebElement save_news;
	public NewsPage saveNewNews()
	{
		//WebElement save_news = driver.findElement(By.xpath("//button[@name='create']"));
		waitUtility.waitUntilClickable(driver, save_news);
		pageUtility.clickOnElement(save_news);
		return this;
	}
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newsalert;
	public boolean addedNewNewsAlert()
	{
		//WebElement newsalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		waitUtility.waitUntilElementIsVisible(driver, newsalert);
		boolean isNewsAlertDisplayed = newsalert.isDisplayed();
		return isNewsAlertDisplayed;
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement homeButton;
	public HomePage homeButtonClick()
	{
		//WebElement homeButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		waitUtility.waitUntilClickable(driver, homeButton);
		pageUtility.clickOnElement(homeButton);
		return new HomePage(driver);
	}
	
}
