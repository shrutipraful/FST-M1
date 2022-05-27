#Author: your.email@your.domain.com
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
@jobboard_1
Feature: Title of your feature
  I want to use this template for my feature file

  @jbactivity_1
  Scenario: Create User
    Given open browser
    When user is on jobboard application login page
    And enter username and password
    And click on Users in left menu
    When  click on Add New button
    Then Fill the required UserDetails 
    And click add user
    Then verify the user is created
    And close browser
    
  @jbactivity_2
  Scenario: Search for a job
  Given Open the browser
  Then user is on jboard home page
  Then click on jobs page
  Then Search for Job using keyword textbox
  And Uncheck all job types except Full Time using xpath
  Then Find the job listing using xpath and click on job
  Then print the title of the job
  And click on Apply for job button
  And close browser 
      
  @jbactivity_3
 Scenario: Posting a job
  Given open the browser
  When user is on jobs page
  Then Goto postjobs page and login
  And user enters the job details
   |Cucumber_Tester| 
   |Banglore|
   |Requires person having 4yrs experience|
   |Alchemy|
  Then Click on Preview and then submit
  And Goto Jobs page
  Then Search for posted job
  And Verify the posted job
  And close browser
  

    
 