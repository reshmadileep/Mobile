Feature: Gesture Features
Verify if user is able to apply test Gestures

  Scenario: Able to tap and longpress
    Given I am on the Custom Adapter screen
     When I try to longpress the people name
     Then I am able to see the options
 