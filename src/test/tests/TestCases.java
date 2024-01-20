package com.sumergebookingtask.SumergeBookingTask;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import base.BaseClass;

public class TestCases extends BaseClass{ 
	public WebDriver driver;
	
	@BeforeTest
	public void loginBeforeTest() throws IOException {
		driver = initializeDriver();
		navigateToURL();

	}

}
