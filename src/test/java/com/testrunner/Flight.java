package com.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Feature\\Flight.feature",glue="com.stepdefinitions",
dryRun=false,plugin= {"junit:src\\test\\resources\\Reports\\sample.xml","json:src\\test\\resources\\Reports\\Flight.json"})

public class Flight {
@AfterClass	
public static void name() {
	JvmReport.Report(System.getProperty("user.dir")+
			"\\src\\test\\resources\\Reports\\Flight.json");
    
}	

}
