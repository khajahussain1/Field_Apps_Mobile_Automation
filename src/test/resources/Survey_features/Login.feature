Feature: login to the Android app in the field app

#  @android
#  Scenario: android login to the application
#    Given login to the android application with valid credentials
#
#  @ios
#  Scenario: ios login to the application
#    Given login to the ios application with valid credentials

#  @android
#  Scenario: Valid user can log in
#    Given the mobile app is launched
#    When I enter username "standard_user"
#    And I enter password "secret_sauce"
#    And I submit the login form
#    #Then the home screen should be displayed

  @ios
  Scenario: Valid user can log in
    Given the mobile app is launched
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I submit the login form
    #Then the home screen should be displayed
