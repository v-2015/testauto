Feature: user management

# list of scenarios
#Scenario 1 - list by user id
#Scenario 2 - list by user role
#Scenario 3 - list by user name
#Scenario 4 - list all users

#Scenario 4
  @SanityTest
  Scenario Outline: list all users
    Given user service with that displays user details
    When user service is called to display all users
    Then the list of <expectedcount> is displayed
    Examples:
      | expectedcount |
      | 5           |
