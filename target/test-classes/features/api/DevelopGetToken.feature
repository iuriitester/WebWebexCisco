@test
Feature: Get API Token

  Scenario Outline: I take Token for it I need *app'<app>' and *userName'<userName>'
    Given I am checking Token to take Token
    And I am going to <app>
    When I LogIn as <userName>
    And I go to TokenPage
    And I take Token
    And I save it to the file
    And Push to the remote repository
    Examples:
      | app | userName |
      |develop|irina.kiseleva|