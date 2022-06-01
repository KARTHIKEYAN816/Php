package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class PhpHome extends BaseClass {
	public PhpHome() {
		PageFactory.initElements(driver, this);
	}
@FindBy(css="[href*='hotels']")
private WebElement Hotel;
public WebElement getHotel() {
	return Hotel;
}


}

