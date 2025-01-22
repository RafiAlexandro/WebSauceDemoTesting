@Login
  Feature: Login

    @Positive
    Scenario: Login Success
      Given User open sauce demo url
      When User input username "standard_user" and password "secret_sauce"
      And User click login button
      Then Login successful