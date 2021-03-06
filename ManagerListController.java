package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerListController {

	@FXML
	Button addCarbt;
	@FXML
	Button removeCarbt;
	@FXML
	Button editCarbt;
	@FXML
	Button logoutbt;
	
	
	
	@FXML
	public void goToAddCar() {
try {		
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("AddNewCarUI.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.getStage().setScene(scene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
	
	public void goToRemoveCar() {
		try {		
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("RemoveCarUI.fxml"));
						Scene scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.getStage().setScene(scene);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
	
	public void goToEditCar() {
		try {		
					VBox root = (VBox)FXMLLoader.load(getClass().getResource("EditCarInfo.fxml"));
						Scene scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						Main.getStage().setScene(scene);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}


	public void logout(){
	
		try {
		VBox root = (VBox)FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.getStage().setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

}
}