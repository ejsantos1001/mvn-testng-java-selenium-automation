package com.santos.app;

import java.lang.System;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.openqa.selenium.JavascriptExecutor;
import java.util.function.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import java.util.List;
import java.util.Set;

public class StepDef {
	
	WebDriver driver = new InternetExplorerDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
    String xpath = "//frame[@name='iframeResult']";
    
	@Given("^a user navigates to test \"([^\"]*)\"$")
	public void openBrowserTo(String url) {

		System.out.println("openBrowserTo");
		driver.navigate().to(url);
		waitUntilBrowserIsOpen(driver);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	@And("^the user clicks \"([^\"]*)\"$")
	public void click(String xpath) {
		waitUntilElementIsPresent(driver,xpath);
		List<WebElement> oList = driver.findElements(By.xpath(xpath));
		oList.get(0).click();
		
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles.size());
		for(String handle:handles){
			System.out.println(handle);
		}
	}
	
	public void waitUntilElementIsPresent(WebDriver driver,String xpath) {
		swithToframe("iframeResult");
		Wait<WebDriver> wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	
	public void swithToframe(String frameName)  {
		new WebDriverWait(driver,15).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		
	}
	
	
	public void waitUntilBrowserIsOpen(WebDriver driver) {
		
		Wait<WebDriver> wait = new WebDriverWait(driver,30);
		wait.until(new Function<WebDriver,Boolean>() {
			public Boolean apply(WebDriver t) {
				Boolean test = false;
				System.out.println(test);
				System.out.println("test");
				test = js.executeScript("return document.readyState").equals("complete");
				System.out.println(test);
				return test;
			};	
	    });
	
     }
}
	

	
	
	


