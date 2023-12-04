Feature: Verify login

  @TC_AUTH_01
  Scenario: Verify login successfully
    Given I perform authenticate operation for "/auth/login"
      |email            |password|
      |admin@email.com  |admin*  |
    Then I see the status code is 200

  @TC_AUTH_02
  Scenario: Verify login unsuccessfully
    Given I perform authenticate operation for "/auth/login"
      |email            |password|
      |admin1@email.com |admin*  |
    Then I see the status code is 401