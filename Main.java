package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	static ArrayList<User> userList = new ArrayList<>();
    static ArrayList<Car> carList = new ArrayList<>();
    static ArrayList<Rent> rentList = new ArrayList<>();
    static ArrayList<Object> dataList = new ArrayList<>();
	private static Stage GUIStage;
	
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException, IOException {
		    
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("data.dat"));
			dataList = (ArrayList<Object>) input.readObject();
			userList = (ArrayList<User>) dataList.get(0);
			carList = (ArrayList<Car>) dataList.get(1);
			rentList = (ArrayList<Rent>) dataList.get(2);
			GUIStage = primaryStage;
		
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
			Scene scene = new Scene(root,640,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return GUIStage;
	}
	
	public static ArrayList<User> getUsers(){
		return userList;
	}
	
	public static ArrayList<Car> getCars(){
		return carList;
	}
	
	public static ArrayList<Rent> getRents(){
		return rentList;
	}
	
	public static ArrayList<Object> getData(){
		return dataList;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
