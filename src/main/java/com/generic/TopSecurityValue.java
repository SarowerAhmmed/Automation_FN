package com.generic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.excel.manager.ReturnExcelNew;
import com.masterpagefactory.MasterPageFactory;
import com.reports.Log;
import com.util.ExplicitWait;
import com.util.HighLighter;
import com.util.TakeAppScreenShot;

public class TopSecurityValue {
	
	public static void getTopSecurity(WebDriver driver, MasterPageFactory pf) {

		ExplicitWait.getMyWait(driver, pf.getAllpage().get(0));
		pf.getAllpage().get(0).click();
		Map<String, String> topAppValue = new LinkedHashMap<String, String>();
		ExplicitWait.getMyWait(driver, pf.getTopSecurityNameAndValue().get(0));

		for (int i = 0; i < pf.getTopSecurityNameAndValue().size(); i++) {
			HighLighter.getColor(driver, pf.getTopSecurityNameAndValue().get(i), "red");
			topAppValue.put(pf.getTopSecurityNameAndValue().get(i).getAttribute("data-ticker-name"),
					pf.getTopSecurityNameAndValue().get(i).getText());
		}
		Log.info("Top security value from Application ::"+topAppValue.values());
		TakeAppScreenShot.captureScreenShot(driver, "Top Security Value");
		List<String> appValue = new ArrayList<>(topAppValue.values());
		List<String> testDataValue = ReturnExcelNew.returnExcel("./Test Data/Test Data Financial.xlsx", "Market");
		Log.info("Top security value from Test Data Excel ::"+testDataValue);
		if (appValue.equals(testDataValue.get(1))) {
			
			Assert.assertEquals(appValue, testDataValue.get(1), "Market Value Matched as Expected");
			Log.info(appValue + " = Matched = " + testDataValue.get(1));
		} else {
			Log.info(appValue + " = Not Matched = " + testDataValue.get(1));
			 Assert.assertEquals(appValue, testDataValue.get(1), "Market Value Not Matchedas Expected");

		}
	}
	}
	

