package com.santos.app;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.*;

public class TestBase {
	
	public void openBrowserTo(String url) {
		System.out.println("openBrowserTo");
		WebDriver driver = new InternetExplorerDriver();
		driver.navigate().to(url);
	}
	
}
