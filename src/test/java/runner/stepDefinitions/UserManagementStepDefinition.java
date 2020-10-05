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
    @Given("user service with that displays user details$")
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


}
