package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    public LoginPage() {

        PageFactory.initElements(driver, this);
        // this will initialize web elements using driver on login page
        // As you may see below, without using this code elements will be declared only
    }

    // Page Factory Model approach
    // this code will maintain the web elements of login page
    @FindBy(xpath = "//input[@id='txtUsername']")
    public WebElement userNameTextBox;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement userPasswordTextBox;

    @FindBy(xpath = "//input[@id='btnLogin']")
    public WebElement loginBtn;

    @FindBy(id = "welcome")
    public WebElement welcomeBtn;

    @FindBy(xpath = "//a[contains(text(), \"Logout\")]")
    public WebElement logoutBtn;





}
