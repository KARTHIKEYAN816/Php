package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class FlightSelection extends BaseClass {

	public FlightSelection() {
		PageFactory.initElements(driver, this);
		
	}
	
@FindBy(css="#direct")	
private WebElement Stop;
	
@FindBy(xpath="(//span[@class='irs-handle from'])[1]")	
private WebElement Lowprice;

@FindBy(xpath="(//span[@class='irs-handle to'])[1]")	
private WebElement HighPrice;

@FindBy(xpath="(//a[@class=' waves-effect'])[16]")	
private WebElement TotalFlight;


@FindBy(xpath="(//button[@type='submit'])[13]")	
private WebElement select ;

@FindBy(css="label[for='flights_1']")	
private WebElement WestJet ;

public WebElement getStop() {
	return Stop;
}


public WebElement getWestJet() {
	return WestJet;
}


public WebElement getLowprice() {
	return Lowprice;
}


public WebElement getHighPrice() {
	return HighPrice;
}


public WebElement getTotalFlight() {
	return TotalFlight;
}


public WebElement getSelect() {
	return select;
}





}
