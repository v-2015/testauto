package bddDemo.controller;

import java.util.List;

import bddDemo.model.User;
import bddDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserAPI {

    // nnnn
    @Autowired
    private UserService userRepo;

    @GetMapping("/allUsers")
    List<User> all() {
        return userRepo.allUsers();//userRepo.findAll();
    }

    @GetMapping("/userById/{id}")
    User userById(@PathVariable String id) {
        // userRepo.findById(id)
        //.orElseThrow(() -> new UserNotFoundException(id))
        return  userRepo.userById(id);
    }

    @GetMapping("/userByName/{name}")
    User userByName(@PathVariable String name) {
        // userRepo.findById(id)
        //.orElseThrow(() -> new UserNotFoundException(id))
        return  userRepo.userByName(name);
    }
    @GetMapping("/userByRole/{role}")
    List<User> userByRole(@PathVariable String role) {
        // userRepo.findById(id)
        //.orElseThrow(() -> new UserNotFoundException(id))
        return  userRepo.userByRole(role);
    }

    @GetMapping("/home")
    public String homeRequest() {
        return "welcome";
    }



}
