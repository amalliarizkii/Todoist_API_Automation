Feature: Get Project


  @fauzan @negative_case
   Scenario Outline: Get Project without authorization
     Given Get project with valid id without auth "<id>"
     When Send request get project
     Then Should return 401 Unauthorized
     Examples:
     |id|
     |2299972865|
     |2299972881|


  @fauzan @positive_case
  Scenario Outline: Get project with valid id
    Given Get project with valid id "<id>"
    When Send request get project
    Then Should return 200 OK
    And Get project json schema validator
    Examples:
      |id|
      |2299972865|
      |2299972881|


  @fauzan @negative_case
    Scenario Outline: Get Project with invalid id
      Given Get project with invalid id "<id>"
      When Send request get project
      Then Should return 404 Not Found
      Examples:
        |id|
        |!@#@%|
        |wakwaw|
        |cihuyy|


  @fauzan @negative_case
    Scenario Outline: Get Project with unexisting id
      Given Get project with unexisting id "<id>"
      When Send request get project
      Then Should return 404 Not Found
      Examples:
      |id|
      |1989|
      |2045|


  @fauzan @negative_case
     Scenario Outline: Get Project with invalid parameter
       Given Get project with valid id "<id>"
       When Send request get project with invalid parameter
       Then Should return 404 Not Found
       Examples:
       |id|
       |2299972865|
       |2299972881|
