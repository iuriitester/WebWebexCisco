Feature: LogIn to Admin Application

  Scenario Outline: testing for *<user>
    Given I am going to <app>
#    When I am authorizing as <user> in <app>
#    Then I get something

    Examples:
    |app|user|
    |admin|irina.kiseleva|
