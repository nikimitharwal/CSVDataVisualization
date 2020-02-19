package fr.epita.nikita.CSVDataApplication;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		
		//SpouseParentSurvival spouse=new SpouseParentSurvival(stage);
		//TotalMaleFemale totalmale=new TotalMaleFemale(stage);
	    //AgeWiseSurvival age=new AgeWiseSurvival(stage);
	
		PassengerClassAgeAndFAre pclass=new PassengerClassAgeAndFAre(stage);
		
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}
