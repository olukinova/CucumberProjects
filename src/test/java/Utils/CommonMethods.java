package Utils;

import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {

        String browserType = ConfigReader.getPropertyValue("browserType");
        switch (browserType) {

            case "Chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--no-sandbox"); // lines 36 and 37 were implemented due to bug in selenium and will be remover
                // they are basically useless
                ops.addArguments("--remote-allow-origins=*");
                if (ConfigReader.getPropertyValue("Headless").equals("true")) {
                    ops.addArguments("--headless=new");
                }
                driver = new ChromeDriver(ops);
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
        initializePageObjects(); // this code will initialize all pages (see PageInitializer Class)
        // when launching the application

        // To configure file and pattern write this code:
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("This is the beginning of my Test case");
        Log.info("My Test case is being executed right now");
        Log.warning("My Test case might have some trivial issues");
    }

    public static void closeBrowser() {
        Log.info("This Test case is about to get completed");
        Log.endTestCase("This Test case is finished");
        driver.close();
    }

    public static void doClick(WebElement element) {
        //here may be the code for explicit wait
        // for the element to be clickable
        element.click();
    }

    public static void sendKeys(WebElement element, String text) {
        element.clear(); //it is a good practice to clear text box
        element.sendKeys(text);
    }

    public static Select clickOnDropdown(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value) {
        clickOnDropdown(element).selectByValue("value");
    }

    public static void selectByVisibleText(WebElement element, String text) {
        clickOnDropdown(element).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index) {
        clickOnDropdown(element).selectByIndex(index);
    }

    public static void selectByOptions(WebElement element, String text) {
        List<WebElement> options = clickOnDropdown(element).getOptions();
        for (WebElement option : options) {
            String ddlOptionText = option.getText();
            if (ddlOptionText.equals(text)) {
                option.click();
            }
        }
    }

    // ====================SCREENSHOT====================


    //Here is a step-by-step explanation of what this code does:
    //
    //The first line of the method creates a new "TakesScreenshot" object called "ts". This is an interface in Selenium that allows us to capture screenshots of the current web page. We cast the WebDriver instance "driver" to this interface so that we can use its methods to take the screenshot.
    //
    //The second line of the method calls the "getScreenshotAs" method of the "TakesScreenshot" object and passes in the "OutputType.BYTES" argument. This method captures a screenshot of the current web page as a byte array and stores it in the "picBytes" variable.
    //
    //The third line of the method calls the "getScreenshotAs" method again, this time passing in the "OutputType.FILE" argument. This method captures a screenshot of the current web page as a file and stores it in the "sourcePath" variable.
    //
    //The fourth line of the method uses the "FileUtils" class from the Apache Commons IO library to copy the screenshot file to a specified location. The "copyFile" method takes two arguments - the source file (which is the "sourcePath" variable) and the destination file (which is a new File object created using a combination of the "Constants.SCREENSHOT_FILEPATH" constant, the "imageName" parameter, and a timestamp generated by the "getTimeStamp" method). If there is an error during the file copy process, the method throws a RuntimeException.
    //
    //Finally, the method returns the byte array containing the screenshot data.
    public static byte[] takeScreenshot(String imageName) {
        TakesScreenshot ts = (TakesScreenshot)driver; // in this line we cast the web driver instance 'driver'
        byte [] picBytes = ts.getScreenshotAs(OutputType.BYTES); // we should select bytes because screenshots are stored as array of bites
        File sourcePath = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;
    }


    // Here's how this code works:
    //
    //The method begins by creating a new instance of the "Date" class, which represents the current date and time.
    //It then creates a new instance of the "SimpleDateFormat" class, which is used to format dates according to a specific pattern. The "pattern" argument passed to the method specifies the pattern to use for the formatting.
    //The method then calls the "format" method of the "SimpleDateFormat" object, passing in the "date" object as an argument. This method returns a string representation of the date and time formatted according to the specified pattern.
    //Finally, the method returns the formatted timestamp string.

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}
