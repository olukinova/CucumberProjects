package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
        Assert.assertTrue(addEmployeePage.saveBtn.isDisplayed());
        System.out.println("Save button is displayed");
        doClick(addEmployeePage.saveBtn);
    }

    @Then("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fname, String mname, String lname) {
      sendKeys(addEmployeePage.firstNameTextBox, fname);
      sendKeys(addEmployeePage.middleNameTextBox, mname);
      sendKeys(addEmployeePage.lastNameTextBox, lname);
    }
    @Then("user captures the employee id")
    public void user_captures_the_employee_id() {
       GlobalVariables.emp_id =  addEmployeePage.empIdLocator.getAttribute("value");
       System.out.println("The employee id is " + GlobalVariables.emp_id);
    }
    @Then("query the information in backend")
    public void query_the_information_in_backend() {
        String query = "select * from hs_hr_employees where employee_id = '" + GlobalVariables.emp_id + "';";
       // to store the table coming from db, we used global var here
        // In this variable we got all keys and values from the employee we searched
        GlobalVariables.tableData = DBUtility.getListOfMapsFromRSet(query);
    }
    @Then("verify the results from front-end and backend")
    public void verify_the_results_from_front_end_and_backend() {
        // now, from all these values we need to compare one by one value
        String firstNameFromDB = GlobalVariables.tableData.get(0).get("emp_firstname");
        System.out.println(firstNameFromDB);
        String lastNameFromDB = GlobalVariables.tableData.get(0).get("emp_lastname");
        System.out.println(lastNameFromDB);
        String middleNameFromDB = GlobalVariables.tableData.get(0).get("emp_middle_name");
        System.out.println(middleNameFromDB);

        // adding assertions
        // Actual values may be passed from config file using ConfigReader class
        Assert.assertEquals(firstNameFromDB, "Nesha");
        Assert.assertEquals(lastNameFromDB, "Standart");
        Assert.assertEquals(middleNameFromDB, "Sania");
        System.out.println("My assertion have passed");
    }


}
