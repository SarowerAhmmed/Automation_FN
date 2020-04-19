package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	public static void getMyWait(WebDriver driver,WebElement element) {

		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
	}

}
