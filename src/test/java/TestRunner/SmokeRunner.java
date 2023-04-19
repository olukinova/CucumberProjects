package TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = "StepDefinitions",
        dryRun = false,
        tags = "@testcase2",
        plugin = {"pretty", "html:target/Cucumber.html", "json:target/Cucumber.json", "rerun:target/failed.txt"})
// tags option execute the tagged testcase as mentioned in your runner class

public class SmokeRunner {

}

// target folder is mostly used for storing test case execution reports generated using cucumber
// we can generate html, json, xml report
