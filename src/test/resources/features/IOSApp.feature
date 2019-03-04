Feature: IOS App Execution
Verify if user is able to launch iphone simulator

  Scenario: Able to launch iphone XS simulator
    Given I am a User
     When I try to run the mobile automation
     Then I am able to see the iphone XR simulator
