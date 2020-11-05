Feature: LogIn to Admin Application
# for developers
# POJO Scenario (POJOScenario.class) will be created automatically if
# It will be contains the name attributes as string between symbols "*" and "-" also its value between symbols "'"

  Scenario Outline: Scenario *scenario'authorize' attributes *userName'<userName>' *app'<app>'
    Given I am going to <app>
#    When I am authorizing as <user> in <app>
#    Then I get something

    Examples:
    |app|userName|
    |admin|irina.kiseleva|
    |admin|kiseira |
