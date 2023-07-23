package org.opencart.stepdefinitions;

import org.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinition {

	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void SetUp() {
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("I am on the opencart login page")
	public void i_am_on_the_opencart_login_page() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		loginPage = new LoginPage(driver);
	}

	@Given("I have Entered valid username and password")
	public void i_have_entered_valid_username_and_password() {
		loginPage.enterEmail("kirank@gmail.com");
		loginPage.enterPassword("86867799");
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		loginPage.clickLogInButton();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		Assert.assertEquals(loginPage.checkLogOutlink(), true);
	}

	@Given("I have Entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String username, String password) {
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
	}

	@Then("I should see an error meassage indicationg {string}")
	public void i_should_see_an_error_meassage_indicationg(String string) {
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
	}

	@Given("I click on the {string} link")
	public void i_click_on_the_link(String string) {
		loginPage.clickForgottenPasswordLink();
	}

	@Then("I should be redirected to password reset page")
	public void i_should_be_redirected_to_password_reset_page() {
		 Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
	}

}
