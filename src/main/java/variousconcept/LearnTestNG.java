package variousconcept;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LearnTestNG {

	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
//		driver.get("https://www.cnn.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void dealWithDynamicWebElement() {
//		driver.findElement(By.xpath("//ul[@class='cn cn-list-hierarchical-xs cn--idx-0 cn-container_C7586E1A-7321-AE9A-FA17-F14028802010']/descendants::span[3]")).click();
//		store Web Element formula
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\'password\']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_FIELD_ELEMENT.clear();
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		WebElement DASHBOARD_BUTTON_ELEMENT = driver.findElement(By.linkText("Dashboard"));
		String actualDashboardElement = DASHBOARD_BUTTON_ELEMENT.getText();
		Assert.assertEquals("Dashboard page not found!", "Dashboard", actualDashboardElement);
		
		
//		Store web element using by class
//		By USERNAME_FIELD_LOCATOR = By.xpath("//input[@id='username']");
//		By PASSWORD_FIELD_LOCATOR = By.xpath("//input[@id=\'password\']");
		
//		you call by using this method
//		driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys("demo@techfios.com");
//		driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys("abc123");
		
		
	}
	
	@Test
	public void dealWithDynamicWebElement1() {
//		driver.findElement(By.xpath("//ul[@class='cn cn-list-hierarchical-xs cn--idx-0 cn-container_C7586E1A-7321-AE9A-FA17-F14028802010']/descendants::span[3]")).click();
//		store Web Element formula
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id=\'password\']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_FIELD_ELEMENT.clear();
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		WebElement DASHBOARD_BUTTON_ELEMENT = driver.findElement(By.linkText("Dashboard"));
		String actualDashboardElement = DASHBOARD_BUTTON_ELEMENT.getText();
		Assert.assertEquals("Dashboard page not found!", "Dashboard1", actualDashboardElement);
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
	
}
