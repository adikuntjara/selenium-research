Feature: Login

  Scenario: User can login Sauce Labs Demo website using standard_user
    Given the user is on the Sauce Labs Demo website
    When the user is login as a standard_user
    Then the user will successfully login