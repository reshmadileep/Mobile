Feature: Login Feature
    Verify if user is able to Login in to the site
    

    Scenario: Login with valid credentials
        Given I as a admin user navigate to Home page        
        When I try to login with username "Admin" and password "admin123"
        Then I am logged in successfully