@init
Feature: Consult user API

  Scenario: Consult user account
    Given I have one user account
    When I call find user API
    Then should return user
    And status code should be 200 for user response

  Scenario: Consult user account using invalid id
    Given I call find user API using invalid id
    Then should return not found user message error
    And status code should be 400 for user response
