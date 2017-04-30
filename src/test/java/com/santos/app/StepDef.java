package com.santos.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import cucumber.api.java.en.Given;


public class StepDef {
	WebDriver driver = null;
	@Given("^a user navigates to \"([^\"]*)\"$")
	public void openBrowserTo(String url) {
		System.out.println("openBrowserTo");
		driver = new InternetExplorerDriver();
		driver.navigate().to(url);
	}

}
