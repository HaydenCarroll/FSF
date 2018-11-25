package Manager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FSF {
	
	private static Job job;
	
	public Label date;
	public Label name;
	public Label address;
	public Label phoneNum;
	public Label ref;
	public Label email;
	public Label jobName;
	Stage stage = new Stage();
	
	public FSF() {}
	
	public AnchorPane pane;
	
	public void editJob() {
		try {	
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("FSFForm.fxml"));
			Scene scene = new Scene(root,900,900);
			stage.setTitle("Quote");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		WritableImage image = pane.snapshot(new SnapshotParameters(), null);
	    
	    // TODO: probably use a file chooser here
		String fileName = job.getName().trim()+".png";
	    File file = new File(fileName);
	    
	    
	    try {
	        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
	    } catch (IOException e) {
	        // TODO: handle exception here
	    }
	}
	public void sendData(Job j) {
		job=j;
	}
	
	public void initalize() {
		date.setText(LocalDate.now().toString());
		name.setText(job.getCustomer().getName());
		address.setText(job.getAddress().toString());
		phoneNum.setText(job.getCustomer().getPhone());
		ref.setText(job.getAd().getName());
		email.setText(job.getCustomer().getEmail());
		jobName.setText(job.getName());
		
	}

}
