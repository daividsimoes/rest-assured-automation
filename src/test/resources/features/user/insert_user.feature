@init
Feature: Insert user API

  Scenario: Consult user accounts
    Given I build one user account
    When I call add user API
    Then should add user successfully
    And status code should be 201 for add user response