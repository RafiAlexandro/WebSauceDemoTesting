@CheckoutInformation
  Feature: Checkout - Information

    @Positive
    Scenario: Checkout Product
      Given User already login
      When User click add to cart
      And User click cart icon
      And User click checkout
      Then User direct to checkout info page
      When User input first name "First" and last name "Last" and postal code "123"
      And User click continue
      Then User direct to checkout overview page and product displayed
      When User click finish
      Then User direct to checkout complete page

    @Negative
    Scenario: Checkout With No Product
      Given User already login
      When User click cart icon
      And User click checkout
      Then User cannot direct to checkout info page

    @Negative
    Scenario: Input Checkout Information With Null Data
      Given User already login
      When User click add to cart
      And User click cart icon
      And User click checkout
      Then User direct to checkout info page
      And User click continue
      Then User get error message first name required

    @Negative
    Scenario Outline: Input Checkout Information With Null First Name
      Given User already login
      When User click add to cart
      And User click cart icon
      And User click checkout
      Then User direct to checkout info page
      When User input first name "<firstname>" and last name "<lastname>" and postal code "<postcode>"
      And User click continue
      Then User get error message first name required

      Examples:
      |firstname|lastname|postcode|
      ||Last|123|

    @Negative
    Scenario Outline: Input Checkout Information With Null Last Name
      Given User already login
      When User click add to cart
      And User click cart icon
      And User click checkout
      Then User direct to checkout info page
      When User input first name "<firstname>" and last name "<lastname>" and postal code "<postcode>"
      And User click continue
      Then User get error message last name required

      Examples:
        |firstname|lastname|postcode|
        |First||123|

    @Negative
    Scenario Outline: Input Checkout Information With Null Postal Code
      Given User already login
      When User click add to cart
      And User click cart icon
      And User click checkout
      Then User direct to checkout info page
      When User input first name "<firstname>" and last name "<lastname>" and postal code "<postcode>"
      And User click continue
      Then User get error message postal code required

      Examples:
        |firstname|lastname|postcode|
        |First|Last||

    @Negative
    Scenario Outline: Input Checkout Information Postal Code With Alphabet
      Given User already login
      When User click add to cart
      And User click cart icon
      And User click checkout
      Then User direct to checkout info page
      When User input first name "<firstname>" and last name "<lastname>" and postal code "<postcode>"
      And User click continue
      Then User get error message postal code must be number

      Examples:
        |firstname|lastname|postcode|
        |First|Last|ABC|

    @Positive
    Scenario: Cancel Checkout From Checkout Information
      Given User already login
      When User click add to cart
      And User click cart icon
      And User click checkout
      Then User direct to checkout info page
      When User click cancel
      Then Cancel checkout success and direct to cart page

    @Positive
    Scenario: Cancel Checkout From Checkout Overview
      Given User already login
      When User click add to cart
      And User click cart icon
      And User click checkout
      Then User direct to checkout info page
      When User input first name "First" and last name "Last" and postal code "123"
      And User click continue
      Then User direct to checkout overview page and product displayed
      When User click cancel
      Then Cancel checkout success and direct to cart page



