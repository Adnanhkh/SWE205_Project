
package application;

import java.util.Date;

public class OfferPermission {

	private Car car;
	private double maximumAllowedDiscount;
	private Date offerExpireDate;

	public OfferPermission (Car car,double maximumAllowedDiscount,Date offerExpireDate){
		this.car = car;
		this.maximumAllowedDiscount = maximumAllowedDiscount;
		this.offerExpireDate = offerExpireDate;
		this.offerExpireDate =offerExpireDate;
	}

	public Car getCar() {
		return car;
	}

	public Date getOfferExpireDate() {
		return offerExpireDate;
	}

	public double getMaximumAllowedDiscount() {
		return maximumAllowedDiscount;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setMaximumAllowedDiscount(double maximumAllowedDiscount) {
		this.maximumAllowedDiscount = maximumAllowedDiscount;
	}

	public void setOfferExpireDate(Date offerExpireDate) {
		this.offerExpireDate = offerExpireDate;
	}
}
