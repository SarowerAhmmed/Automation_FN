package com.regression;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.reports.Log;
import com.util.TakeAppScreenShot;

public class BaseLogin {
	
	protected static WebDriver driver;
	
	public static WebDriver  login(){
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
		driver.get("https://www.cnn.com/BUSINESS");
		Log.info("Home Page Title = "+driver.getTitle());
		Log.screenShot(driver, "Home Page");
		TakeAppScreenShot.captureScreenShot(driver, "Home Page");
		
		return driver;
	}
	
	
public static WebDriver  setup2(){
		
	  System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
	  System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
	    EdgeOptions edgeOptions = new EdgeOptions();
	    WebDriver driver= new EdgeDriver(edgeOptions);
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
		driver.get("https://www.cnn.com/BUSINESS");
		System.out.println("Home Page Title = "+driver.getTitle());
		
		TakeAppScreenShot.captureScreenShot(driver, "Home Page");
		//driver.quit();
		return driver;
	}

public static void main(String[] args) {
	
	setup2();
	
}
}
