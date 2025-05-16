Feature: ParaBank Login

  Scenario: Successful login with valid credentials
    Given User is on the ParaBank login page
    When User enters valid username and password
    And clicks the login button
    Then User should be redirected to the account overview page

  Scenario: Unsuccessful login with invalid credentials
    Given User is on the ParaBank login page
    When User enters invalid username and password
    And clicks the login button
    Then User should see an error message

  Scenario: Transfer funds between accounts
    Given User is logged in to ParaBank
    When User navigates to Transfer Funds page
    And enters transfer amount and selects accounts
    And clicks the transfer button
    Then User should see a transfer confirmation message

  Scenario: User logs out successfully
    Given User is logged in to ParaBank
    When User clicks the logout link
    Then User should be redirected to the login page

  Scenario: User opens a new account successfully
    Given User is logged in to ParaBank
    When User navigates to Open New Account page
    And User selects account type "SAVINGS" and existing account
    And User clicks the open new account button
    Then A new account should be created and displayed

  Scenario: User logs out successfully
    Given User is logged in to ParaBank
    When User clicks the logout link
    Then User should be redirected to the login page
