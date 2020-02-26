Feature: As an Employer validate the Employee Admin page

@smoketest
Scenario: S0 Check website loads
# given an Employer - no need/way to test
Given S0 I am on the Benefits Dashboard page
Then S0 The page should be loaded



@smoketest @regressiontest @paylocitytest
Scenario: S1 Add Employee no Discount
# given an Employer - no need/way to test
Given S1 I am on the Benefits Dashboard page
When S1 I select Add Employee
Then S1 I should be able to enter employee details
And S1 the employee should save
And S1 I should see the employee in the table

And S1 First Name does not begin with “A” or “a”
And S1 the benefit cost calculations are correct



@regressiontest
Scenario: S2 Add Employee with Discount
# given an Employer - no need/way to ttest
Given S2 I am on the Benefits Dashboard page
When S2 I select Add Employee
Then S2 I should be able to enter employee details
And S2 the employee should save
And S2 I should see the employee in the table

And S2 First Name begins with “A” or “a”
And S2 the employee has a 10% discount
And S2 the benefit cost calculations are correct



@regressiontest
Scenario: S3 Edit Employee
# given an Employer - no need/way to test
Given S3 I am on the Benefits Dashboard page
When S3 I select the Action Edit
Then S3 I can edit employee details
And S3 the data should change in the table



@regressiontest
Scenario: S4 Delete Employee
# given an Employer - no need/way to test
Given S4 I am on the Benefits Dashboard page
When S4 I click the Action X
Then S4 the employee should be deleted
