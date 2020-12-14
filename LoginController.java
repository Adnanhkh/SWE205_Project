package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

public class LoginController {

	@FXML
	Button loginBt;
	@FXML
	Button registerBt;
	@FXML
	TextField idtxt = new TextField();
	@FXML
	PasswordField passtxt = new PasswordField();
	@FXML
	File userFile = new File("src/users.txt");
	@FXML
	ArrayList<String> users;
	@FXML
	Scanner read;
	@FXML
	boolean check = false;
	@FXML
	Button okbt;
	@FXML
	static Stage errorStage = new Stage();
	ArrayList<User> userList = new ArrayList<>();
	User user;
	int target;


	
	@FXML
	public void goToRegister(){
		
			try {
			
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("RegisterUI.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.getStage().setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}

	@FXML
	public void login() throws IOException, ClassNotFoundException {
		userList = Main.getUsers();
	    for (int i =0; i<userList.size(); i++ ){
            if (  (  userList.get(i).getID()).equals(idtxt.getText())  ){
                 target = i;
            }
        }
			if(userList.get(target).getID().equals(idtxt.getText())) {
				if(userList.get(target).getPass().equals(passtxt.getText())) {
					if(userList.get(target).getClass().equals(Manager.class)) {
						VBox root = (VBox)FXMLLoader.load(getClass().getResource("ManagerUI.fxml"));
						Scene scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.getStage().setScene(scene);
					}
					else {	try {
						user = userList.get(target);
						VBox root = (VBox)FXMLLoader.load(getClass().getResource("MainMenuUI.fxml"));
						Scene scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.getStage().setScene(scene);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}
			}
				else {
					try {
								Pane root = (Pane)FXMLLoader.load(getClass().getResource("wrongLoginUI.fxml"));
								Scene scene = new Scene(root);
								scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
								errorStage.setScene(scene);
								errorStage.show();
					}catch (IOException e1) {
					e1.printStackTrace();
						}
				}
			}
			else {
	try {
				Pane root = (Pane)FXMLLoader.load(getClass().getResource("wrongLoginUI.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				errorStage.setScene(scene);
				errorStage.show();
	}catch (IOException e1) {
	e1.printStackTrace();
		}
		}
	}
	

	@FXML
	public void stageOut(){
	errorStage.close();
	}


}

