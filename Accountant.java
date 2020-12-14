package application;


public class Accountant extends User {

	 private Manager manager;

	public Manager getManager() {
		return manager;
	}

	public void setManager (Manager manager) {
		this.manager = manager;
	}

}
