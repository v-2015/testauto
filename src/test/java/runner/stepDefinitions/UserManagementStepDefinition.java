package runner.stepDefinitions;


import bddDemo.model.User;
import bddDemo.service.UserService;
import bddDemo.service.UserServiceImpl;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserManagementStepDefinition {

    List<User> userList = new ArrayList<User>();
    UserService userService ;
    String userId = null;
    String userRole = null;
    User user ;
    @Given("^user service with that displays user details$")
    public void user_service_with_that_displays_user_details() throws Throwable {
        userService = new UserServiceImpl();

    }

    @When("^user service is called to display all users$")
    public void user_service_is_called_to_display_all_users() throws Throwable {
        userList = userService.allUsers();
    }

    @Then("^the list of (.+) is displayed$")
    public void the_list_of_is_displayed(String count) throws Throwable {
        int actualUserCount = userList.size();
        assertEquals(count, String.valueOf(actualUserCount) );
//        throw new PendingException();
    }

    @Given("^user id (.+)$")
    public void user_id(String id) throws Throwable {
userId = id;
    }

    @When("^user service is called for the given user id (.+)$")
    public void user_service_is_called_for_the_given_user_id(String id) throws Throwable {
        userService = new UserServiceImpl();
        user = userService.userById(id);
    }

    @Then("^details (.+) of (.+) is displayed$")
    public void of_is_displayed(String username, String id) throws Throwable {
        assertEquals(id, user.getId() );
        assertEquals(username, user.getName() );
    }
    @Given("^userservice$")
    public void userservice() throws Throwable {
        userService = new UserServiceImpl();
    }

    @When("^user service is called for the given user role (.+)$")
    public void user_service_is_called_for_the_given_user_role(String role) throws Throwable {
        userRole = role;
        userList = userService.userByRole(role);
    }

    @Then("^user details for the given role is displayed$")
    public void user_details_for_the_given_role_is_displayed() throws Throwable {
        boolean isRole = userList.stream().allMatch(d -> d.getRole().equalsIgnoreCase(userRole));
        assertTrue(isRole);
    }



}
