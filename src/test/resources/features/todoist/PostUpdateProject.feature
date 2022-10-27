Feature: Update project
  @arifebri @positive_case
  Scenario: Post update project with all valid value
    Given Post update project
    When Send request post update project
    Then Should return 204 no content

  @arifebri @negative_case
  Scenario: Post update project without authorization
    Given Post update project empty authorization
    When Send request post update project
    Then Should return 401 Unauthorized
    And Return body contain "Forbidden"

  @arifebri @negative_case
  Scenario Outline: Post update project invalid id
    Given Post update project invalid id <id>
    When Send request post update project invalid id
    Then Should return 404 not found
    And Return body contain "Project not found"
    Examples:
    |id|
    |2203306 |
    |6727788 |

  @arifebri @negative_case
  Scenario: Post update project empty body request
    Given Post update project empty body request
    When Send request post update project
    Then Should return 400 bad request
    And Return body contain message "At least one of name, color or favorite fields should be set"

  @arifebri @positive_case
  Scenario: Post update project only input body name
    Given Post update project only input body name without color and favorite
    When Send request post update project
    Then Should return 204 no content

  @arifebri @positive_case
  Scenario: Post update project only input body color
    Given Post update project only input body color without name and favorite
    When Send request post update project
    Then Should return 204 no content

  @arifebri @positive_case
  Scenario: Post update project only input body favorite
    Given Post update project only input body favorite without name and color
    When Send request post update project
    Then Should return 204 no content

  @arifebri @positive_case
  Scenario: Post update project without input name
    Given Post update project without input name
    When Send request post update project
    Then Should return 204 no content

  @arifebri @positive_case
  Scenario: Post update project without input color
    Given Post update project without input color
    When Send request post update project
    Then Should return 204 no content

  @arifebri @positive_case
  Scenario: Post update project without input favorite
    Given Post update project without input favorite
    When Send request post update project
    Then Should return 204 no content
