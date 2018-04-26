Feature: NewTours Application LogIn Test

Scenario Outline: Validating LogIn Functionality

Given Open Firefox Browser and Navigate to NewTours Application
When User Enters Valid  "<UserName>" and "<Password>" and Click on SignIn button
Then User Should be able to succesfully LogIn and close the application

Examples:
|  UserName  |  Password  |
|  tutorial  |  tutorial  |
|  tutorial  |  tutorial  |
|  tutorial  |  tutorial  |



