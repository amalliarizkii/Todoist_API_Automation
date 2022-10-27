Feature: Features to test Todoist

  @Tamara #GetCollabMethod_001
  Scenario Outline: Get all collaborators without authorization
    Given Set to url unauthorized "<url>"
    When Send request get all collaborators
    Then Should return 401 Unauthorized
    And Response body should contain message "Forbidden"
    Examples:
    |url|
    |https://api.todoist.com/rest/v1/projects/2299972865/collaborators|
    |https://api.todoist.com/rest/v1/projects/2299972881/collaborators|

  @Tamara #GetCollabMethod_002
  Scenario Outline: Get all collaborators with valid id and there is a collaborator email
    Given Set to url authorized "<url>"
    When Send request get all collaborators
    Then Should return 200 OK
    Examples:
      |url|
      |https://api.todoist.com/rest/v1/projects/2299972865/collaborators|
      |https://api.todoist.com/rest/v1/projects/2299972881/collaborators|

  @Tamara #GetCollabMethod_003
  Scenario Outline: Get all collaborations with a valid id and no collaborator email
    Given Set to url authorized "<url>"
    When Send request get all collaborators
    Then Should return 200 OK
    Examples:
      |url|
      |https://api.todoist.com/rest/v1/projects/2299972876/collaborators|

  @Tamara #GetCollabMethod_004
  Scenario Outline: Get all collaborators with not register id
    Given Set to url authorized "<url>"
    When Send request get all collaborators
    Then Should return 404 Not found
    Examples:
      |url|
      |https://api.todoist.com/rest/v1/projects/23047589/collaborators|
      |https://api.todoist.com/rest/v1/projects/015687/collaborators|

  @Tamara #GetCollabMethod_005
  Scenario Outline: Get all collaborators with minimum id
    Given Set to url authorized "<url>"
    When Send request get all collaborators
    Then Should return 404 Not found
    Examples:
      |url|
      |https://api.todoist.com/rest/v1/projects/2/collaborators|
      |https://api.todoist.com/rest/v1/projects/8/collaborators|

  @Tamara #GetCollabMethod_006
  Scenario Outline: Get all collaborators with invalid id
    Given Set to url authorized "<url>"
    When Send request get all collaborators
    Then Should return 400 Bad request
    And Response body should contain message "project_id is invalid"
    Examples:
      |url|
      |https://api.todoist.com/rest/v1/projects/0/collaborators|
      |https://api.todoist.com/rest/v1/projects/000/collaborators|

  @Tamara #GetCollabMethod_007
  Scenario Outline: Get all collaborators with special char id
    Given Set to url authorized "<url>"
    When Send request get all collaborators
    Then Should return 404 Not found
    And Response body should contain message "Not found"
        Examples:
          |url|
          |https://api.todoist.com/rest/v1/projects/!@#%25/collaborators|

  @Tamara #GetCollabMethod_008
  Scenario Outline: Get all collaborats with a valid id and invalid email member collab
    Given Set to url authorized "<url>"
    When Send request get all collaborators
    Then Should return 200 OK
    Examples:
      |url|
      |https://api.todoist.com/rest/v1/projects/2299972876/collaborators|





