package bddDemo.service;

import java.util.List;

import bddDemo.model.User;


public interface UserService {
	List<User> allUsers();
	User userById(String id);
	User userByName(String name);
	List<User> userByRole(String role);


}
