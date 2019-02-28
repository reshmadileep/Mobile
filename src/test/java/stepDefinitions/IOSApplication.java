package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IOSApplication {

    @When("I try to run the mobile automation")
    public void I_try_to_run_the_mobile_automation(){
        System.out.println("in When");
    }

    @Then("I am able to see the iphone XR simulator")
    public void I_am_able_to_see_the_iphone_XR_simulator(){
        System.out.println("in Then");
    }
}
