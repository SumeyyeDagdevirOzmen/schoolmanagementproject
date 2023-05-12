@DB25 @DBRegression
Feature: StudentCreate
  Scenario: DB Student Create_Admin
    Given User25 connects to database
    When User25 Find student by id
    Then User25 validate the datas
