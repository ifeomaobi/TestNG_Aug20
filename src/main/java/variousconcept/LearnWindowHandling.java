package variousconcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandling {
	WebDriver driver;
	
	@Test
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		String handle = driver.getWindowHandle();
		System.out.println(handle);
		
		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		
		System.out.println(driver.getTitle());
		String handle1 = driver.getWindowHandle();
		System.out.println(handle1);
		
		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
		
		System.out.println(driver.getTitle());
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		
		for (String i : handles) {
			System.out.println(i);
			driver.switchTo().window(i);
		}

		System.out.println(driver.getTitle());
		
		driver.switchTo().window(handle1);
		System.out.println(driver.getTitle());
}

}