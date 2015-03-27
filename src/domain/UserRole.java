package domain;

/**
 * @author Andrei
 * 
 */

public class UserRole extends Entity {

	private String role;



	public String getRoleName() {
		return role;
	}



	public void setRoleName(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "id="+super.getId() +", role=" + role;
	}
	
	
	
}
