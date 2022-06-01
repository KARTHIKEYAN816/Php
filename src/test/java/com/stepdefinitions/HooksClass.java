package com.stepdefinitions;

import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass {
	@Before
public void Before() {
	launchBrowser();
	wmaximize();
	LoadUrl("https://phptravels.com/demo/");
	driver.manage().deleteAllCookies();
	
}
@After
public void AfterExecution() throws IOException {
	ScreenShot();
	
	
}
	
}
