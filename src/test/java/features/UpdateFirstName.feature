@regression

  Feature: Update First Name
    Scenario: Update First Name
      Given Customer has test data for " Update First Name "
      When Customer changes First Name
      Then First Name should be updated successfully