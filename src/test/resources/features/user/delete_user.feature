@init
Feature: Delete user API

  Scenario: Delete user account
    Given I have one user account
    When I call delete user API
    Then should delete user successfully
    And status code should be 200 for delete user response

  Scenario: Try delete same user account twice
    Given I have one user account deleted
    When I call delete user API
    Then should return no one record was deleted message error
    And status code should be 200 for delete user response

  Scenario: Try delete user account with invalid id
    Given I call delete user API using invalid id
    Then should return no one record was deleted message error
    And status code should be 200 for delete user response

  Scenario: Consult deleted user account
    Given I have one user account deleted
    When I call find user API
    Then should return not found user message error
    And status code should be 400 for user response

  Scenario: Consult deleted user account by query id
    Given I have one user account deleted
    When I call find user list API using query id
    Then should not return users
    And status code should be 200 for user list response