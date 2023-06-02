  @regression
Feature: Outgoing Wire Transfer

  Scenario: Outgoing Wire Transfer
    Given Customer has test data for "Outgoing Wire Transfer"
    When User initiates an outgoing wire transfer
    Then Customer should be successfully outgoing wire transfer
    When Agent approves the transaction



