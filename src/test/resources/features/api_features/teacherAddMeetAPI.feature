@teacher @api19 @apiRegression
  Feature: Teacher Add Meet Api

    Background:
      Given UserNhl sets the url
    @api19_TC01
    Scenario: TC01_Meet_PostRequest
      When UserNhl sends post request
      And UserNhl verifys that the status code is 200
      Then UserNhl asserts response body

    @api19_TC02
    Scenario: TC02_Meet_PostRequest(Past_Date)
    When UserNhl sends a post request for a past date
      And UserNhl verifys that the status code is 400

    @api19_TC03
    Scenario: TC03_Meet_PostRequest(Empty_Date)
      When UserNhl sends a post request leaving the date field blank
      And UserNhl verifys that the status code is 400

    @api19_TC04
    Scenario: TC04_Meet_PostRequest(Empty_StartTime)
      When UserNhl sends a post request leaving the StartTime field blank
      And UserNhl verifys that the status code is 400

    @api19_TC05
    Scenario: TC05_Meet_PostRequest(Empty_StopTime)
      When UserNhl sends a post request leaving the StopTime field blank
      And UserNhl verifys that the status code is 400

    @api19_TC06
    Scenario: TC06_Meet_PostRequest(Empty_Description)
      When UserNhl sends a post request leaving the Description field blank
      And UserNhl verifys that the status code is 400

    @api19_TC07
    Scenario: TC07_Meet_PostRequest(Same_Day_And_Hour)
      When UserNhl sends post request on the same day and time
      And UserNhl verifys that the status code is 409