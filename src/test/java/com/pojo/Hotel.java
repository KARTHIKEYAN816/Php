package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Hotel extends BaseClass {
	public Hotel() {
		PageFactory.initElements(driver, this);
	}
@FindBy(css="#select2-hotels_city-container")
	private WebElement CityName;
@FindBy(xpath="(//i[contains(@class,'icon mdi')])[1]")
private WebElement DateNext;
@FindBy(css="[name='checkin']")
private WebElement Checkin;
@FindBy(css="[name='checkout']")
private WebElement Checkout;
@FindBy(css="[role='button']")
private WebElement Traveller;
@FindBy(css="[name='roomInput']")
private WebElement Rooms;
@FindBy(css="[id='adults']")
private WebElement Adults;
@FindBy(css="[id='childs']")
private WebElement Childs;
@FindBy(css="#submit")
private WebElement Serch;
public WebElement getCityName() {
	return CityName;
}
public WebElement getDateNext() {
	return DateNext;
}
public WebElement getCheckin() {
	return Checkin;
}
public WebElement getCheckout() {
	return Checkout;
}
public WebElement getTraveller() {
	return Traveller;
}
public WebElement getRooms() {
	return Rooms;
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



}
