Feature: Login functionality for saucedemo

  Background:
    Given User opens the application
  @smoke
  Scenario: Valid User Login
    When I login with "standard_user" and "secret_sauce"
    Then I should be redirected to the inventory page
  @smoke
  Scenario: Invalid username and invalid password
    When I login with "standard" and "secret"
    Then I should see  "Epic sadface: Username and password do not match any user in this service"

  Scenario: Without entering username and password
    Given : i clicked Login button without enter username and password
    Then : i should see  "Epic sadface: Username is required"

