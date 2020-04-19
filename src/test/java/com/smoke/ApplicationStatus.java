package com.smoke;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.config.ObjectMap;
import com.generic.DriverScript;

public class ApplicationStatus {

	
	@Test
	public void setup() {
		
		
		new DriverScript().getdriver(ObjectMap.getconfig("URL"));
		
	}
	
}
