Feature: Employee features
  Scenario: Get All employees
    When User sends a GET request to get Users
     Then the response should have "employee_firstname 24" user
