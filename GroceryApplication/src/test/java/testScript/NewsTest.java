package testScript;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase{

	HomePage homepage;
	NewsPage newsPage;
	
	@Test(description = "Add New News in Manage News page")
	public void verifyAddNews() throws IOException
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
		homepage = login.clickSignIN();
		
//		NewsPage newsPage = new NewsPage(driver);
		
		//newsPage.news_morinfo();
		newsPage = homepage.news_morinfo();
		
		newsPage.addNewNews().enterNewNews().saveNewNews();
		
//		newsPage.addNewNews();
//		
//		newsPage.enterNewNews();
//		
//		newsPage.saveNewNews();
//		
//		newsPage.addedNewNewsAlert();
//		
//		WebElement news_moreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
//		news_moreinfo.click();
//		
//		WebElement addNew_News = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
//		addNew_News.click();
//		
		
//		WebElement new_News = driver.findElement(By.xpath("//textarea[@id='news']"));
//		new_News.sendKeys("This is sample News");
//		
//		WebElement save_news = driver.findElement(By.xpath("//button[@name='create']"));
//		save_news.click();
		
//		WebElement newsalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//		boolean isNewsAlertDisplayed = newsalert.isDisplayed();
		
		boolean isNewsAlertDisplayed = newsPage.addedNewNewsAlert();
		Assert.assertTrue(isNewsAlertDisplayed, Messages.ADD_NEWS_ASSERT);
		
	}
	
	@Test(description = "Click on Home button to back to Home Page")
	@Parameters("browser")
	public void verifyReturnHomePage() throws IOException
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
		login.enterUserName(usernameValue).enterPassword(passwordValue).clickSignIN();
		
//		WebElement news_moreinfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
//		news_moreinfo.click();
//		
//		WebElement home_button = driver.findElement(By.xpath("//a[text()='Home']"));
//		home_button.click();
		
//		NewsPage newsPage = new NewsPage(driver);
//		
//		newsPage.newsmoreinfo();
//		newsPage.homeButtonClick();
		
		newsPage = homepage.news_morinfo();
		
		homepage = newsPage.homeButtonClick();
		
		String expected = "https://groceryapp.uniqassosiates.com/admin/home";
		
		String actual = driver.getCurrentUrl();
		
		Assert.assertEquals(actual, expected, Messages.NOT_REDIRECT_HOMEPAGE);
	}
}
