Feature: As an Employer validate the Employee Admin page

@smoketest
Scenario: 0 Check website loads
# given an Employer - no need/way to test
Given I am on the Benefits Dashboard page
Then The page should be loaded



@smoketest @regressiontest @paylocitytest
Scenario: 1 Add Employee no Discount
# given an Employer - no need/way to test
Given I am on the Benefits Dashboard page
When I select Add Employee
Then I should be able to enter employee details
And the employee should save
And I should see the employee in the table

And First Name does not begin with “A” or “a”
And the benefit cost calculations are correct



@regressiontest
Scenario: 2 Add Employee with Discount
# given an Employer - no need/way to ttest
Given I am on the Benefits Dashboard page
When I select Add Employee
Then I should be able to enter employee details
And the employee should save
And I should see the employee in the table

And First Name begins with “A” or “a”
And the employee has a 10% discount
And the benefit cost calculations are correct



@regressiontest
Scenario: 3 Edit Employee
# given an Employer - no need/way to test
Given I am on the Benefits Dashboard page
When I select the Action Edit
Then I can edit employee details
And the data should change in the table



@regressiontest
Scenario: 4 Delete Employee
# given an Employer - no need/way to test
Given I am on the Benefits Dashboard page
When I click the Action X
Then the employee should be deleted
