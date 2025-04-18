@BugsForm
Feature: User Registration on Buggy Cars Rating Website
  As a new user
  I want to register on the Buggy Cars Rating website
  So that I can log in and participate in the platform

  Scenario Outline: Successful registration with valid details
    Given I am on the registration page
    When I fill in the registration form with the following details:
      | username        | <username>       |
      | firstName       | <firstName>      |
      | lastName        | <lastName>       |
      | password        | <password>       |
      | confirmPassword | <confirmPassword> |
    And I click the Register button
    Then I should see the success message "<successMessage>"

    Examples:
      | username      | firstName | lastName | password  | confirmPassword | successMessage              |
      | testuse023   | John      | Doe      | Test@1234 | Test@1234       | Registration is successful  |

  Scenario Outline: Registration with invalid details
    Given I am on the registration page
    When I fill in the registration form with the following details:
      | username        | <username>       |
      | firstName       | <firstName>      |
      | lastName        | <lastName>       |
      | password        | <password>       |
      | confirmPassword | <confirmPassword> |
    And I click the Register button
    Then I should see the error message "<errorMessage>"

    Examples:
      | username        | firstName | lastName | password  | confirmPassword | errorMessage                  |
      | testuser016     | Jane      | Doe      | Test@1234 | Test@1234       | UsernameExistsException: User already exists |
      | testuser003     | John      | Smith    | Test@1234 | Pass@5678       | Passwords do not match         |