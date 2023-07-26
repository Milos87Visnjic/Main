Feature: Users should be able to login

  @login @smoke
  Scenario: Authenticated users should be able to login
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible

  @loginPopUpMessages @smoke
  Scenario Outline:Ability to view login popup message
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User tries to log in "<email>" and "<Password>"
    Then According to "<email>" and "<Password>" condition User verifies the popup "<message>"and "<promptMessage>"
    And User verifies that LogIn button is not clicked

    Examples:
      | email                      | Password   | message               | promptMessage                                                         |
      |                            | 654321\"qW | Required              |                                                                       |
      | testerqatester@yopmail.com |            | Required              |                                                                       |
      |                            |            | Required              |                                                                       |
      | name                       | 654321\"qW | Invalid email address | Please include an '@' in the email address. 'name' is missing an '@'. |
      | name@name@name             | 654321\"qW | Invalid email address | A part following '@' should not contain the symbol '@'.               |
      | @....com                   | 654321\"qW | Invalid email address | Please enter a part followed by '@'. '@....com' is incomplete.        |
      | aaa@....com                | 654321\"qW | Invalid email address | '.' is used at a wrong position in '....com'.                         |

  @fbJoin @smoke
  Scenario: Ability to join with FaceBook
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User clicks on join button
    And User clicks on FB button
    And User login FB with "qatestester1001@gmail.com" and "654321\"qW"
   # And User clicks on continue button
   # And User accepts age question
    #And User accepts termsAndConditions
    Then User verifies initials
    And User clicks on initials
    And User clicks on Player Account button
    When User clicks on log out button
    Then User verifies login button is visible
    When User clicks back button
    Then User verifies login button is visible
    And User clicks on join button
    And User clicks on Google button
    When User login Google with "qatestester1001@gmail.com" and "654321\"qW"
    Then User verifies that "Account Cannot be Created" message is showed up
    And User refresh
    When User joins "qatestester1001@gmail.com" and "654321\"qW"
    Then User verifies that "Account Cannot be Created" message is showed up


  @fbLogin
  Scenario: Ability to login with FaceBook
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User clicks on login button
    And User clicks on FB button
    And User login FB with "qatestester1001@gmail.com" and "654321\"qW"
    #And User accepts age question
    Then User clicks on initials


  @googleJoin
  Scenario:Ability to Join with Google
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User clicks on join button
    And User clicks on Google button
    And User login Google with "qatestester1002@gmail.com" and "654321\"qW"
    And User accepts age question
    And User accepts termsAndConditions
    Then User verifies initials


  @joinWithEmailAccount @smoke
  Scenario: Ability to join with an email account
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And User Joins Avantage Games page with new email account
    And User verifies that verification mail sent page is opened
    And User navigates to mailseven page inbox
    And User enters username into inbox input
    And User clicks hyperlink send by Avantage
    And User enters password in Avantage GamePortal
    When User accepts termsAndConditions
    Then User verifies initials
    And User clicks on avatar
    And User clicks on Player Account button
    When User clicks on log out button
    Then User verifies login button is visible
    When User clicks back button
    Then User verifies login button is visible
    When User Joins Avantage Games page with new email account
    Then User verifies The system shows "Account Exists" message


  @forgotPassword @smoke
  Scenario:Ability to use forgot password option
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User clicks on login button
    And User clicks on email button
    And User clicks on forgot password button
    And User enters email into forgot password email input
    And User verifies that email sent message is popped up
    And User opens new window
    And User navigates to mailseven page inbox
    And User enters "testertester856@mail7.i0" into inbox input
    And User clicks on forgot password mail
    And User gets digital codes
    And User navigates back to Avantage GamePortal
    And User enters digital code
    And User enters passwords
    Then User verifies initials


