Feature: Features to test Todoist

  @Tamara #DeleteMethod_001
  Scenario Outline: Delete project with valid id
    Given Delete a project with valid id "<id>"
    When Send request delete a project
    Then Should return 204 No content
    Examples:
    |id|
    |projects/2299972865|
    |projects/2299972881|

  @Tamara #DeleteMethod_002
  Scenario Outline: Delete project without authorized
    Given Delete project valid id "<id>" without authorized
    When Send request delete a project
    Then Should return 401 Unauthorized
    And Response body should contain message "Forbidden"
    Examples:
      |id|
      |projects/2299972865|
      |projects/2299972881|

  @Tamara #DeleteMethod_003
  Scenario Outline: Delete project not register id
    Given Delete project not register id "<id>"
    When Send request delete a project
    Then Should return 404 Not found
    Examples:
      |id|
      |projects/23047589|
      |projects/015687|

  @Tamara #DeleteMethod_004
  Scenario Outline: Delete project with minimum digit id
    Given Delete project with minimum digit id "<id>"
    When Send request delete a project
    Then Should return 404 Not found
    Examples:
      |id|
      |projects/2|
      |projects/8|

  @Tamara #DeleteMethod_005
  Scenario Outline: Delete project with invalid id
    Given Delete project with invalid id "<id>"
    When Send request delete a project
    Then Should return 400 Bad request
    And Response body should contain message "project_id is invalid"
    Examples:
      |id|
      |projects/0|
      |projects/00|

  Scenario Outline: Delete project with special char id
    Given Delete project with special char id "<id>"
    When Send request delete a project
    Then Should return 400 Bad request
    And Response body should contain message "project_id is invalid"
    Examples:
      |id|
      |projects/@!#$%25|




  


















