package com.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.pojo.Flight;
import com.pojo.FlightSelection;
import com.pojo.PhpEmailPage;
import com.pojo.PhpHome;
import com.pojo.PhpLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseClass {
	BaseClass b=new BaseClass();
	
	
	PhpHome ph=new PhpHome();
	
	
	
	@Given("User Launch PhpTravel Site")
	public void user_launch_php_travel_site() {
	  
	}

	@Then("User verifies Page is Correct")
	public void user_verifies_page_is_correct() {
		PhpLogin pl=new PhpLogin();
	//System.out.println(driver.findElement(By.cssSelector("#TRAVEL_TECHNOLOGY_PARTNER")).getText());	
	Assert.assertTrue("Verified", pl.getSiteVerify().getText().startsWith("TRAVEL"));
	//b.vrify(pl.getSiteVerify(), "TRAVEL TECHNOLOGY PARTNER");
	
	}

	@When("User Clicks Customer Front End Button")
	public void user_clicks_customer_front_end_button() {
		PhpLogin pl=new PhpLogin();
      b.BtnClick(pl.getCustomerFrontEnd());
    
	}
	@Then("User Enters Valid UserName and PassWord")
	public void user_Enters_Valid_UserName_and_PassWord() throws IOException, InterruptedException {
		
		b.whandle();
		PhpEmailPage pe=new PhpEmailPage();	
		b.pause();
	   b.Type(pe.getEmail(), b.GetExcelData("Sheet1", 0, 1));
	   b.Type(pe.getPassword(), b.GetExcelData("Sheet1", 1, 1));
	   
	}
	@Then("clicks Remember me Button and clicks Login Button")
	public void clicks_Remember_me_Button_and_clicks_Login_Button() {
		PhpEmailPage pe=new PhpEmailPage();	
		b.pause();
		/*WebElement rem = driver.findElement(By.xpath("(//label[@for='rememberchb'])[1]"));
		WebElement sign = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", rem);
		js.executeScript("arguments[0].click()", sign);*/
		b.javaClick(pe.getRemember());
		b.javaClick(pe.getLogin());
		//b.BtnClick(pe.getRemember());
		//b.BtnClick(pe.getLogin());
	}

	@Then("User Verifies PhpTravel HomePage is Displayed")
	public void user_verifies_php_travel_home_page_is_displayed() {
	b.pause();
	System.out.println(b.GetTitle("https://www.phptravels.net/account/dashboard"));
	
	
	
	}

	@When("User Clicks Flight Link and User verifies Flight BookingPage is Displayed")
	public void user_clicks_flight_link_and_user_verifies_flight_booking_page_is_displayed() {
		Flight fl=new Flight();
	b.BtnClick(fl.getFlight());
	b.GetTitle("flights");
		
	}

	@Then("User Selects RoundTrip,FlightType,Starting Place,Destination,Depature Date,Travellers Details and clicks Serch Button")
	public void user_selects_round_trip_flight_type_starting_place_destination_depature_date_travellers_details_and_clicks_serch_button() throws IOException, InterruptedException {
		Flight fl=new Flight();
		b.BtnClick(fl.getRoundTrip());
		b.selectbyvalue(fl.getFlightType(), "first");
		b.Type(fl.getFrom(), "biar");
		b.pause();
		b.DynamicDD("Biarritz-bayonne");
		
		b.BtnClick(fl.getDestination());
		b.Type(fl.getDestination(), "Cra");
		b.DynamicDD("Cranbrook");
		b.BtnClick(fl.getDate());
	
		b.DatePicker(fl.getMonthYear(), fl.getDateNext(), "October","16","2022");
		Thread.sleep(3000);
		//b.JavaDate(b.GetExcelData("Sheet1", 2, 1), fl.getDate());
		//b.Type(fl.getDate(), b.GetExcelData("Sheet1", 2, 1));
		//b.clear(fl.getReturnDate());
		b.JavaDate(b.GetExcelData("Sheet1", 3, 1), fl.getReturnDate());
	   // b.Type(fl.getReturnDate(), b.GetExcelData("Sheet1", 3, 1));
		//b.BtnClick(fl.getReturnDate());
		//b.DatePicker(fl.getReturnMonthYear(), fl.getReturnDateNext(), "October","22","2022");
		WebDriverWait wait =new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.elementToBeClickable(fl.getPassengers()));
		b.BtnClick(fl.getPassengers());
	    b.clear(fl.getAdults());
	    b.Type(fl.getAdults(), b.GetExcelData("Sheet1", 4, 1));
	    b.Type(fl.getInfants(), b.GetExcelData("Sheet1", 5, 1));
	    b.BtnClick(fl.getAdd());
	    b.BtnClick(fl.getSerch());
	}
	@When("User Selects Flight Stop as Direct and Gets Total Flights")
	public void user_Selects_Flight_Stop_as_Direct_and_Gets_Total_Flights() {
		FlightSelection fs=new FlightSelection();
		//b.BtnClick(fs.getStop());
		System.out.println(b.GetText(fs.getTotalFlight()));
		
	}

	
	@Then("User Sorts Flight Fair and Selects Airline as Hop")
	public void user_Sorts_Flight_Fair_and_Selects_Airline_as_Hop() throws InterruptedException {
		FlightSelection fs=new FlightSelection();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("span.irs-bar[style]")).getSize().width);
		int x=fs.getLowprice().getSize().width;
		
	
	//b.a(fs.getLowprice());
		b.AdjustRange(fs.getLowprice(),35, 0);
		Thread.sleep(3000);
		int y=fs.getHighPrice().getSize().width;
	
		b.AdjustRange(fs.getHighPrice(),-30, 0);
		b.BtnClick(fs.getWestJet());
	}
	
}
