package com.generic;

import java.util.EnumSet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.masterpagefactory.MasterPageFactory;
import com.util.ExplicitWait;
import com.util.HighLighter;

public class AllPageTitle2 {

	public void getTitle(WebDriver driver, MasterPageFactory pf) {

		System.out.println("Total page number =" + pf.getAllPageName().size());

		for (int i = 0; i < pf.getAllPageName().size(); i++) {
			ExplicitWait.getMyWait(driver, pf.getAllPageName().get(i));// wait
			HighLighter.getColor(driver, pf.getAllPageName().get(i), "red");// Highlight
			String page = pf.getAllPageName().get(i).getText();
			new Actions(driver).moveToElement(pf.getAllPageName().get(i)).click().perform();

			for (TitlePage signal : TitlePage.values()) {
				if (signal.toString().equalsIgnoreCase(page)) {
					if (signal.getAction().equalsIgnoreCase(driver.getTitle())){
						Assert.assertEquals(driver.getTitle(), signal.getAction(),
								"Passed == > Title matched = " + signal.name());
						System.out.println("Current Page No =" + i + " Title is =" + driver.getTitle());
						break;

					} else {
						System.out.println("Current Page No =" + i + " Title is =" + driver.getTitle());
						Assert.assertEquals(driver.getTitle(), signal.getAction(),
								"Failed == > Title Not matched = " + signal.name());
						break;
					}

				}

			}
			if (page.contains("Market")) {
				driver.navigate().back();
				ExplicitWait.getMyWait(driver, pf.getAllPageName().get(0));// wait
			}

		}
	}
}
