Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - Wealth Management"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "mihir"
And user enters password "Test@987"
And user clicks on Login button
Then user gets the title of the Index page
And Index page title should be "Index - Wealth Management"