@regression
Feature: Transfer Between Users

  Scenario: User transfers money to another User
    When User transfers money
    Then Customer should be successfully transfers money