Feature: Product Listing Page

  Background:
    Given User opens the application
    When I login with "error_user" and "secret_sauce"
  @smoke
  Scenario: Successful login lands on product listing page with visible products
    Then I should be redirected to the inventory page
    And I should see a list of products

  Scenario: Verify that sorting by "Price (low to high)" arranges products correctly
    And I sort the products by "Price (low to high)"
    Then I should see the products sorted in ascending order of price

