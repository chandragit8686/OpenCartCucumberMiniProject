package org.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// By locators
	private By emailInputLocator = By.name("email");
	private By passwordInputLocator = By.name("password");
	private By loginButtonLocator = By.xpath("//input[@type='submit']");
	private By forgotpasswordlinklocator = By.linkText("Forgotten Password");
	private By logoutlinkLocator = By.linkText("Logout");

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// page methods or actions
	public void enterEmail(String email) {
		WebElement emailInput = driver.findElement(emailInputLocator);
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement passwordInput = driver.findElement(passwordInputLocator);
		passwordInput.sendKeys(password);
	}

	public void clickLogInButton() {
		WebElement loginbutton = driver.findElement(loginButtonLocator);
		loginbutton.click();
	}

	public void clickForgottenPasswordLink() {
		WebElement forgotpasswordlink = driver.findElement(forgotpasswordlinklocator);
		forgotpasswordlink.click();
	}

	public boolean checkForgotPswdlink() {
		return driver.findElement(forgotpasswordlinklocator).isDisplayed();
	}

	public boolean checkLogOutlink() {
		return driver.findElement(logoutlinkLocator).isDisplayed();
	}

	public void login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLogInButton();
	}

	public String getForgotPwdPageUrl() {
		String forgotPwdPageUrl = driver.getCurrentUrl();
		return forgotPwdPageUrl;
	}

	public void clickLogOut() {
		WebElement logoutbutton = driver.findElement(logoutlinkLocator);
		logoutbutton.click();
	}

}
