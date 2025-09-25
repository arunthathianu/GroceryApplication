package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;


public class NewsPage {
	public WebDriver driver;
	
	PageUtility pageUtility = new PageUtility();
	
	public NewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement news_moreinfo;
	public void news_morinfo()
	{
		//WebElement news_moreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		//news_moreinfo.click();
		pageUtility.clickOnElement(news_moreinfo);
		
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement addNew_News;
	public void addNewNews()
	{
		//WebElement addNew_News = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		//addNew_News.click();
		pageUtility.clickOnElement(addNew_News);
	}
	
	@FindBy(xpath = "//textarea[@id='news']")WebElement new_News;
	public void enterNewNews()
	{
		//WebElement new_News = driver.findElement(By.xpath("//textarea[@id='news']"));
		//new_News.sendKeys("This is sample News");
		pageUtility.sendDataToElement(new_News, "This is a sample News");
	}
	
	@FindBy(xpath = "//button[@name='create']")WebElement save_news;
	public void saveNewNews()
	{
		//WebElement save_news = driver.findElement(By.xpath("//button[@name='create']"));
		pageUtility.clickOnElement(save_news);
	}
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newsalert;
	public boolean addedNewNewsAlert()
	{
		//WebElement newsalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		boolean isNewsAlertDisplayed = newsalert.isDisplayed();
		return isNewsAlertDisplayed;
	}
	
}
