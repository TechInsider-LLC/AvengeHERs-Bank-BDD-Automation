@regression @smoke @login
Feature: Log In

  Scenario: Log In
    Given Customer has test data for "login" in MongoDB
    When Customer logs in
    Then Customer should be successfully logged in

