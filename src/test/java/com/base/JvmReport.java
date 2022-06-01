package com.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {
	public static void Report(String report) {
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports");
		
		Configuration con =new Configuration(f, "PHP Travel Automatiopn");
		con.addClassifications("Platform", "Windows");
		con.addClassifications("version", "10");
		con.addClassifications("Build Num", "12.345B");
		con.addClassifications("Sprin", "2.3");
		List<String> l=new ArrayList<String>();
		l.add(report);
		ReportBuilder re=new ReportBuilder(l, con);
	  re.generateReports();
		
	}

}
