@init
Feature: Insert user API

  Scenario: Add user account
    Given I build one user account
    When I call add user API
    Then should add user successfully
    And status code should be 201 for add user response

  Scenario: Add admin user account
    Given I build one admin user account
    When I call add user API
    Then should add user successfully
    And status code should be 201 for add user response

  Scenario: Try add user account with invalid email
    Given I build one user account with invalid email
    When I call add user API
    Then should return add user email message error
    And status code should be 400 for add user response

  Scenario: Try add two user accounts with same email
    Given I have one user account
    And I build one user account with same email
    When I call add user API
    Then should return add user email already exist message error
    And status code should be 400 for add user response

  Scenario: Try add user account with blank data
    Given I build one user account with blank data
    When I call add user API
    Then should return add user required filds message error
    And status code should be 400 for add user response

  Scenario: Try add user account with empty data
    Given I build one user account with empty data
    When I call add user API
    Then should return add user empty fields message error
    And status code should be 400 for add user response
