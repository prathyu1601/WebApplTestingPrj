Feature: Orange Hrm Application LogIn Test

Scenario: Validating LogIn functionality

Given Open Firefox browser
And Navigate to Orange Hrm Application
When user enters valid UserName and Password
And Click on SignIn button
Then User should be able to succesfully login
And close the application