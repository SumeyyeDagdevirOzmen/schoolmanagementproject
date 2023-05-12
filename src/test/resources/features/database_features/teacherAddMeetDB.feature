 @DB19 @DBRegression
  Feature: Teacher Add Meet DataBase
    Scenario: Olusan toplantiyi MeetID ile sorgulama
      Given User connects to database
      When UserNhl finds meet by MeetID
      Then UserNhl validates Data