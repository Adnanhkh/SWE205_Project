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

public class MainMenuController {

	@FXML
	Button managebt;
	@FXML
	Button carListbt;
	@FXML
	Button statusbt;
	@FXML
	Button extendbt;
	@FXML
	Button logoutbt;
	@FXML
	static
	Stage errorStage = new Stage();


	
	@FXML
	public void goToCarList(){
		
			try {
			
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("CARLISTUI.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.getStage().setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	@FXML
	public void goToStatus(){
		
			try {
			
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("rentalStatus.fxml"));
				Scene scene = new Scene(root,640,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.getStage().setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}
	
	@FXML
	public void goToExtend(){
		
			try {
			
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("ExtendUI.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.getStage().setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}
	
	@FXML
	public void goToManage(){
		
			try {
			
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("ModifyUI.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.getStage().setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}


	@FXML
	public void logout(){
		
			try {
			
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.getStage().setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}
	
}

