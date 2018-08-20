#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase a Item
  This feature allows user to purchase an iPAD from Apple.com

  @tag1
  Scenario: Apple.com site is coming up 
    Given I launch a browser
    And I open apple.com page
    When I open apple.com
    Then I validate the response
    And The title of the page is Apple
    And The iPad is available on the site.

  @tag2
  Scenario: Add iPad with option to cart
    Given I am on the Apple Page 
    And I see <item> on the screen
    And I click Buy for <item> on the page
    And I select the <finish> of the <item>
    And I select the <storage>  for the <item>
    And I Select the <connectivity> for the <item>
    And I add the <option> for the <item>
    And I click continue on the item details page for the <item> in step
    When I click Review Bag on the confirmation in step
    Then I verify the <item> with <finish> and <connectivity> with <option> is on the cart
    And I verify the <price> is as expected.
    
    #Examples: 
      | item  | finish | storage  | connectivity | option | price |
      | ipad_9_7 | silver | 32gb | Wi-Fi+Cellular | AppleCare+ | 459.00 |
      
	 @tag3
	 Scenario: Purchase Item in cart
	 Given I have added the item in cart.
	 And I click continue on the cart.
	 And I Click Guest Checkout
	 And I select I will pick it up.
	 And I select the first store in the Option.
	 And I click Continue to Pickup details.
	 And I enter <FirstName>, <LastName>, <EmailAddress> and <PhoneNumber>
	 Then I go to Payment Page
	 And I verify the Payment Page screen
	
	 #Examples: 
      | FirstName  | LastName | EmailAddress  | PhoneNumber | PaymentType |
      | Prasad | Kale | prasad.kale@entmobi.com | Wi-Fi+Cellular | CreditCard |
	 
	 @tag4
	 Scenario: I purchase using credit card
	 Given Purchase Item in Cart.
	 And <PaymentType> selected is credit card.
	 And I enter the <CreditCardNumber>, <CreditCardExpiry> and <Cvv>
	 And I enter the <Billing.FirstName>, <Billing.LastName>, <Billing.StreetAddress>, <Billing.AddressLine2> and <Billing.Zip>
	 When I click Review your Order.
	 Then I verify i got an Credit Card Error.
	 And The screen does not move forward.  
	 
 	 #Examples: 
    | PaymentType | Billing.FirstName |Billing.LastName | Billing.StreetAddress  | Billing.AddressLine2 | Billing.Zip | CreditCardNumber | CredictCardExpiry| Cvv |
    | Credit | Prasat| Kale | 1 Infinite Loop |  | 10001 | 1234123412341234 | 10/22 | 123 |
 