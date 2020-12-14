package application;

import java.io.Serializable;

public class Customer extends User{
	private  boolean isRentingAcar;
	private  Rent rent;


	public Customer(String id, String pass, String name, String email) {
		super(id, pass, name, email);
	}



	
	public String toString() {
		return "Customer " + getID() +" " + getPass() + " "+ getName()+" "  + getEmail();
	}


}
