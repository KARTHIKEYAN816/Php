package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Flight extends BaseClass{
	public Flight() {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[contains(text(),'flights')]")	
private WebElement Flight;

@FindBy(css="#round-trip")
private WebElement RoundTrip;
@FindBy(css="#flight_type[class*='flight']")
private WebElement FlightType;
@FindBy(xpath="(//*[@name='from'])[1]")
private WebElement From;

@FindBy(css="[name='to'][id='autocomplete2']")
private WebElement Destination;

@FindBy(xpath="(//input[@id='departure'])[1]")
private WebElement Date;

@FindBy(css="[role='button']")
private WebElement Passengers;

@FindBy(css="#fadults[type='text']")
private WebElement Adults;

@FindBy(css="#fchilds[type='text']")
private WebElement Childs;

@FindBy(xpath="//input[@id='return']")
private WebElement ReturnDate;

@FindBy(css="[type='button'][id*='flight']")
private WebElement Serch;


@FindBy(xpath="(//th[@class='next'])[1]")
private WebElement DateNext;

@FindBy(css="#finfant[type='text']")
private WebElement Infants;

@FindBy(xpath="(//div[@class='qtyInc'])[1]")
private WebElement add;

@FindBy(xpath="(//th[@colspan='5'])[1]")
private WebElement MonthYear;

@FindBy(xpath="(//th[@colspan='5'])[4]")
private WebElement returnMonthYear;

@FindBy(xpath="(//th[@class='next'])[4]")
private WebElement returnDateNext;



public WebElement getReturnMonthYear() {
	return returnMonthYear;
}


public WebElement getReturnDateNext() {
	return returnDateNext;
}


public WebElement getMonthYear() {
	return MonthYear;
}


public WebElement getAdd() {
	return add;
}


public WebElement getFlight() {
	return Flight;
}


public WebElement getInfants() {
	return Infants;
}


public WebElement getReturnDate() {
	return ReturnDate;
}


public WebElement getRoundTrip() {
	return RoundTrip;
}


public WebElement getFlightType() {
	return FlightType;
}


public WebElement getFrom() {
	return From;
}


public WebElement getDestination() {
	return Destination;
}


public WebElement getDate() {
	return Date;
}


public WebElement getPassengers() {
	return Passengers;
}


public WebElement getAdults() {
	return Adults;
}


public WebElement getChilds() {
	return Childs;
}


public WebElement getSerch() {
	return Serch;
}


public WebElement getDateNext() {
	return DateNext;
}



}
