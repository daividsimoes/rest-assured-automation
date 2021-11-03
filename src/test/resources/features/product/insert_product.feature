Feature: Insert product API

  Scenario: Add product
    Given I have one admin user logged
    And I build one product
    When I call add product API
    Then should add product successfully
    And status code should be 201 for add user response