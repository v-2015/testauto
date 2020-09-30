Feature: user management
  Narrative: As a user i want to do user management
# list of scenarios
#Scenario 1 - list by user id
#Scenario 2 - list by user role
#Scenario 3 - list by user name
#Scenario 4 - list all users

 #Scenario 4
  @SanityTest
  Scenario Outline : list all users
    Given user service with that displays user details
    When user service is called to display all users
    Then the list of <expectedcount> is displayed
    Examples:// acceptance criteria
      | expectedcount |
      | 10 |
# Scenario 1
  @Smoke7est
  Scenario Outline: list users by id
    Given user id <id>
    When  user service is called for the given user id <id>
    Then  details <username> of <id> is displayed
    Examples:
      | id | username |
      | 1  | User1    |
      | 2  | User2    |
      | 3  | User3    |
      | 4  | User4    |
      | 5  | User5    |

  #Scenario 2
  @RegressionTest
  Scenario Outline: list users by role
    Given userservice
    When  user service is called for the given user role <role>
    Then  user details for the given role is displayed
    Examples:
      | username | id | role      |
      | user1    | 1  | developer |
      | user5    | 5  | developer |

  #Scenario 3
  @RegressionTest
  Scenario Outline: list users by name
    Given user name <username>
    When  user service is called for the given user role <username>
    Then  <role> and  <id>  for the given <username> is displayed
    Examples:
      | username | id | role      |
      | user1    | 1  | developer |
      | user5    | 5  | developer |