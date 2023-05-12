@DB22 @DBRegression
  Feature: AdminCreate
    Scenario: DB Admin Create
      Given User22 connects to database
      When User22 Find admin by id
      Then User22 validate the datas
