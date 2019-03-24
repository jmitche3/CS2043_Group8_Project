package Group_Project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;
import java.io.File;
 
public class DriverGUI extends Application implements EventHandler<ActionEvent>
{
	Button runButton;
	Button dirButton;
	TextField text;
	String currentPath;
	Stage s;
	
	public static void main(String[]args)
	{
		launch();
	}
	
	@Override
	public void start(Stage s)
	{
		currentPath = System.getProperty("user.home");
		
		VBox parent = new VBox();
		parent.setPadding(new Insets(10));
        parent.setSpacing(10);
		
		Label label = new Label("Please Enter a Path:");
		parent.getChildren().add(label);
		
		text = new TextField();
		text.setText(currentPath);
		text.setEditable(false);
		parent.getChildren().add(text);
		
		runButton = new Button("Run");
		parent.getChildren().add(runButton);
		runButton.setTranslateX(110);
		runButton.setTranslateY(0);
		runButton.setOnAction(this);
		
		dirButton= new Button("Select Directory");
		parent.getChildren().add(dirButton);
		dirButton.setTranslateX(180);
		dirButton.setTranslateY(-35);
		dirButton.setOnAction(this);
		
		
		Scene scene = new Scene(parent, 400, 100);
		
		s.setTitle("Transcript Analyser");
        s.setScene(scene);
        s.show();
	}
	
	@Override
	public void handle(ActionEvent event)
	{
		if(event.getSource() == runButton)
		{
			Registrar currentRegistrar = new Registrar(currentPath);
			currentRegistrar.loadTranscripts(currentPath);
		}
		
		if(event.getSource() == dirButton)
		{
			DirectoryChooser chooser = new DirectoryChooser();
			chooser.setTitle("Choose Data Directory");
			File defaultDirectory = new File(currentPath);
			chooser.setInitialDirectory(defaultDirectory);
			File selectedDirectory = chooser.showDialog(s);
			if(selectedDirectory != null)
			{
				currentPath = selectedDirectory.toString();
			}
			text.setText(currentPath);
		}
	}
}