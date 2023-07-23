Feature: Login Functionality for OpenCart E-commerce Website

  Background: 
    Given I am on the opencart login page

  Scenario: Successfull login with valid credentials
    Given I have Entered valid username and password
    When I click on login button
    Then I should be logged in successfully

  Scenario Outline: UnSuccessfull login with invalid credentials
    Given I have Entered invalid "<username>" and "<password>"
    When I click on login button
    Then I should see an error meassage indicationg "<error_message>"

    Examples: 
      | username          | password        | error_message                                         |
      | kirank@gmail.com  | invalidpassword | Warning: No match for E-Mail Address and/or Password. |
      | invalid@gmail.com |        86867799 | Warning: No match for E-Mail Address and/or Password. |
      | invlaid@gmail.com | invalidpassword | Warning: No match for E-Mail Address and/or Password. |

  Scenario: Navigating to forgotten password page
    Given I click on the "Forgotten passord" link
    Then I should be redirected to password reset page
