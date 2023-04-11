Feature: Searching the employee


  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM tab


  @smoke
  Scenario: Search employee by ID
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM tab
    When user enters valid employee ID
    And clicks on Search Button
    And user see employee information displayed
    #And Close the browser


    @smoke
    Scenario: Search employee Job Title
      #Given open the browser and launch HRMS application
      #When user enters valid email and valid password
      #And click on login button
      #When user clicks on PIM tab
      When user selects Job Title
      And clicks on Search Button
      And user see employee information displayed
      #And Close the browser

  # Whenever you have common steps in one feature file you can use a keyword provided by cucumber -
  # this is a "Background" keyword and it is used to define all common steps that multiple scenarios have
  # in the same feature file, till hte time flow is not broken

  # That means that steps where employee clicks on search button and sees information displayed
  # cannot be added to background because flow is broken before them!!!