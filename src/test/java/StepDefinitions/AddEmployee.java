package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM tab")
    public void user_clicks_on_pim_tab() {
      //WebElement pimTab = driver.findElement(By.id("menu_pim_viewPimModule"));
      doClick(addEmployeePage.pimTab);
    }
    @Then("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
       // WebElement addEmployeeBtn = driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmployeePage.addEmployeeBtn);
    }
    @Then("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {

        // driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstname"));
        // WebElement firstNameTextBox = driver.findElement(By.id("firstName"));
        sendKeys(addEmployeePage.firstNameTextBox, ConfigReader.getPropertyValue("firstname"));
        // driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));
        //WebElement middleNameTextBox = driver.findElement(By.id("middleName"));
       sendKeys(addEmployeePage.middleNameTextBox, ConfigReader.getPropertyValue("middlename"));
        // driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));
        // WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
       sendKeys(addEmployeePage.lastNameTextBox, ConfigReader.getPropertyValue("lastname"));

    }
    @Then("user clicks on Save button")
    public void user_clicks_on_save_button() {
        // WebElement saveBtn = driver.findElement(By.id("btnSave"));
        doClick(addEmployeePage.saveBtn);
    }


}
