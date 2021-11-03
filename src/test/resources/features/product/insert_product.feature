@init
Feature: Insert product API

  Scenario: Add product
    Given I have one admin user logged
    And I build one product
    When I call add product API
    Then should add product successfully
    And status code should be 201 for add product response

  Scenario: Try add same product twice
    Given I have one admin user logged
    And I add one product
    When I call add product API
    Then should return add product email already exist message error
    And status code should be 400 for add product response

  Scenario: Try add product with invalid token
    Given I have one admin user logged
    And I build one product
    When I call add product API with invalid token
    Then should return invalid token message error
    And status code should be 401 for add product response

  Scenario: Try add product with non admin user
    Given I have one non admin user logged
    And I build one product
    When I call add product API
    Then should return non admin message error
    And status code should be 403 for add product response
