Feature: Employee

  @testcase2 #@smoke @regression
  Scenario: Adding a new Employee
    Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM tab
    Then user clicks on Add Employee option
    And user enters firstname and middlename and lastname
    #And user clicks on Save button