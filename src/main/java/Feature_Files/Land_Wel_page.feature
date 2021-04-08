Feature: User must be able to see Welcome Screen,Login and Sign up

  Scenario: Validate user is able to click on Login button and navigate to Login page
    Given Browser is open 
    And User is on Landing Welcome Page
    When User clicks on the Login button 
    Then User navigate to Login page
    
  Scenario: Validate user is able to click on Sign Up button and navigate to Sign Up page
    Given User is on Welcome Page
    When User clicks on Sign up button  
    Then User navigate to Sign up page
    