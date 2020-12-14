package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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

public class RegisterController {

	@FXML
	Button okbt1;
	@FXML
	TextField nametxt;
	@FXML
	TextField idtxt;
	@FXML
	TextField emailtxt;
	@FXML
	PasswordField passtxt;
	@FXML
	Button registerBt;
	@FXML
	String filepath = "src/users.txt";
	@FXML
	static Stage errorStage = new Stage();
	ArrayList<User> userList = new ArrayList<>();
	int target;

	
	@FXML
	public void register() throws IOException {
		if(isFilled() == false) {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("blanksError.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			errorStage.setScene(scene);
			errorStage.show();
		}
	else if(isRegister() == true) {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("emailExistError.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			errorStage.setScene(scene);
			errorStage.show();
		}
		
		else {
		Customer customer = new Customer(idtxt.getText(), passtxt.getText(), nametxt.getText(), emailtxt.getText());
		userList = Main.getUsers();
		userList.add(customer);
		writeObjectToFile(userList);
		
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("MainMenuUI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.getStage().setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}
	}
	
	
	private boolean isFilled() {
		if(emailtxt.getText().equals("") || nametxt.getText().equals("") || idtxt.getText().equals("") || passtxt.getText().equals("")) {
			return false;
		}
		else
		return true;
	}


	private boolean isRegister() throws FileNotFoundException {
		userList = Main.getUsers();
	    for (int i =0; i<userList.size(); i++ ){
            if ((userList.get(i).getID()).equals(idtxt.getText()) ||  userList.get(i).getEmail().equals(emailtxt.getText())){
                 target = i;
            }
        }
		
		if(userList.get(target).getID().equals(idtxt.getText()) || userList.get(target).getEmail().equals(emailtxt.getText())) {
			return true;
		}
		else {
		return false;
	
		}
		}
	
	
	private void writeObjectToFile(Object o) {
	
		try {
			ArrayList<Object> dataList = new ArrayList<>();
			dataList = Main.getData();
			dataList.set(0, userList);
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("data.dat"));
            output.writeObject(dataList);
            output.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }		
	}

	
	
	@FXML
	public void stageOut(){
	errorStage.close();
	}	
	
	
}