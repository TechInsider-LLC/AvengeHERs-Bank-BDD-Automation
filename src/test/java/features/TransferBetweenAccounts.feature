Feature: Transfer Between Accounts

  Scenario: User Transfers between accounts
    Given Customer has test data for "Transfer Between Account"
    When User transfers between accounts
    Then User have to transfer successfully