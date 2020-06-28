package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.masterpagefactory.MasterPageFactory;
import com.reports.Log;
import com.util.ExplicitWait;

public class AllPageTitle {

	public void getTitle(WebDriver driver, MasterPageFactory pf) {
		// Market
		ExplicitWait.getMyWait(driver, pf.getMarket());
		pf.getMarket().click();
		String marketTitle = driver.getTitle();
		Assert.assertEquals(marketTitle, TitlePageValue.MARKET);
		Log.info(marketTitle);

		ExplicitWait.getMyWait(driver, pf.getTech());

		// Tech
		pf.getTech().click();
		String techTitle = driver.getTitle();
		Assert.assertEquals(techTitle, TitlePageValue.TECH);
		Log.info(techTitle);
		ExplicitWait.getMyWait(driver, pf.getMedia());

		// Media
		pf.getMedia().click();
		String mediaTitle = driver.getTitle();
		Assert.assertEquals(mediaTitle, TitlePageValue.MEDIA);
		Log.info(mediaTitle);
		ExplicitWait.getMyWait(driver, pf.getSuccess());

		// Success
		pf.getSuccess().click();
		String successTitle = driver.getTitle();
		Assert.assertEquals(successTitle, TitlePageValue.SUCCESS);
		Log.info(successTitle);
		ExplicitWait.getMyWait(driver, pf.getPerspective());

		// Perspective
		pf.getPerspective().click();
		String perspectiveTitle = driver.getTitle();
		Assert.assertEquals(perspectiveTitle, TitlePageValue.PERSPECTIVES);
		Log.info(perspectiveTitle);
		ExplicitWait.getMyWait(driver, pf.getVideos());

		// Videos
		pf.getVideos().click();
		String videosTitle = driver.getTitle();
		Assert.assertEquals(videosTitle, TitlePageValue.VIDEO);
		Log.info(videosTitle);

	}

}
