Feature: Get API Token

  Scenario Outline: I take Token for it I need *app'<app>' and *userName'<userName>'
    Given I am checking Token to take Token
    And I am going to <app>
    When I LogIn as <userName>
    And I go to TokenPage
    And I take Token
    Examples:
      | app | userName |
      |develop|irina.kiseleva|