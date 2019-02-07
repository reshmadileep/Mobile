Feature: Assign Leave Feature
    Verify if user is able to assign leave

  	@adminUserLoggedIn
    Scenario Outline: Able to assign leave
        Given User is on assign leave page
        When User Applies leave with details "<Employee Name>","<Leave Type>","<From Date>","<To Date>","<Comments>"
        Then Verify a record is added to the leave list for "<Employee Name>","<From Date>","<To Date>"

        Examples:
            | Employee Name | Leave Type                    | From Date     | To Date       | Comments  |
            | Amadi Aswad   | Family responsibility leave   | 2019-02-03   | 2019-02-03   | Sick      |