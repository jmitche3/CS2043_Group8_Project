package Group_Project;

import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
 
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
		runButton.setOnAction((new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Global Distribution");
                Scene scene = new Scene(new Group());
                newWindow.setScene(scene);
                newWindow.setTitle("Global Distribution");
                newWindow.setWidth(500);
                newWindow.setHeight(500);
         
        		//For our project we will be able to calculate the numbers for each category
        		//by adding corresponding levels of each area together (from the area distribution)
        		//and using fractions (the levels over the total number of grades multiplied by 100)
        		//to determine what values belong in the pie chart.
                ObservableList<PieChart.Data> pieChartData =
                        FXCollections.observableArrayList(
                        new PieChart.Data("Exceeds", 34),
                        new PieChart.Data("Meets", 38),
                        new PieChart.Data("Marginal", 23),
                        new PieChart.Data("Fails", 5));
                final PieChart chart = new PieChart(pieChartData);
                chart.setTitle("Global Distribution");

                ((Group) scene.getRoot()).getChildren().add(chart);
                newWindow.setScene(scene);
                
 
                // Set position of second window, related to primary window.
                newWindow.setX(s.getX() + 200);
                newWindow.setY(s.getY() + 100);
 
                newWindow.show();
            }
        }));
		
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
			currentRegistrar.loadTranscripts();
			currentRegistrar.loadCourseAreas();
			currentRegistrar.loadLevelSchema();
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