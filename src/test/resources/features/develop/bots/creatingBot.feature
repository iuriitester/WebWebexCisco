Feature: Creating Bot

  Scenario Outline: We are creating Bot in *app'<app>' by *userName'<userName>'
  Given I am going to <app>
    When I LogIn as <userName>
    Then I get Welcome Page
    Examples:
      | app |userName|
    |develop|iurii.kiselev|

