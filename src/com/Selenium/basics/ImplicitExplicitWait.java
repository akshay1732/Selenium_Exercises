package com.Selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ImplicitExplicitWait {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkspace\\Selenium\\src\\com\\Selenium\\config\\chromedriver.exe");	
	DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();       
	handlSSLErr.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
	driver = new ChromeDriver(handlSSLErr);	
	
	
	driver.get("https://quotation.insure4retirement.co.uk/Quote");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	String title = driver.getTitle();
	int titleLength = driver.getTitle().length();  
	System.out.println(title+" "+titleLength);
	String currenturl = driver.getCurrentUrl();
	System.out.println(currenturl);
	
	driver.findElement(By.xpath("//*[@id=\"CookieReportsBanner\"]/div/div[1]/a")).click();
	WebElement combined = driver.findElement(By.xpath("//*[@id=\"question-74b5d618-1e48-4aea-aa24-35f26f51b3ae\"]/div[1]/label[1]/div"));
	if (combined.isDisplayed()) {
	//WebElement combined = driver.findElement(By.xpath("//*[@id=\"question-74b5d618-1e48-4aea-aa24-35f26f51b3ae\"]/div[1]/label[1]/div"));
	combined.click();
	
	WebElement today = driver.findElement(By.xpath("//*[@id=\"question-7baeb124-41bb-4013-8f6a-831ce842f4c5\"]/div[1]/div[2]/span[1]"));
	today.click();
	
	WebElement contbtn = driver.findElement(By.xpath("//*[@id=\"form-root-container\"]/div[2]/div[2]/div[4]/p/a"));
	contbtn.click();
	
	}

	
	
	}

}
