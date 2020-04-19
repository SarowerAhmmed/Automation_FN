package com.regression;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.config.ObjectMap;
import com.excel.manager.ReturnExcelNew;
import com.generic.AllPageTitle;
import com.generic.DriverScript;
import com.masterpagefactory.MasterPageFactory;
import com.reports.ExtentTestManager;
import com.reports.Log;
import com.util.ExplicitWait;
import com.util.HighLighter;

public class MarketData {
	WebDriver driver;
	MasterPageFactory pf;
	ExtentTest test;
	Map<String, String> myMap;
	@BeforeTest
	public void setup_tc1() {
		test = ExtentTestManager.startTest("regression_tc1");

		Log.startTestCase("regression_tc1");
		driver = new DriverScript().getdriver(ObjectMap.getconfig("URL"));
		pf = PageFactory.initElements(driver, MasterPageFactory.class);

	}

	@Test
	public void regression_tc2() {

		 new AllPageTitle().getTitle(driver, pf);

	}

	@Test(dependsOnMethods = { "regression_tc2" })
	public void regression_tc3() throws Throwable {
		// map
		 myMap = new LinkedHashMap<>();
		new Actions(driver).moveToElement(pf.getAllpage().get(0)).click().perform();// 1
		ExplicitWait.getMyWait(driver, pf.getTopSecurityNameAndValue().get(0));
		
		for (int i = 0; i < pf.getTopSecurityNameAndValue().size(); i++) {
			HighLighter.getColor(driver, pf.getTopSecurityNameAndValue().get(i), "red");
			myMap.put(pf.getTopSecurityNameAndValue().get(i).getAttribute("data-ticker-name"),
					pf.getTopSecurityNameAndValue().get(i).getText());
		}
		Log.info(myMap.toString());//whole map==> Key :: Value
		Log.info(myMap.keySet().toString());//keys
		Log.info(myMap.values().toString());//values=====> Test data
	}
	
	@Test(dependsOnMethods = { "regression_tc3" })
	public void regression_tc4() throws Throwable {
		List<String> testDataList = new ArrayList<>();
		testDataList=ReturnExcelNew.returnExcel("./Test Data/Test Data Financial.xlsx", "Market");
		Log.info(testDataList.get(1));

		if (myMap.keySet().toString().trim().contains(testDataList.get(0).trim())) {

			System.out
					.println("Top section Name Validation Passed ....." + myMap.keySet() + " = " + testDataList.get(0));
		//	Assert.assertEquals(myMap.keySet().toString().trim(), testDataList.get(0).trim(), "Passed the name........");

		} else {

			System.out
					.println("Top section Name Validation Falied ....." + myMap.keySet() + " = " + testDataList.get(0));
			Assert.assertEquals(myMap.keySet(), testDataList.get(0), "Failed the name........");
		}

		if (myMap.values().toString().trim().contains(testDataList.get(1).toString().trim())) {

			System.out.println(
					"Top section Value Validation Passed ....." + myMap.values() + " = " + testDataList.get(1));
			Assert.assertEquals(myMap.values().toString().trim(), testDataList.get(1).toString().trim(), "Passed the value........");
		} else {

			System.out.println(
					"Top section Value Validation Failed ....." + myMap.values() + " = " + testDataList.get(1));
			Assert.assertEquals(myMap.values(), testDataList.get(1), "Failed the value........");
		}
		
		
		
		
		
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		// TopSecurityValue.getTopSecurity(driver, pf);
		Log.endTestCase("teardown");

	}

}
