package com.Selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UserInteractions {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.calculator.net/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//*[@id='contentout']/table/tbody/tr/td[3]/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='content']/table[2]/tbody/tr/td/div[3]/a")).click();
		
		
		//**********************Text Boxes************************************
		
		
		driver.findElement(By.xpath("//*[@id='cpar1']")).sendKeys("10");
	
		driver.findElement(By.xpath("//*[@id='cpar2']")).sendKeys("50");
	      
		driver.findElement(By.xpath("//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();

		String result = driver.findElement(By.xpath("//*[@id='content']/p[2]/font/b")).getText();
		 
		
		//Getting input text
		
		String val1 = driver.findElement(By.xpath("//*[@id='cpar1']")).getAttribute("value");
		String val2 = driver.findElement(By.xpath("//*[@id='cpar2']")).getAttribute("value");
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(result);
		
		//************************Check Boxes*************************************
		
		
		driver.get("http://www.calculator.net/");
		driver.findElement(By.xpath("//*[@id='contentout']/table/tbody/tr/td[1]/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr/td[1]/div[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='caddoptional']")).click();
		
		WebElement checkbox = driver.findElement(By.xpath("//*[@id='caddoptional']"));
		
		
		System.out.println("\nCheck Box");
		System.out.println(checkbox.isDisplayed());
		System.out.println(checkbox.isEnabled());
		System.out.println(checkbox.isSelected());
		 
		 
		 //************************* Radio Buttons **************************************
		
		driver.get("http://www.calculator.net/");
	
		driver.findElement(By.xpath("//*[@id='contentout']/table/tbody/tr/td[1]/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr/td[1]/div[3]/a")).click();
		
	
		
		
		WebElement radio1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[3]/div/table/tbody/tr[5]/td/label[1]/input"));
		
		
		WebDriverWait wait  = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(radio1));
		
		
		radio1.click();
		System.out.println("\nRadio Button");
		System.out.println(radio1.isDisplayed());
		System.out.println(radio1.isEnabled());
		System.out.println(radio1.isSelected());
		
		
		//************************ Drop Downs ********************************************
		
		driver.get("http://www.calculator.net/");
		
		driver.findElement(By.xpath("//*[@id='hl1']/li[4]/a")).click();
		
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='ccompound']")));
		
		
		dropdown.selectByIndex(1);
		dropdown.selectByValue("quarterly");
		dropdown.selectByVisibleText("semimonthly");
		 
		
		 
		 
	}

}
