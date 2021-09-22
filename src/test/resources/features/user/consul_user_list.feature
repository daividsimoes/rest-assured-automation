@init
Feature: Consult user list API

  Scenario: Consult user accounts
    Given I have one user account
    When I call find user list API
    Then should return user list
    And status code should be 200 for user list response

  Scenario: Consult user account by query id
    Given I have one user account
    When I call find user list API using query id
    Then should return user list
    And status code should be 200 for user list response

  Scenario: Consult invalid user account by query id
    Given I call find user list API using invalid id as query id
    Then should not return users
    And status code should be 200 for user list response

  Scenario: Consult Admin user account by query admin
    Given I have one Admin user account
    When I call find user list API using query admin "true"
    Then should return admin user
    And status code should be 200 for user list response

  Scenario: Consult non Admin user account by query admin
    Given I have one user account
    When I call find user list API using query admin "false"
    Then should return non admin user
    And status code should be 200 for user list response

  Scenario: Consult invalid user account by Admin query
    Given I have one user account
    When I call find user list API using query admin "test"
    Then should return Admin message error
    And status code should be 400 for user list response

  Scenario: Consult user account by query name
    Given I have one user account
    When I call find user list API using query name
    Then should return user list
    And status code should be 200 for user list response

  Scenario: Consult invalid user account by query name
    Given I call find user list API using invalid name as query name
    Then should not return users
    And status code should be 200 for user list response

  Scenario: Consult user account by query email
    Given I have one user account
    When I call find user list API using query email
    Then should return user list
    And status code should be 200 for user list response

  Scenario: Consult non existing user account by query email
    Given I call find user list API using non existing email as query email
    Then should not return users
    And status code should be 200 for user list response

  Scenario: Consult invalid user account by query email
    Given I call find user list API using invalid email as query email
    Then should return email message error
    And status code should be 400 for user list response

  Scenario: Consult user account by query password
    Given I have one user account
    When I call find user list API using query password
    Then should return user list
    And status code should be 200 for user list response

  Scenario: Consult non existing user account by query password
    Given I call find user list API using non existing password as query password
    Then should not return users
    And status code should be 200 for user list response

  Scenario: Consult user account by all queries
    Given I have one user account
    When I call find user list API using all queries
    Then should return user list
    And status code should be 200 for user list response

  Scenario: Consult non existing user account by all queries usind invalid Id
    Given I call find user list API using invalid id with all queries
    Then should not return users
    And status code should be 200 for user list response
