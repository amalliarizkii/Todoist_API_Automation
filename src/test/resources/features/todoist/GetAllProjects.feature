Feature: Get all projects
  @arifebri @positive_case
  Scenario: Get all projects with all valid value
    Given Get all projects with valid path "projects"
    When Send request get all projects
    Then Should return 200 OK

  @arifebri @negative_case
  Scenario: Get all projects without authorization
    Given Get all projects with valid path "projects" empty authorization
    When Send request get all projects
    Then Should return 401 Unauthorized
    And Body contain "Forbidden"

  @arifebri @negative_case
  Scenario Outline: Get all projects invalid path with special char
    Given Get all projects invalid path "<path>" with special character
    When Send request get all projects
    Then Should return 404 not found
    Examples:
    |path    |
    |&&%#*&&@|
    |&$@*((@#|

  @arifebri @negative_case
  Scenario Outline: Get all projects invalid path with char
    Given Get all projects invalid path "<path>" with character
    When Send request get all projects
    Then Should return 404 not found
    Examples:
      |path    |
      |irokfldlsdl|
      |riuelelpf|

  @arifebri @negative_case
  Scenario Outline: Get all projects invalid path with numerical
    Given Get all projects invalid path <path> with value integer
    When Send request get all projects
    Then Should return 404 not found
    Examples:
      |path  |
      |473872|
      |64380 |