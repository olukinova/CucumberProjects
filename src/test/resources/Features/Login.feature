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

  #A way to get data from feature file:
  @smoke2
  Scenario: Valid Admin Login
    # Given open the browser and launch HRMS application - this step was commented because now it is managed by hooks
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    # And Close the browser this step was commented because now it is managed by hooks

    # using slash symbol we can make comments in the features file

  # You can push the data to the Step Definitions:
  # hard code
  # property file
  # regular expressions of cucumber (see @smoke2): put the data in double quotes, supports DDT
  # Scenario outline (we were not provided with example) - provided by cucumber too:
  #   - Parametrization can be achieved through Scenario outline
  #   - Data driven (whe you get data fro external files - excel, json, etc.)

  # Parametrization (multiple data for the same test case):
  # Executing the same test case with multiple data

  # Scenario outline is always used with the keyword "Examples"
  @ScenarioOutline
   Scenario Outline:
    # Given open the browser and launch HRMS application - this step was commented because now it is managed by hooks
     When user enters valid "<username>" and valid "<password>"
     And click on login button
     Then user is logged in successfully
    # And Close the browser this step was commented because now it is managed by hooks
   Examples:
     | username | password    |
     | admin    | Hum@nhrm123 |
     | ADMIN    | Hum@nhrm123 |
     | Jason    | Hum@nhrm123 |