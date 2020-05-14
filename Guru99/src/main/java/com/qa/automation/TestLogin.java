package com.qa.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {
	WebDriver driver;
	
	@Test
	public void loginTest() {
		String url = "http://www.demo.guru99.com/V4/";
		String userID = "mngr260346";
		String password= "YgetEvY";
		
		System.setProperty("webdriver.firfox.driver", "/usr/local/Cellar/geckodriver/0.26.0/bin/geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(url);
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(userID);
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage", "Page title doesn't match.");
		
		driver.quit();
		
	}
	
}
