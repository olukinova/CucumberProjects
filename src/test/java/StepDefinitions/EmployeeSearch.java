package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {

    @When("user enters valid employee ID")
    public void user_enters_valid_employee_id() {
    WebElement employeeIdTextBox = driver.findElement(By.xpath("//input[@id='empsearch_id']"));
    sendKeys(employeeIdTextBox, ConfigReader.getPropertyValue("empID"));

    }
    @When("clicks on Search Button")
    public void clicks_on_search_button() {
        WebElement searchBtn = driver.findElement(By.xpath("//input[@id='searchBtn']"));
        doClick(searchBtn);
    }
    @When("user see employee information displayed")
    public void user_see_employee_information_displayed() {
        System.out.println("The employee is displayed");
    }

    @When("user selects Job Title")
    public void user_selects_job_title() {
        WebElement jobTitleDdl = driver.findElement(By.xpath("//select[@id='empsearch_job_title']"));
        selectByOptions(jobTitleDdl, ConfigReader.getPropertyValue("jobTitle"));

        WebElement employeeStatusDDL = driver.findElement(By.xpath("//select[@id='empsearch_employee_status']"));
        selectByOptions(employeeStatusDDL, "Active");

        WebElement includeDDL = driver.findElement(By.xpath("//select[@id='empsearch_termination']"));
        selectByOptions(includeDDL, "Current and Past Employees");

    }

}
