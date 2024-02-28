
  @tag
    Feature: Purchase the order from ecommerce website
      I want to purchase Zara coat and adidas shoes from the ecommerce website

      Background:
        Given I landed on ecommerce page

    @tag2
    Scenario Outline: Positive test of submitting the order
      Given I logged in with username <name> and password <password>
      When i add the product <productName> to Cart
      And Checkout <productName> and submit the order
      Then Verify "THANKYOU FOR THE ORDER." message is displayed on confirmation page.
      Examples:
        | name                      | password | productName |
        | clt3rodp8v@superblohey.com| Aa@123456| ZARA COAT 3 |