package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	public void wmaximize() {
		driver.manage().window().maximize();
	}
public void LoadUrl(String url) {
	driver.get(url);
}
public void Type(WebElement element,String type) {
	element.sendKeys(type);
}
public String GetText(WebElement element) {
	String text = element.getText();
	return text;
}
public String GetAttribute(WebElement element) {
  String value = element.getAttribute("value");	
return value;
}
public String verifyUrl() {
	String url = driver.getCurrentUrl();
	return url;
}

public void vrify(WebElement element,String text) {
if(element.getText().contains(text)) {
	System.out.println(text + "is verified Sucessfully");
}else {
	System.out.println(text+ " verification Unsucessful");
}
}


public String GetExcelData(String sName,int rNo,int cNo) throws IOException {
	String value = null;
	FileInputStream file=new FileInputStream
			("C:\\Users\\NOLAN\\eclipse-workspace\\New folder (2)\\PhpTravelAutomation\\src\\test\\resources\\ExcelData\\New Microsoft Excel Worksheet.xlsx");
	Workbook wb=new XSSFWorkbook(file);
	Sheet sheet = wb.getSheet(sName);
	Row row = sheet.getRow(rNo);
     Cell cell = row.getCell(cNo);
     int ct = cell.getCellType();
     if(ct==1) {
    	 value  = cell.getStringCellValue();
     }else if(ct==0){
    	 Date date = cell.getDateCellValue();
     if(DateUtil.isCellDateFormatted(cell)) {
    	 DateFormat df=new SimpleDateFormat("dd-MM-YYYY");
    	 value = df.format(date);
     }else {
    	 double nc = cell.getNumericCellValue();
    	 long l=(long)nc;
    	 value=String.valueOf(l);
     }
     }
return value;
}

public void whandle() {
	Set<String> win = driver.getWindowHandles();
	Iterator<String> iterator = win.iterator();
while(iterator.hasNext()) {
	driver.switchTo().window(iterator.next());
}
}
public void selectbyvalue(WebElement element,String value) {
	Select s=new Select(element);
	s.selectByValue(value);
	
}public void BtnClick(WebElement element) {
	element.click();
}
public void ScreenShot() throws IOException {
	TakesScreenshot tk=(TakesScreenshot)driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
	File des=new File
 ("C:\\Users\\NOLAN\\eclipse-workspace\\com.junit\\src\\test\\resources\\Screenshots\\Error.png");
	FileUtils.copyFile(src, des);
	
}
public void quit() {
	driver.close();
}
@SuppressWarnings("deprecation")
public void pause() {
	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
}
public boolean GetTitle(String text) {
	boolean contains = driver.getTitle().contains(text);
	return contains ;
}
public void SelectbyText(WebElement element,String text) {
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
public void SelectbyIndex(WebElement element,int index) {
	Select s=new Select(element);
	s.selectByIndex(index);
}
public void javaClick(WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", element);
	
}
public void DynamicDD(String s) {
	List<WebElement> list = driver.findElements(By.className("autocomplete-result"));
	for(WebElement o:list) {
		//System.out.println( o.getText());
		String text = o.getText();
		
		if (text.contains(s)) {
			javaClick(o);
			break;
			
		}
	}
	
}
public void Date(WebElement element,String date) {
	List<WebElement> departure = driver.findElements(By.xpath("//table[@class=' table-condensed']"));
	for(WebElement d:departure) {
		String text = d.getText();
		if(text.contains(date)) {
			d.click();
		}
	}
	
}
public void clear(WebElement element) {
	element.clear();
}
public void AdjustRange(WebElement element,int Xoffset,int YoffSet) {
	Actions act=new Actions(driver);
	act.dragAndDropBy(element, Xoffset, YoffSet).perform();
	
}

public void JavaDate(String date,WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('value','"+date+"')", element);
	
}

public static String[] monthyear(String MonthYearVal) {
	return MonthYearVal.split(" ");
	
}

public void DatePicker(WebElement element,WebElement next,String month,String day,String year) {
	
	
	if (month.equalsIgnoreCase("february") && Integer.parseInt(day)>29) {
		System.out.println("Wrong date"+month +":"+day);
		return;
	}
	if(Integer.parseInt(day)>31) {
		System.out.println("Wrong date"+month +":"+day);
		return;
	}
	String MonthYearVal = element.getText();
	while(!(monthyear(MonthYearVal)[0].equalsIgnoreCase(month) && monthyear(MonthYearVal)[1].equals(year))) {
	next.click();	
	MonthYearVal = element.getText();
	
	}
	try {
		driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
		
	} catch (Exception e) {
		System.out.println("Wrong date"+month +":"+day);
	}
}

public static String[] dp(String datevalue) {
	return datevalue.split(" ");
}

public void datep(WebElement element,WebElement next,String month,String day,String Year) {
	
	if(month.equalsIgnoreCase("february") && Integer.parseInt(day)>29) {
		System.out.println("wrong date "+month+":"+day);
		return;
	}
if(Integer.parseInt(day)>31) {
	System.out.println("wrong date "+month+":"+day);
	return;
}
String datevalue = element.getText();
while(!(dp(datevalue)[0].equalsIgnoreCase(month)&& dp(datevalue)[1].equals(Year))) {
	next.click();
	datevalue = element.getText();
}
try {
	driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
} catch (Exception e) {
	System.out.println("wrong date "+month+":"+day);
}
}

}
