@ProductsMenu
  Feature: Products - Menu

    @Positive
    Scenario: Direct To All Items Page
      Given User already login
      When User click hamburger menu button
      And User click all items
      Then User direct to all items page

    @Positive
    Scenario: Direct To About Page
      Given User already login
      When User click hamburger menu button
      And User click about
      Then User direct to about page

    @Positive
    Scenario: Reset App State
      Given User already login
      When User click hamburger menu button
      And User click reset app state
      Then Reset app state successful