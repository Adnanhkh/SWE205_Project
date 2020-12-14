package application;

public class Manager extends User {

	public Manager(String id, String pass, String name, String email) {
		super(id, pass, name, email);
	}

	public String toString() {
		return "Manager " + getID() +" " + getPass() + " "+ getName()+" "  + getEmail();
	}
}
