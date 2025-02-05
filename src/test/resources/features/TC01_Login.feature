@Login
  Feature: Login

    @Positive
    Scenario: Login Success
      Given User open sauce demo url
      When User input username "standard_user" and password "secret_sauce"
      And User click login button
      Then Login successful

    @Negative
    Scenario Outline: Login With Null Data
      Given User open sauce demo url
      When User input username "<username>" and password "<password>"
      And User click login button
      Then Login failed with null data
      Examples:
      |username|password|
      |||

    @Negative
    Scenario Outline: Login With Null Username
      Given User open sauce demo url
      When User input username "<username>" and password "<password>"
      And User click login button
      Then Login failed with null username
      Examples:
        |username|password|
        ||secret_sauce|

    @Negative
    Scenario Outline: Login With Null Password
      Given User open sauce demo url
      When User input username "<username>" and password "<password>"
      And User click login button
      Then Login failed with null password
      Examples:
        |username|password|
        |standard_user||

    @Negative
    Scenario Outline: Login With Wrong Username
      Given User open sauce demo url
      When User input username "<username>" and password "<password>"
      And User click login button
      Then Login failed with wrong username
      Examples:
        |username|password|
        |admin|secret_sauce|

    @Negative
    Scenario Outline: Login With Wrong Password
      Given User open sauce demo url
      When User input username "<username>" and password "<password>"
      And User click login button
      Then Login failed with wrong password
      Examples:
        |username|password|
        |standard_user|123|