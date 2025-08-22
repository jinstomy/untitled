Feature: Product Listing Page

  Scenario: Successful login lands on product listing page with visible products
    Given User opens the website "https://www.saucedemo.com/"
    When I login with "error_user" and "secret_sauce"
    Then I should be redirected to the inventory page
    And I should see a list of products

  Scenario: Verify that sorting by "Price (low to high)" arranges products correctly
    Given User opens the website "https://www.saucedemo.com/"
    When I login with "standard_user" and "secret_sauce"
    And I sort the products by "Price (low to high)"
    Then I should see the products sorted in ascending order of price
