package application;

import java.io.Serializable;
import java.util.Date;

public class Rent implements Serializable {

	boolean isValid;
	private Customer customer;
	private Car car;
	private Bill bill;
	private Date receiveDate;
	private Date returnDate;

	public Rent(){

	}


	public Rent( Customer customer, Car car,Date receiveDate,Date returnDate){
           this.customer =customer;
		   this.car =car;
		   this.receiveDate = receiveDate;
		   this.returnDate =returnDate;
	}

	public Bill getBill() {
		return bill;
	}

	public Car getCar() {
		return car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public void setRintValidation(boolean isValid) {
		this.isValid = isValid;
	}

}
