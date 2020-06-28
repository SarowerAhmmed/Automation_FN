package com.regression;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.excel.manager.ExcelWriter;
import com.excel.manager.ReturnExcelNew;
import com.reports.ExtentTestManager;
import com.reports.Log;
import com.util.TakeAppScreenShot;

public class CNN_ExtendsReport extends BaseLogin {

	List<String> expectedValue = new ArrayList<>();
	ExtentTest test;


	@BeforeTest
	public void setup() {
		
		test = ExtentTestManager.startTest("Regression_tc1");
		test.assignCategory("Regression Test");
		test.createNode("setup");
		
		TakeAppScreenShot.emptyScreenShotFolder();
		login();

	}

	@Test
	public void market_02() {

		TestCaseTwo.getTitle(driver);

	}

	@Test(dependsOnMethods = { "market_02" })
	public void market_03() {

		TestCaseThree.getMarketData(driver, TestCaseThree.actualdata);

	}

	@Test(dependsOnMethods = { "market_03" })
	public void market_04() {

		expectedValue = ReturnExcelNew.returnExcel("./Test Data/Test Data Financial.xlsx", "Most Popular Stocks");
		Log.info("Expected value from Test data excel = " + expectedValue);
	}

	@Test(dependsOnMethods = { "market_04" })
	public void market_05() {

		ExcelWriter.wtireExcelListCNN("./Test Data/CNNExcelWrite.xlsx", TestCaseThree.actualdata);
		Log.info("Write Excel successfully");
	}

	@Test(dependsOnMethods = { "market_05" })
	public void market_06() {

		if (TestCaseThree.actualdata.equals(expectedValue)) {
			Log.pass("Actual Value =" + TestCaseThree.actualdata + "......should  match with Expected Value = "
					+ expectedValue);
		} else {
			Log.fail("Actual Value =" + TestCaseThree.actualdata + "......should  match with Expected Value = "
					+ expectedValue);
		}
		Assert.assertEquals(TestCaseThree.actualdata, expectedValue, "Actual Value =" + TestCaseThree.actualdata
				+ "......should  match with Expected Value = " + expectedValue);

	}

	@AfterTest
	public void teardown() {

		driver.quit();
		ExtentTestManager.endTest();
	
	}

}
