

Feature: Login functionality for saucedemo

  Scenario: Valid login with standard user
    Given User opens the website "https://www.saucedemo.com/ "
    When I login with "standard_user" and "secret_sauce"
    Then I should be redirected to the inventory page

  Scenario: invalid login with standard user
    Given User opens the website "https://www.saucedemo.com/ "
    When I login with "standard_user" and "secret_sauce"
    Then I should see  "Epic sadface: Username and password do not match any user in this service"






