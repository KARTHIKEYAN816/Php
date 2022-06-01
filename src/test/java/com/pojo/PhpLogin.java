package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class PhpLogin extends BaseClass {
	
public PhpLogin() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/a")
private WebElement CustomerFrontEnd;

@FindBy(css="#TRAVEL_TECHNOLOGY_PARTNER")
private WebElement SiteVerify;

@FindBy(css="input[placeholder='Email']")
private WebElement Email;

@FindBy(css="input[placeholder='Password']")
private WebElement Password;

@FindBy(xpath="(//label[@for='rememberchb'])[1]")
private WebElement Remember;

@FindBy(xpath="(//button[@type='submit'])[1]")
private WebElement Login;

public WebElement getSiteVerify() {
	return SiteVerify;
}
public WebElement getCustomerFrontEnd() {
	return CustomerFrontEnd;
}
public WebElement getEmail() {
	return Email;
}
public WebElement getPassword() {
	return Password;
}
public WebElement getRemember() {
	return Remember;
}
public WebElement getLogin() {
	return Login;
}

}
