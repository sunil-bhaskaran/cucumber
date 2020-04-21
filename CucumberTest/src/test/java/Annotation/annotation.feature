Feature: annotation 
#This is how background can be used to eliminate duplicate steps 

Background:
   Given I navigate to the login page

 #Scenario with AND 
Scenario: 
   When I enter username as "TOM"
   When I enter password as "JERRY" 
   Then Login should fail as per test case.


   