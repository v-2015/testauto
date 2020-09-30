/**
 * 
 */
package bddDemo.model;


/**
 * @author vlayca
 *
 */
//@Data
//@Entity
public class User {
	
	private /*@Id @GeneratedValue */String id;
	private String name;
	private String role;
	
	public User() {}

	public User(String name,  String role) {
		this.name = name;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	


}
