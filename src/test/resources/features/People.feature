
Feature: Work with people
  Scenario:
    Given I am on the page of people
    When I do request on the server
    Then I see list of people on my team
