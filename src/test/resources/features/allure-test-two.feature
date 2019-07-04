@AllureReportTwo
Feature: SomeFeature

  Background:
    Given I have two numbers 8 and 2

  @severity=trivial
  Scenario: sum two numbers and validation result
    When I wish sum
    Then I expect result 10

  @severity=minor
  Scenario: subtract two numbers and validation result
    When I wish subtract
    Then I expect result 6

  @issue=TUDO-6803
  @severity=critical
  Scenario: multiple two numbers and validation result
    When I wish multiple
    Then I expect result 18

  @severity=normal
  Scenario: divide two numbers and validation result
    When I wish divide
    Then I expect result 4
