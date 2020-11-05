Feature: logIn in Develop Application

  Scenario Outline: I Log in to *app'<app>' as *userName'<userName>'
      Given I am going to <app>
      When I LogIn as <userName>
      Then I get Welcome Page



    Examples:
      |app  |userName|
      |develop|irina.kiseleva|



