Feature: Login 

@smoke
Scenario: Successful Login with Valid Credentials
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	And Click on Logout
	Then Page Title should be "Your Store. Login"
	And Close browser

@regression
Scenario Outline: Successful Login Data Driven
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	Then Verify pagesource contains "John Smith"
	And Click on Logout
	Then Page Title should be "Your Store. Login"
	And Close browser
	
	Examples:
		| email | password | 
		| admin@yourstore.com | admin |
		| admin1@yourstore.com | admin123 |
		