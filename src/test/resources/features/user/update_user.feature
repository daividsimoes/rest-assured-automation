@init
Feature: Update user API

  Scenario: Update user account
    Given I have one user account
    And I build one user account
    When I call update user API
    Then should update user successfully
    And status code should be 200 for add user response

  Scenario: Add new user when try to update non existing id user account
    Given I build one user account
    When I call update user API with non existing id
    Then should add user successfully
    And status code should be 201 for add user response

  Scenario: Try add new user when try to update user account using existing email and invalid id
    Given I have one user account
    And I build one user account with same email
    When I call update user API with non existing id
    Then should return add user email already exist message error
    And status code should be 400 for add user response

  Scenario: Try update user account with blank data
    Given I have one user account
    And I build one user account with blank data
    When I call update user API
    Then should return add user required filds message error
    And status code should be 400 for add user response

  Scenario: Try update user account with empty data
    Given I have one user account
    And I build one user account with empty data
    When I call update user API
    Then should return add user empty fields message error
    And status code should be 400 for add user response
