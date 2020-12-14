package application;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Car implements Serializable {

	private static final long serialVersionUID = -1954794509243376048L;
	String carID;
	String manufacturer;
	String model;
	int year;
	String gearType;
	int numPassenger;
	String color;
	String carPlate;
	String insurance;
	double price;
	final double lateFees = 1.5;
	double km;
	boolean isRented;
	int numberCars;



	Car(String carID, String manufacturer, String model, int year, String gearType, int numPassenger, String color,
			String carPlate, String insurance, double price) {
		this.carID = carID;
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.gearType = gearType;
		this.numPassenger = numPassenger;
		this.color = color;
		this.carPlate = carPlate;
		this.insurance = insurance;
		this.price = price;
	}
	
	
	
	
	public void setKm( double km) {
	this.km = km;
	}
	
	public void setModel( String model) {
		this.model=model;
	}
	
	public void setManufacturer( String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setYear( int year) {
		this.year = year;
	}
	
	public void setGearType( String gearType) {
		this.gearType = gearType;
	}
	
	public void setNumPassenger( int numPassenger) {
		this.numPassenger = numPassenger;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}
	
	public void setInsurance( String insurance) {
		this.insurance = insurance;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCarID() {
		return carID;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getCarPlate() {
		return carPlate;
	}
	
	public String getInsurance() {
		return insurance;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getGearType() {
		return gearType;
	}
	
	public int getPassengerNum() {
		return numPassenger;
	}
	
	public int getYear() {
		return year;
	}
	
	public String toString() {
		return carID + " " + model + ":" + year;
	}

	public double getPrice() {
		return price;
	}
	
	public String getMainInfo() {
		return getModel() + " " + String.valueOf(getYear());
	}
}
