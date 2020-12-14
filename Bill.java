package application;

public class Bill {

	private Rent rent;
	private Offer offer;
	private  double totalPrice;
	private boolean IsPayed;
	private String PaymentMethod;

	public Bill(Rent rent,double totalPrice,boolean IsPayed){
		this.rent =rent;
		this.totalPrice = totalPrice;
	}

	public Bill(Rent rent,double totalPrice, boolean IsPayed, Offer offer){
		this.rent =rent;
		this.totalPrice = totalPrice;
		this.offer = offer;
	}

	public Bill(Rent rent,double totalPrice,boolean IsPayed, String PaymentMethod){
		this.rent =rent;
		this.totalPrice = totalPrice;
	}

	public Bill(Rent rent,double totalPrice, boolean IsPayed, Offer offer, String PaymentMethod){
		this.rent =rent;
		this.totalPrice = totalPrice;
		this.offer = offer;
	}

	public void addDamageFee(double fee){
		totalPrice+=fee;
	}

	public Rent getRent() {
		return rent;
	}

	public Offer getOffer() {
		return offer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void getPayed(boolean payed) {
		IsPayed = payed;
	}

	public String getPaymentMethod() {
		return PaymentMethod;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public void setPayed(boolean payed) {
		IsPayed = payed;
	}

	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
}
