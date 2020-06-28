package com.regression;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.generic.AllMyPageTitle;
import com.reports.Log;

public class TestCaseTwo2 {
	
	
	public static void getTitle(WebDriver driver) {
		

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
							Log.info("Found my Title = "+driver.getTitle());
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
