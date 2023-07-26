Feature:Ability to handle player account

  @user
  Scenario: Ability to validate userName
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And The user logs in
    And User clicks on avatar
    When User clicks on Player Account button
    Then User verifies player name
    When User clicks on Player Profile
    Then User verifies player name equals name in player profile page

  @logoutEmail
  Scenario:Ability to log out after login using any email
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User clicks on avatar
    And User clicks on Player Account button
    When User clicks on log out button
    Then User verifies login button is visible
    When User clicks back button
    Then User verifies login button is visible

  @fbLogout
  Scenario Outline:Ability to log out with FaceBook login
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User clicks on login button
    And User clicks on FB button
    And User login FB with "<email>" and "<password>"
    And User accepts age question
    Then User verifies that "<avatar>" is visible
    And User clicks on avatar
    And User clicks on Player Account button
    When User clicks on log out button
    Then User verifies login button is visible
    When User clicks back button
    Then User verifies login button is visible

    Examples:
      | email                     | password   | avatar   |
      | qatestester1001@gmail.com | 654321\"qW | initials |

  @googleLogOut
  Scenario Outline:Ability to LogOut with Google
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User clicks on login button
    And User clicks on Google button
    And User login Google with "<email>" and "<password>"
    And User accepts age question
   # And User accepts termsAndConditions
    Then User verifies that "<avatar>" is visible
    And User clicks on avatar
    And User clicks on Player Account button
    When User clicks on log out button
    Then User verifies login button is visible
    When User clicks back button
    Then User verifies login button is visible

    Examples:
      | email                     | password   | avatar   |
      | qatestester1001@gmail.com | 654321\"qW | initials |

  @changeAvatar @smoke
  Scenario: Ability to change profile Avatar
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User clicks on avatar
    And User clicks on Player Account button
    And User clicks on Player Profile
    And User clicks on avatar edit icon
    And User clicks on choose avatar button
    And User selects avatar
    When User clicks on close Icon
    Then the user views that avatar is visible
    And User verifies avatar is selected avatar

  @privacyPolicy @smoke
  Scenario: Ability to open Privacy Policy
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User clicks on avatar
    And User clicks on Player Account button
    And User clicks on settings button
    And User clicks on edit comm button
    When User clicks on privacy policy button in edit comm
    Then User verifies privacy policy is opened in new tab

  @viewNotifications @smoke
  Scenario: Ability to view Notifications
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User clicks on avatar
    When User click on notifications button
    Then User verifies that notifications are visible


  @editComm @smoke
  Scenario: Ability to Edit Communication
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User clicks on avatar
    And User clicks on Player Account button
    And User clicks on settings button
    And User clicks on edit comm button
    When User selects checkboxes of EditComm
    Then User validates phone number input and email input

  @contactUs @smoke
  Scenario: Ability to open Contact Us and submit the request
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User validates Contact Us menu





