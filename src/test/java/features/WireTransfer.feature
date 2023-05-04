Feature: Wire Transfer

  Scenario: Positive
    Given Customer has test data for "Wire Transfer"
    When Customer wire transfers money
    Then Wire transfer should success