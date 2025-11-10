Feature: SauceDemo Login validation (UC-1, UC-2, UC-3)
  As a user of SauceDemo
  I want to validate the login form behaviors
  So that I can trust field validations and sign in successfully

  Background:
    Given I launch the SauceDemo site "https://www.saucedemo.com/"

  # UC-1
  Scenario: Login form with empty credentials shows username required
    When I type any credentials into username and password
    And I clear the inputs
    And I click the Login button
    Then I should see username required error

  # UC-2
  Scenario: Login form with missing password shows password required
    When I type "dummyUser" into username
    And I type "somePassword" into password
    And I clear only the password input
    And I click the Login button
    Then I should see password required error

  # UC-3 (parametrized "data provider")
  Scenario Outline: Successful login with accepted usernames
    When I login with accepted username "<username>" and password "secret_sauce"
    Then I should be on the dashboard with title "Swag Labs"

    Examples:
      | username                 |
      | standard_user            |
      | problem_user             |
      | performance_glitch_user  |