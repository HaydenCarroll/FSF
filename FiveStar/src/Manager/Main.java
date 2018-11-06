package Manager;
	
import java.io.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	Data data;
	@Override
	public void start(Stage primaryStage) {
		try {
			//Image icon = new Image("logo.png");
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Base.fxml"));
			Scene scene = new Scene(root,1200,800);
			primaryStage.setTitle("FiveStar");
			//primaryStage.getIcons().add(icon);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			checkDataFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	Data.testFile();
		Data.initalizeData();
		launch(args);
	}
	
	public static void checkDataFile() throws IOException{
		File dataFile = new File("data.dat");
		if(!dataFile.exists()) {
			Data.createDataFile();
			System.out.println("data.dat created");
		}
		
	}
	public static void updateDataFile() throws IOException{
		try {
			File file = new File("data2.dat");
			FileOutputStream dataFile = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(dataFile);
			Data data = new Data(Data.getJobList(),Data.getCustomerList(),Data.getCrewList(),Data.getAddressList(),Data.getAdList(),Data.getMaterialList());
			
			out.writeObject(Data.getJobList());
			out.close();
			dataFile.close();
			System.out.println("File updated");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
