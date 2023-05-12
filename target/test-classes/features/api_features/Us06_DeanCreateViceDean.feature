@vice_dean_created_by_dean_api @admin
Feature: US06 Dean should be able to create vice dean account api

  @TC01_vice_dean_created_by_dean_api
  Scenario: Creating vice dean account by dean (api test)
    Given User yusuf sets the Url
    When user yusuf sends POST request and do the assertion for creating vice dean by dean

  @TC02_vice_dean_created_by_dean_api
  Scenario: Updating  vice dean account by dean (api test)
    Given User yusuf sets the Url
    And user yusuf sends PUT request and do the assertion for creating vice dean by dean

  @TC03_vice_dean_created_by_dean_api
  Scenario: Deleting vice dean account by dean (api test)
    Given User yusuf sets the Url
    And user yusuf sends DELETE request and do the assertion for creating vice dean by dean

  @TC04_vice_dean_created_by_dean_api
  Scenario: Getting vice dean account by dean (api test)
    Given User yusuf sets the Url
    And user yusuf sends GET request and do the assertion for creating vice dean by dean