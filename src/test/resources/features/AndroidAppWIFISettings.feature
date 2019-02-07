Feature: Wifi Setting Feature
Verify if user is able to apply wifi settings

  Scenario: Able to apply wifi setting
    Given I am on the WIFI settings screen
     When I try to update the WIFI settings
     Then I am able to save it succesfully
 