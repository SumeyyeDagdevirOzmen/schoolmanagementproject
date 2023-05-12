@DB_US13 @DBRegression
  Feature: ViceDean_Add_Teacher_Validation

    Scenario:TC029_Validate Vice_DeanS_Create_Teacher_Database
      Given ViceDeanS connects to database
      When ViceDeansS finds teacher by ID
      Then ViceDeanS validates data