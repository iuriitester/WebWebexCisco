@smoke @add_organization @org-001
Feature: List of organization

  Scenario: add new organization using api organization
    Given organization is not created
    When I create a new organization
    Then I have new organization





