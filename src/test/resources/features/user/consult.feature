@init
Feature: Consult API

  Scenario: Consult user accounts
    Given I have one user account
    When I call find user API
    Then should return user list
    And status code should be 200

  Scenario: Consult user account by query id
    Given I have one user account
    When I call find user API using query id
    Then should return user
    And status code should be 200

  Scenario: Consult invalid user account by query id
    Given I call find user API using invalid id as query id
    Then should not return users
    And status code should be 200

  Scenario: Consult Admin user account by query admin
    Given I have one Admin user account
    When I call find user API using query admin "true"
    Then should return admin user
    And status code should be 200

  Scenario: Consult non Admin user account by query admin
    Given I have one user account
    When I call find user API using query admin "false"
    Then should return non admin user
    And status code should be 200