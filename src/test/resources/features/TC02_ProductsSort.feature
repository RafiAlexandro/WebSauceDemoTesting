@ProductsSort
  Feature: Products - Sort

    @Positive
    Scenario: Filter Name A To Z
      Given User already login
      When User click sort menu
      And User click filter name a to z
      Then Filter name a to z successful

    @Positive
    Scenario: Filter Name Z To A
      Given User already login
      When User click sort menu
      And User click filter name z to a
      Then Filter name z to a successful

    @Positive
    Scenario: Filter Price Low To High
      Given User already login
      When User click sort menu
      And User click filter price low to high
      Then Filter price low to high successful

    @Positive
    Scenario: Filter Price High To Low
      Given User already login
      When User click sort menu
      And User click filter price high to low
      Then Filter price high to low successful