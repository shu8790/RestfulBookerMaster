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

Feature: Validating Booking APIs

  
  Scenario: verify if user is able to successfully do booking using Create Booking API
    Given create booking Payload with firstname, lastname and bookingdates
    When user calls "CreateBookingAPI" API with "post" method 
    Then API call is successfull with status code and staus
    
  Scenario: verify that user can successfully fetch the booking details using GetBookingAPI
  	Given get the booking id of created booking
  	When user calls "GetBookingAPI" api with "get" method
  	Then Api call is successfull with status code and status
  	
 Scenario: verify that user can successfully upadate the existing booking details
 
 Given create the autorisation token
 And create the payload for the update API
 When user calls "UpdateBookingAPI" Api with "put" method
 Then Api call is successfull with status code 200 and status ok
 
  	

  
   # Scenario Outline: Title of your scenario outline
   # Given I want to write a step with <name>
   # When I check for the <value> in step
   # Then I verify the <status> in step

 #   Examples: 
 #     | name  | value | status  |
 #     | name1 |     5 | success |
 #     | name2 |     7 | Fail    |
