
package application;

import java.util.Date;

public class Offer extends Rent {

	private OfferPermission offerpermission;
	double discount;

	public Offer(Customer customer, Car car, Date receiveDate,Date returnDate,OfferPermission offerpermission, double discount){
		super(customer, car, receiveDate, returnDate);
		if (discount <= offerpermission.getMaximumAllowedDiscount()){
			this.discount = discount;
		}
	}

	public OfferPermission getOfferpermission() {
		return offerpermission;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		discount = discount;
	}
}
