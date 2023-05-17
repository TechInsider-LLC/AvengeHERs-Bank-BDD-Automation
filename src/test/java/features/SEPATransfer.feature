@regression
Feature:  SEPA Transfer

  Scenario:  SEPA transfer
    Given Customer has test data for "SEPA Transfer"
    When Customer transfers SEPA money
    Then SEPA transfer should successfully