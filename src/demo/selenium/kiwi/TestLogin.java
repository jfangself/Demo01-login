package demo.selenium.kiwi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class TestLogin {

	public WebDriver driver;
	String baseUrl = "http://10.13.6.55:8013/kiwi/";
	String loginName = "u1@testb.dom";
	String passWdName = "p";

	private boolean IsElementPresent(By by){
		
		try {
			
			driver.findElement(by);
			return true;
			
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
	@Test
	public void loginkiwi() {

		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement userName = driver.findElement(By
				.xpath("//*[@id='textfield-1018-inputEl']"));
		WebElement passWord = driver.findElement(By
				.xpath("//*[@id='textfield-1019-inputEl']"));
		WebElement loginBtn = driver.findElement(By
				.xpath("//*[@id='button-1020-btnIconEl']"));
		WebElement loginLogo = driver.findElement(By
				.xpath("//*[@id='container-1016-innerCt']"));

		Assert.assertTrue(loginLogo.isDisplayed());
		// Assert.assertTrue(userName.isDisplayed());

		userName.sendKeys(loginName);
		passWord.sendKeys(passWdName);
		loginBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='component-1028']")));
		wait.until(ExpectedConditions.titleContains("Inbox"));

		WebElement welcomeIcon = driver.findElement(By
				.xpath("//*[@id='component-1028']"));

		Assert.assertTrue(welcomeIcon.isDisplayed());
		Assert.assertEquals(welcomeIcon.getText(), "Welcome u1");
		Assert.assertTrue(IsElementPresent(By.id("component-1028")));

		// System.out.println("test print" + searchBtn.getText());
		// Assert.assertEquals(loginLogo.getText(), "Compose");

	}

	@BeforeMethod
	public void beforeMethod() {
		

		driver = new FirefoxDriver();
		// driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {

		driver.close();
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
