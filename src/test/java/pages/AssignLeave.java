package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ReusableFunctions;

public class AssignLeave {

	@FindBy(xpath = "//li[text()]")
	private WebElement checkDashboard;

	@FindBy(id = "menu_leave_viewLeaveModule")
	private WebElement lnkLeave;

	@FindBy(xpath = "//*[text()='Assign Leave']")
	private WebElement lnkAssignLeave;

	@FindBy(id = "employee_value")
	private WebElement txtEmployeeName;

	@FindBy(id = "from")
	private WebElement txtFromDate;

	@FindBy(id = "to")
	private WebElement txtToDate;

	@FindBy(id = "menu_leave_assignLeave")
	private WebElement txtComment;

	@FindBy(id = "leaveType")
	private WebElement ddLeaveType;

	@FindBy(xpath = "//input[@id='assignBtn']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//a[@id='menu_leave_viewLeaveList']/span[contains(text(),'Leave List')]")
	private WebElement btnLeaveList;

	@FindBy(id = "selectedEmployee_value")
	private WebElement txtCheckLeaveEmployeeName;

	@FindBy(id = "from")
	private WebElement txtLeaveListFrom;

	@FindBy(id = "to")
	private WebElement txtLeaveListTo;

	@FindBy(xpath = "button[@type='submit']")
	private WebElement btnCheckLeaveSubmit;

	@FindBy(xpath = "//label[@for='scheduled']")
	private WebElement ckbxStatusScheduled;

	@FindBy(id = "statusAll")
	private WebElement ckbxStatusAll;

	@FindBy(xpath = "//td[text()]")
	private WebElement updateCheck;

	@FindBy(xpath = "//button[text()='Assign']")
	private WebElement btnAssignLeave;

	@FindBy(xpath = "//div[id='application_balance_modal']")
	private WebElement insufficientBalancepopup;

	@FindBy(xpath = "//a[@ng-click='modal.confirm()']")
	private WebElement popupOk;

	@FindBy(xpath = "//a[@ng-click='modal.cancel()']")
	private WebElement popupCancel;

	@FindBy(id = "selectedEmployee_value")
	private WebElement txtEmployeeNameLeaveList;

	private ReusableFunctions reusablefunctions;
	private WebDriver driver;

	public AssignLeave(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		reusablefunctions = new utils.ReusableFunctions(driver);
	}

	public AssignLeave checkDashboard() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(checkDashboard));
		checkDashboard.getText().contains("Dashboard");
		return this;
	}

	public AssignLeave clickLeave() {
		lnkLeave.click();
		return this;
	}

	public AssignLeave scrollPageDown() {
		reusablefunctions.scrolldown();

		return this;
	}

	public AssignLeave clickAssignLeave() {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(lnkAssignLeave));
		lnkAssignLeave.click();
		return this;
	}

	public AssignLeave enterEmployeeName(String employeeName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(txtEmployeeName));
		txtEmployeeName.sendKeys(employeeName);
		return this;
	}

	public AssignLeave selectLeaveType(String selection) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".select-wrapper input")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By
				.xpath("//div[contains(@class,'select-wrapper')]/ul/li/span[contains(text(),'" + selection + "')]"))));
		driver.findElement(
				By.xpath("//div[contains(@class,'select-wrapper')]/ul/li/span[contains(text(),'" + selection + "')]"))
				.click();
		return this;
	}

	public AssignLeave enterFromDate(String fromDate) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(txtFromDate));
		txtFromDate.sendKeys(fromDate);
		return this;
	}

	public AssignLeave enterToDate(String toDate) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(txtToDate));
		txtToDate.clear();
		txtToDate.click();
		txtToDate.sendKeys(toDate);
		return this;
	}

	public AssignLeave enterComment(String comment) {
		txtComment.sendKeys(comment);
		return this;
	}

	public AssignLeave applyLeave() {
		btnAssignLeave.click();
		return this;
	}

	public AssignLeave balancepopup() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(popupOk));
		try {
			if (popupOk.isDisplayed()) {
				popupOk.click();
			}

		} catch (Exception e) {

		} finally {

		}
		return this;
	}

	
	
	public AssignLeave overlapleave() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(popupCancel));
		try {
			if (popupCancel.isDisplayed()) {
				popupCancel.click();
			}

		} catch (Exception e) {

		} finally {

		}
		return this;
	}

	public AssignLeave clickLeaveSubmit() {
		btnSubmit.click();
		return this;
	}

	public AssignLeave clickLeaveList() {
		try {
			Thread.sleep(2000);
		} catch (Exception ex) {
		}
		btnLeaveList.click();
		return this;
	}

	public AssignLeave enterLeaveListFromDate(String FromleaveDate) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(txtLeaveListFrom));
		txtLeaveListFrom.clear();
		txtLeaveListFrom.sendKeys(FromleaveDate);
		return this;
	}

	public AssignLeave enterLeaveListToDate(String ToleaveDate) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(txtLeaveListTo));
		txtLeaveListTo.clear();
		txtLeaveListTo.sendKeys(ToleaveDate);
		return this;
	}

	public AssignLeave enterEmployeeNameLeaveList(String employeeName) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(txtEmployeeNameLeaveList));
		txtEmployeeNameLeaveList.sendKeys(employeeName);
		return this;
	}

	public AssignLeave checkCheckbox() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ckbxStatusScheduled));
		ckbxStatusScheduled.click();
		return this;
	}

	public AssignLeave clickCheckLeaveSubmit() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(btnLeaveList));

		btnLeaveList.click();
		return this;
	}

	public void verifyRecords(String employeeName, String date) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(updateCheck));
		
		if ((updateCheck.getText().contains(employeeName))
				&& (updateCheck.getText().toString().contains(date)))
			System.out.println("Employee Leave has been updated");
		else
			System.out.println("Employee Leave has not been updated");
	}

}
