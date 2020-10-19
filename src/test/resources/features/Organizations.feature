@smoke @add_organization @org-001
Feature: Add organization

  Scenario: add new organization using api organization
    Given organization is not created
    When I create a new organization
    Then I have new organization



  Scenario: delete organization
    Given The API has this organization
    When I delete this organization
    Then The API has not this organization


