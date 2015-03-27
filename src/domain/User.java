package domain;

public class User extends Entity {

	private String login;
	private String password;
	private UserRole role;
	private Person person;

	public User() {
	}
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "id=" + super.getId()+ ", login=" + login + ", password=" + password + ", role ["
				+ role + "], person [" + person+"]";
	}

	
	
}
