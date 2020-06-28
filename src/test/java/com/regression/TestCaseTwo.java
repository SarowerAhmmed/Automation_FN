package com.regression;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.generic.AllMyPageTitle;
import com.masterpagefactory.MasterPageFactory;
import com.reports.Log;
import com.util.ExplicitWait;
import com.util.HighLighter;
import com.util.TakeAppScreenShot;

public class TestCaseTwo {

	public static void getTitle(WebDriver driver) {

	MasterPageFactory pf = PageFactory.initElements(driver, MasterPageFactory.class);
	
		String TitleBeforeClick=driver.getTitle();
		ExplicitWait.getMyWait(driver, pf.getAllpage().get(0));
		for (int i = 0; i < pf.getAllpage().size(); i++) {

			while (true) {// never stop===> infinite time

				if (pf.getAllpage().size()> 0) {
					HighLighter.getMultiColor(driver, pf.getAllpage().get(i), i);
					String pageName = pf.getAllpage().get(i).getText();
					ExplicitWait.getMyWait(driver, pf.getAllpage().get(i));
					pf.getAllpage().get(i).click();// ...............................................................Click
					Log.info("Click here.............");
					try {
						Thread.sleep(3000);
						ExplicitWait.getMyTitle(driver,"CNN");
					} catch (InterruptedException e1) {
						
					}
				
					// wait...............for market
					
					Log.info(" Page  title = "+driver.getTitle() );
					if (driver.getTitle() != null
							&& !driver.getTitle().contains(TitleBeforeClick)) {
						
						for (AllMyPageTitle myEnum : AllMyPageTitle.values()) {
							if (pageName.toUpperCase().contains(myEnum.toString())) {
								Log.info("Found my Title = " + driver.getTitle());
								//TakeAppScreenShot.captureScreenShot(driver, pageName);
								Log.screenShot(driver, pageName);
								Assert.assertEquals(driver.getTitle(), myEnum.getTitle());
							}
						}
						break;// break the while loop
					}else {
						
						try {
							Log.info("Need to wait...............");
							Thread.sleep(3000);
						} catch (InterruptedException e) {
						
					}
					 } 
					  }
				       }

			if (i == 0) {
				driver.get("https://www.cnn.com/BUSINESS");

			}

		}

	}

}
