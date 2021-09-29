@init
Feature: Login API

  Scenario: Login with valid user account
    Given I have one user account
    When I perform the login
    Then should login successfully
    And status code should be 200 for login response

  # Swagger uses status code 400 for this scenario - Test failing
  Scenario: Try login with non existing user account
    Given I perform the login with non existing user account
    Then should return invalid email or password login error
    And status code should be 400 for login response

  # Swagger uses status code 400 for this scenario - Test failing
  Scenario: Try login with valid user account and invalid password
    Given I have one user account
    When I perform the login with invalid password
    Then should return invalid email or password login error
    And status code should be 400 for login response

  Scenario: Try login without user account
    Given I perform the login without user account
    Then should return login required fields message error
    And status code should be 400 for login response

  Scenario: Try login with empty user account
    Given I perform the login with empty user account
    Then should return login user empty fields message error
    And status code should be 400 for login response
