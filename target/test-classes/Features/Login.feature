Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin Login
    # Given open the browser and launch HRMS application - this step was commented because now it is managed by hooks
    When user enters valid email and valid password
    # You can also write like this: When user enters valid email "useremail" and valid password "userPassword"
    # or When user enters valid email "useremail2" and valid password "userPassword2"
    # and in this case you will not have to write separate step definition for each change
    And click on login button
    Then user is logged in successfully
    # And Close the browser this step was commented because now it is managed by hooks

  #Another way to get data from property file:
  @smoke2
  Scenario: Valid Admin Login
    # Given open the browser and launch HRMS application - this step was commented because now it is managed by hooks
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    # And Close the browser this step was commented because now it is managed by hooks

    # using slash symbol we can make comments in the features file