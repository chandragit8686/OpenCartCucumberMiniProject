package org.opencart.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\features\\loginpage.feature",
		plugin = {"html:target/cucumbe-Reports.html", "json:target/cucumber.json"},
		glue = {"org.opencart.stepdefinitions" },
		monochrome = true,
		publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
