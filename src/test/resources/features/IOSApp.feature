Feature: IOS App Execution
Verify if user is able to launch iphone simulator

  Scenario: Able to launch iphone XS simulator
    Given I am on the Alert Views Screen
     When I try to save short title
     Then I am able to see my short title saved
