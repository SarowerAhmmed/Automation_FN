package com.testing.oops;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.generic.AllMyPageTitle;

public abstract class Testcase implements Regression{

	protected static WebDriver driver;


	@Override
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		driver.get("https://www.cnn.com/BUSINESS");
		System.out.println("Home Page Title = "+driver.getTitle());
		
	}

	@Override
	public void getTitle() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> allPages = driver.findElements(By.xpath("(//*[@class='sc-htoDjs dpodOf'])[1]//li"));
		wait.until(ExpectedConditions.elementToBeClickable(allPages.get(0)));
		for (int i = 0; i < allPages.size(); i++) {
			
			while(true) {//never stop===> infinite time
				allPages=driver.findElements(By.xpath("(//*[@class='sc-htoDjs dpodOf'])[1]//li"));
				
				if(allPages.size()>0) {
					js.executeScript("arguments[0].style.border='3px solid red'", allPages.get(i));
					String pageName=allPages.get(i).getText();
					wait.until(ExpectedConditions.elementToBeClickable(allPages.get(i)));
					allPages.get(i).click();//...............................................................Click
					//wait=======> title
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
					
					if(driver.getTitle() != null) {			
						for(AllMyPageTitle myEnum:AllMyPageTitle.values()) {
							if(pageName.toUpperCase().contains(myEnum.toString())) {
							System.out.println("Found my Title = "+driver.getTitle());
							Assert.assertEquals(driver.getTitle(), myEnum.getTitle());
							}
						}

					break;//break the while loop
					
					}else {
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
						}
					}
	
					
				}
				
			}
		
			if(i==0) {
				driver.get("https://www.cnn.com/BUSINESS");	
				
			}

		}
		
	}
	
	
	

}
