package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CommonMethods {

    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication() {


        String browserType = ConfigReader.getPropertyValue("browserType");
        switch(browserType) {

            case "Chrome":
                driver = new ChromeDriver();
                break;

            case "Firefox":
                driver = new FirefoxDriver();
                break;

            case "IE":
                driver = new InternetExplorerDriver();
                break;

            case "Safari":
                driver = new SafariDriver();
                break;

            default:
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));

    }

    public static void closeBrowser() {
        driver.close();
    }

    public static void doClick (WebElement element) {
        element.click();
    }

    public static void sendKeys (WebElement element, String text) {
        element.sendKeys(text);
    }


}
