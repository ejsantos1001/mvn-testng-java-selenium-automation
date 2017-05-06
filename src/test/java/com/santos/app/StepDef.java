package com.santos.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.System;
import java.nio.file.Path;

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
	
	@And("^print file$") 
	public void printFile() {
		
		File file = new File("C:/Users/Ej/Documents/testautomationframework/text.txt");
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			FileWriter fw = new FileWriter(file);
			BufferedWriter buffer = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(buffer);
			pw.print("newtest2");
			
			
			
			pw.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@And("^test$") 
	public void testStep() {
		
		String locatorString = "//test";
		
		if(locatorString.startsWith("xpath")) {
			System.out.println("true");
		} else System.out.println("false");
		
		locatorString = "xpath:=//";
		
		if(locatorString.startsWith("xpath")) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
	
		
	}
	
	
	@And("^frame test$")
	public void frameTest() {

		List<WebElement> elementList = driver.findElements(By.xpath("//iframe")); 
		System.out.println(elementList.size());
		for(WebElement e: elementList) {
			System.out.println(e.getAttribute("id"));
		}
		
	}
	
	@And("^the user clicks \"([^\"]*)\"$")
	public  void click(String xpath) {
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
	

	
	
	


