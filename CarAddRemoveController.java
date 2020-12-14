package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CarAddRemoveController {
	@FXML
	TextField manufacturertxt;
	@FXML
	TextField carIDtxt;
	@FXML
	TextField modeltxt;
	@FXML
	TextField yeartxt;
	@FXML
	TextField gearTypetxt;
	@FXML
	TextField numPassengertxt;
	@FXML
	TextField colortxt;			
	@FXML
	TextField insurancetxt;
	@FXML
	TextField carPlatetxt;
	@FXML
	TextField pricetxt;
	@FXML
	TextField kmtxt;
	@FXML
	ArrayList<Car> carList = new ArrayList<>();
	@FXML
	Button mainMenuBt;
	@FXML
	Button addButton;
	int target;
	@FXML
	Button okbt;
	@FXML
	Button removeBt;
	@FXML
	static Stage errorStage = new Stage();

	
	@FXML
	public void addCar() throws IOException {
		if(isFilled() == false) {
		}
	else if(isRegister() == true) {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("carExistError.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			errorStage.setScene(scene);
			errorStage.show();
		}
	else {
		Car c = new Car(carIDtxt.getText(),manufacturertxt.getText(), modeltxt.getText(), Integer.parseInt(yeartxt.getText()), gearTypetxt.getText(),
				Integer.parseInt(numPassengertxt.getText()), colortxt.getText(),  carPlatetxt.getText(), insurancetxt.getText(),
				Double.parseDouble(pricetxt.getText()));
		carList = Main.getCars();
		carList.add(c);
		writeObjectToFile();
		backToMenu();
	}
	}

@FXML
	private boolean isRegister() {
		carList = Main.getCars();
	    for (int i =0; i<carList.size(); i++ ){
            if ((carList.get(i).getCarID()).equals(carIDtxt.getText()) ||  carList.get(i).getCarPlate().equals(carPlatetxt.getText())){
                 target = i;
            }
        }
		if(carList.get(target).getCarID().equals(carIDtxt.getText()) || carList.get(target).getCarPlate().equals(carPlatetxt.getText())) {
			return true;
		}
		else {
		return false;
	
		}
	}

@FXML
	private boolean isFilled() {
		if(carIDtxt.getText().equals("") || manufacturertxt.getText().equals("") || modeltxt.getText().equals("") || yeartxt.getText().equals("")
				|| numPassengertxt.getText().equals("") || colortxt.getText().equals("") || insurancetxt.getText().equals("") || carPlatetxt.getText().equals("")) {
			return false;
		}
		else {
			return true;
		}
	}

@FXML
	private void writeObjectToFile() {
		
		try {
			ArrayList<Object> dataList = new ArrayList<>();
			dataList = Main.getData();
			dataList.set(1, carList);
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("data.dat"));
            output.writeObject(dataList);
            output.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }		
	}

@FXML
	public void removeCar() throws IOException {
		int check = 0;
		carList = Main.getCars();
		for (int i =0; i<carList.size(); i++ ){
            if ((carList.get(i).getCarID()).equals(carIDtxt.getText())){
                 target = i;
                 check++;
            }
        }
		if(check == 1) {
			carList.remove(target);
			backToMenu();
			writeObjectToFile();
		}
		else {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("carNotExistError.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			errorStage.setScene(scene);
			errorStage.show();
		}
	}
	@FXML
	public void importCarInfo() throws IOException {
		int check = 0;
		carList = Main.getCars();
		for (int i =0; i<carList.size(); i++ ){
            if ((carList.get(i).getCarID()).equals(carIDtxt.getText())){
                 target = i;
                 check++;
            }
        }
		if(check == 1) {
			manufacturertxt.setText(carList.get(target).getManufacturer());
			modeltxt.setText(carList.get(target).getModel());
			yeartxt.setText(String.valueOf(carList.get(target).getYear()));
			carPlatetxt.setText(carList.get(target).getCarPlate());
			insurancetxt.setText(carList.get(target).getInsurance());
			gearTypetxt.setText(carList.get(target).getGearType());
			numPassengertxt.setText(String.valueOf(carList.get(target).getPassengerNum()));
			colortxt.setText(carList.get(target).getColor());
			pricetxt.setText(String.valueOf(carList.get(target).getPrice()));
		}
		else {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("carNotExistError.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			errorStage.setScene(scene);
			errorStage.show();
		}
		
		
	}
	
	// method of save button in Edit Car Information scene to update the object
	@FXML
	public void editCar() {
		carList = Main.getCars();
		for (int i =0; i<carList.size(); i++ ){
            if ((carList.get(i).getCarID()).equals(carIDtxt.getText())){
                 target = i;
            }
        }
		if(isFilled() == false) {
			
		}
		else {
		carList.get(target).setManufacturer(manufacturertxt.getText());
		carList.get(target).setModel(modeltxt.getText());
		carList.get(target).setYear(Integer.parseInt(yeartxt.getText()));
		carList.get(target).setGearType(gearTypetxt.getText());
		carList.get(target).setNumPassenger(Integer.parseInt(numPassengertxt.getText()));
		carList.get(target).setColor(colortxt.getText());
		carList.get(target).setCarPlate(carPlatetxt.getText());
		carList.get(target).setInsurance(insurancetxt.getText());
		carList.get(target).setPrice(Double.parseDouble(pricetxt.getText()));
		writeObjectToFile();
		backToMenu();
	}}
	@FXML
	public void backToMenu() {
		try {		
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("ManagerUI.fxml"));
						Scene scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.getStage().setScene(scene);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
	@FXML
	public void stageOut(){
	errorStage.close();
	}	
	
}
