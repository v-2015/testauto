/**
 * 
 */
package bddDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bddDemo.model.User;


/**
 * @author vlayca
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	static List<User> userList = createMockData();

	@Override
	public List<User> allUsers() {
		List<User> userList = createMockData();
		return userList;
	}

	@Override
	public User userById(String id) {

		return userList.stream().filter(u -> id.equals(u.getId())).findAny().orElse(null);
	}

	@Override
	public User userByName(String name) {
		return  userList.stream().filter(u -> name.equalsIgnoreCase(u.getName())).findAny().orElse(null);
	}

	@Override
	public List<User> userByRole(String role) {
		return userList.stream().filter(u -> role.equalsIgnoreCase(u.getRole())).collect(Collectors.toList());
	}

	private static List<User> createMockData() {
		List<User> userList = new ArrayList<>();
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		User user5 = new User();

		user1.setId("1");
		user1.setName("User1");
		user1.setRole("developer");

		user2.setId("2");
		user2.setName("User2");
		user2.setRole("FA");

		user3.setId("3");
		user3.setName("User3");
		user3.setRole("Tester");
		
		user4.setId("4");
		user4.setName("User4");
		user4.setRole("developer");
		
		user5.setId("5");
		user5.setName("User5");
		user5.setRole("developer");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);

		return userList;

	}
}
