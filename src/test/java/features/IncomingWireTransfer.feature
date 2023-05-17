@ regression

  Feature: Incoming Wire Transfer
    Scenario: Incoming Wire Transfer
      Given Customer has test data for "Incoming Wire Transfer"
      When Customer initiates an Incoming Wire Transfer
      Then Customer should be successfully Incoming Wire