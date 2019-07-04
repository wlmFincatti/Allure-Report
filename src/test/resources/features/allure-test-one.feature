@AllureReportOne
Feature: anotherFeature

  Background:
    Given I have two numbers 9 and 3

  @severity=trivial
  Scenario: sum two numbers and validation result
    When I wish sum
    Then I expect result 12

  @severity=minor
  Scenario: subtract two numbers and validation result
    When I wish subtract
    Then I expect result 7

  @severity=critical
  Scenario: multiple two numbers and validation result
    When I wish multiple
    Then I expect result 18

  @severity=normal
  Scenario: divide two numbers and validation result
    When I wish divide 1
    Then I expect result 4
