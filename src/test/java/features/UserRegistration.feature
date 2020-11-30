Feature: User Registraion
  I want to check that the user can register in our website

  Scenario Outline: User Registartion
    Given User in the main page of website
    When I click in registartion Link
    And Enter  "<firstname>" , "<lastname>" , "<email>" , "<password>"
    Then The registration page displayed succssfully
    
    Examples:
 	 | firstname | lastname | email | password |
 	 | ahmed | mohamed | ahmegc@user.com | 12345678 |
 	 | Moataz | ahmed | tesvhk@newuser2.com | 87654321 |
