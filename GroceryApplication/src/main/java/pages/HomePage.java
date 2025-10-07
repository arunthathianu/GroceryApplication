package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	
	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement admin_button;
	public HomePage admin_Login()
	{
		//WebElement admin_button = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		//admin_button.click();
		waitUtility.waitUntilClickable(driver, admin_button);
		pageUtility.clickOnElement(admin_button);
		return this;
	}
	
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")WebElement logout_button;
	public LoginPage admin_Logout()
	{
//		WebElement logout_button = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
//		logout_button.click();
		pageUtility.clickOnElement(logout_button);
		return new LoginPage(driver);
	}
	
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
	public AdminPage admin_moreInfo()
	{
		//WebElement adminmoreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		//adminmoreinfo.click();
		waitUtility.waitUntilClickable(driver, adminmoreinfo);
		pageUtility.clickOnElement(adminmoreinfo);
		return new AdminPage(driver);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement news_moreinfo;
	public NewsPage news_morinfo()
	{
		//WebElement news_moreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
		//news_moreinfo.click();
		pageUtility.clickOnElement(news_moreinfo);
		return new NewsPage(driver);
		
	}
	
	

}
