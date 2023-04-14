package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Login extends CommonMethods {

    // After adding hooks code for opening browser can be commented or deleted
    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {
       openBrowserAndLaunchApplication();
    }

    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
       // LoginPage login = new LoginPage();

       sendKeys(login.userNameTextBox, ConfigReader.getPropertyValue("username"));

       sendKeys(login.userPasswordTextBox, ConfigReader.getPropertyValue("password"));

    }

    @When("click on login button")
    public void click_on_login_button() {
        // LoginPage login = new LoginPage();
        doClick(login.loginBtn);
    }

    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
      boolean userLoggedIn = driver.findElement(By.xpath("//a[contains(text(), 'Welcome')]")).isDisplayed();
      if (userLoggedIn) {
          System.out.println("User is logged in successfully");
      } else {
          System.out.println("User was not logged in");
      }
    }


    // After adding hooks code for closing browser can be commented or deleted
    @Then("Close the browser")
    public void close_the_browser() {
      closeBrowser();
    }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
       // LoginPage login = new LoginPage();
        sendKeys(login.userNameTextBox, username);
        sendKeys(login.userPasswordTextBox, password);
    }

    @When("user enters username and password and verifies login")

    // only opens the browser once and closes it once!!!
    // This is very important advantage of datatable
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
       List<Map<String, String>> userCredentials = dataTable.asMaps();
       // LoginPage login = new LoginPage();
       for (Map <String, String> credential: userCredentials) {

           String username = credential.get("username");
           String password = credential.get("password");

           sendKeys(login.userNameTextBox, username);
           sendKeys(login.userPasswordTextBox, password);
           doClick(login.loginBtn);
           doClick(login.welcomeBtn);
           doClick(login.logoutBtn);

       }
    }




}
