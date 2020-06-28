package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighter {

	public static void getColor(WebDriver driver, WebElement element, String color) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid " + color + "'", element);
	}

	public static void getMultiColor(WebDriver driver, WebElement element, int index) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String [] colorselect = {"red","yellow","green","orange","black","pink"};
	
		//js.executeScript("arguments[0].style.border='2px solid " + colorselect[index] + "'", element);
	
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 4px solid " + colorselect[index] + ";');", element);
		
		
	}

}
