@regression
Feature: Transfer Between Users

  Scenario: User transfers money to another User
    Given Customer has test data for "Transfer Between Users"
    When User transfers money
    Then Customer should be successfully transfers money