Feature: Search and place the order for products

  Scenario: Search Experience for product search in both Home and Offers page

    Given User is on GreenKart Landing page
    When user searched with Shortname "Tom" and extracted actual name of product
    Then user searched for "Tom" shortname in offers page
    And  validate product name in offers page matches with Landing Page



