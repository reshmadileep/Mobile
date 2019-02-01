package stepDefinitions;

//import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.AssignLeave;
import pages.HomePage;

public class Leave {
	private World world;
	public AndroidDriver<AndroidElement> driver;
	private AssignLeave assignLeavePage;
	public HomePage homePage;
	
	@SuppressWarnings("unchecked")
	public Leave(World world) {
		this.world = world;
		driver = (AndroidDriver) this.world.context.get("driver");
		assignLeavePage = new AssignLeave(driver);
	}

	@Given("User is on assign leave page")
	public void Navigate_to_assign_leave_page() {
		
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
		homePage=new HomePage(driver);
		homePage.enterUsername("Admin");
		homePage.enterPassword("admin123");
		homePage.clickLoginBtn();
		
	//	assignLeavePage.clickLeave();
		assignLeavePage.scrollPageDown();
		assignLeavePage.clickAssignLeave();
	}

	@When("User Applies leave with details {string},{string},{string},{string},{string}")
	public void Apply_leave_with_details(String employeeName, String selection, String fromDate, String toDate,
			String comment) {
		assignLeavePage.enterEmployeeName(employeeName);
		assignLeavePage.selectLeaveType(selection);
		assignLeavePage.enterFromDate(fromDate);
		// assignLeavePage.enterToDate(toDate);
		assignLeavePage.enterComment(comment);
		assignLeavePage.applyLeave();
		assignLeavePage.balancepopup();
		assignLeavePage.overlapleave();

	}

	@Then("Verify a record is added to the leave list for {string},{string},{string}")
	public void A_record_is_added_to_the_leave_list(String employeeName, String FromleaveDate, String ToleaveDate)
			throws InterruptedException {
		assignLeavePage.scrollPageDown();
		assignLeavePage.clickLeaveList();
		assignLeavePage.enterLeaveListFromDate(FromleaveDate);
		assignLeavePage.enterLeaveListToDate(ToleaveDate);
		assignLeavePage.enterEmployeeNameLeaveList(employeeName);
		assignLeavePage.checkCheckbox();
		assignLeavePage.clickCheckLeaveSubmit();
		assignLeavePage.verifyRecords(employeeName, FromleaveDate);
	}
}
