@ProductsCart
  Feature: Products - Cart

    @Positive
    Scenario: Add Product To Cart
      Given User already login
      When User click add to cart
      Then User direct to cart page and product displayed in cart

    @Positive
    Scenario: Remove Product From Inventory Page
      Given User already login
      When User click add to cart
      And User click remove
      And User click cart icon
      And User direct to cart page
      Then Product removed from cart

    @Positive
    Scenario: Remove Product From Cart Page
      Given User already login
      When User click add to cart
      And User click cart icon
      And User direct to cart page
      And User click remove
      Then Product removed from cart

    @Positive
    Scenario: Add More Product
      Given User already login
      When User click add to cart
      And User click cart icon
      And User direct to cart page
      When User continue shopping
      And User add more product
      And User click cart icon
      And User direct to cart page
      Then Other product added in cart

    @Positive
    Scenario: Add Product From Product Detail Page
      Given User already login
      When User select product
      And User direct to product detail page
      When User click add to cart
      And User click cart icon
      And User direct to cart page
      Then Product added in cart

    @Positive
    Scenario: Remove Product From Product Detail Page
      Given User already login
      When User select product
      And User direct to product detail page
      And User click add to cart
      When User click remove from product detail
      And User click cart icon
      And User direct to cart page
      Then Product removed from cart