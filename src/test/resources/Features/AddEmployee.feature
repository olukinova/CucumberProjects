Feature: Employee


  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM tab
    Then user clicks on Add Employee option


  @testcase2 #@smoke @regression
  Scenario: Adding a new Employee
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM tab
    #Then user clicks on Add Employee option
    And user enters firstname and middlename and lastname
    And user clicks on Save button
    #And Close the browser


  Scenario: adding the employee from front-end and verifying it from the backend
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM tab
    #Then user clicks on Add Employee option
    And user enters "Nesha" and "Sania" and "Standart"
    And user captures the employee id
    And user clicks on Save button
    And query the information in backend
    Then verify the results from front-end and backend


