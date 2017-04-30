package com.santos.app;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="src/test/java/features")
public class CukeRunnerTest extends AbstractTestNGCucumberTests {
	//TestNG @Test annotations are extended from AbstractTestNGCucumberTests
}
