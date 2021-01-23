package com.Selenium.basics;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Waits {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.calculator.net/");
		driver.manage().window().maximize();
		
		
		Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contentout']/table/tbody/tr/td[3]/div[2]/a")));
		
		driver.findElement(By.xpath("//*[@id='contentout']/table/tbody/tr/td[3]/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='content']/table[2]/tbody/tr/td/div[3]/a")).click();
		
		
		//*[@id="content"]/table[1]/tbody/tr[2]/td/input[2]
		WebElement pick = driver.findElement(By.xpath("//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"));
		WebElement drop = driver.findElement(By.xpath("//*[@id='calcSearchTerm']"));
		
		Actions action  = new Actions(driver);
		
		action.dragAndDrop(pick, drop).perform();
		action.clickAndHold(pick).moveToElement(drop).release().build().perform();
		 
		
		
	}

}
