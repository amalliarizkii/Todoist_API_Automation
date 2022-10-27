Feature: Post Create Project


  @fauzan @negative_case
  Scenario: Post create project without authorization
    Given Post create new project without auth
    When Send request post create new project
    Then Should return 401 Unauthorized


  @fauzan @positive_case
  Scenario: Post create project with valid body
    Given Post create new project
    When Send request post create new project
    Then Should return 200 OK
    And Body response should contain "tan" and 33
    And Post create new project json schema validator


  @fauzan @negative_case
  Scenario: Post create project with invalid body
    Given Post create new invalid project
    When Send request post create new project
    Then Should return 400 Bad Request


  @fauzan @negative_case
  Scenario: Post create project with no body
    Given Post create new project without body
    When Send request post create new project
    Then Should return 400 Bad Request


  @fauzan @negative_case
  Scenario: Post create project with invalid parameter
    Given Post create new project
    When Send request post create new project invalid param
    Then Should return 404 Not Found