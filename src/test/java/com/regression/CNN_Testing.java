package com.regression;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CNN_Testing {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=TestCaseOne.setup();//return ===>driver
		
	}
	
	@Test
	public void pageTitle_02() {
		
		TestCaseTwo.getTitle(driver);
		
	}

	@Test
	public void Market_03() {
		
		//Most popular stock==> read from APP 
	

	}
	@Test
	public void Market_04() {
		
		//Most popular stock==>then ===> validate with Excel
		
		
		
		
	}
	
	@Test
	public void Market_05() {
		
		//Most popular stock==> Write into an Excel
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}
	
	
}
