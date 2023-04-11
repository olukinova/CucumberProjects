package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {
    @Before
    public void preConditions () {
        openBrowserAndLaunchApplication();
    }
    @After
    public void postConditions () {
        // here you can write a code to make a screenshot
        closeBrowser();
        // here can be the code to generate a report, that's why hooks are useful
    }
}
