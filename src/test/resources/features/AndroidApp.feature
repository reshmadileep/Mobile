Feature: Wifi Setting Feature
Verify if user is able to apply wifi settings

  Scenario: Able to apply wifi setting
    Given I am on the WIFI settings screen
     When I try to update the WIFI settings
     Then I am able to save it succesfully
     
  Scenario: Able to tap and longpress
    Given I am on the Custom Adapter screen
     When I try to longpress the people name
     Then I am able to see the options
  
  Scenario: Able to scroll and navigate to hello world
   Given I am on the View screen
   When I try to open the WebView screen
   Then I am able to see the text on the page