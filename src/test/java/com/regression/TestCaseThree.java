package com.regression;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.masterpagefactory.MasterPageFactory;
import com.reports.Log;
import com.util.ExplicitWait;
import com.util.HighLighter;

public class TestCaseThree {
	public static List<String> actualdata = new ArrayList<>();
	public static void getMarketData(WebDriver driver,List<String> actualdata ) {

		MasterPageFactory pf = PageFactory.initElements(driver, MasterPageFactory.class);
		
		pf.getAllpage().get(0).click();
		Log.info("I am in Market page");
		ExplicitWait.getMyWait(driver, pf.getMostPopularStock().get(0));
		
		pf.getMostPopularStock().stream().forEach(data->{
			
			HighLighter.getMultiColor(driver, data, pf.getMostPopularStock().indexOf(data));
			actualdata.add(data.getText().replace("\n", ","));// 2) add method ==>inside loop
		});
		Log.info("Actual Application Value =" + actualdata);// 3) out side the loop
	
}
}