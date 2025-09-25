package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	
	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement admin_button;
	public void admin_Login()
	{
		//WebElement admin_button = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		//admin_button.click();
		pageUtility.clickOnElement(admin_button);
	}
	
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")WebElement logout_button;
	public void admin_Logout()
	{
//		WebElement logout_button = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
//		logout_button.click();
		pageUtility.clickOnElement(logout_button);
	}

}
