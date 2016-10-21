#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@example2

Feature: Example2 feature
	I want to use this example to show how behavior-driven development tests work.

@donotsmoke
Scenario: Clicking the first element in the list
Given the page has a link with text 'A/B Testing'
When I click on the link with text 'A/B Testing'
Then I should see a header with 'A/B Test Variation 1'

@donotsmoke
Scenario: Returning to the main page
Given the page with a header 'A/B Test Variation 1'
When I click the browser back button
Then I should see a header with 'Welcome to the Internet'

@donotsmoke
Scenario: Clicking the first element in the list
Given the page has a link with text 'A/B Testing'
When I click on the link with text 'A/B Testing'
Then I should see a header with 'A/B Test Variation 1'