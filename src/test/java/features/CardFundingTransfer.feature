@regression

Feature: Card Funding Transfer
  Scenario: Card Funding Transfer
    Given Customer has test data for "Card Funding Transfer"
    When Customer initiates a transfer from one card to another
    Then Customer should be successfully Card Funding Transfer