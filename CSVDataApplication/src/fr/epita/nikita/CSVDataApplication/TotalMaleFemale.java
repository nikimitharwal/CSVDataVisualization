package fr.epita.nikita.CSVDataApplication;

import java.util.List;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class TotalMaleFemale {
	
	// Total No of male and female
	CategoryAxis xAxis = new CategoryAxis();
	NumberAxis yAxis = new NumberAxis();
	String Male = "Male";
	String Female = "Female";
	final XYChart.Series<String, Number> maleseries = new XYChart.Series<>();
	final XYChart.Series<String, Number> femaleseries = new XYChart.Series<>();
	
	public TotalMaleFemale(Stage stage) {
		
		stage.setTitle("Area Chart");
		final AreaChart<String, Number> areaChart = new AreaChart<>(xAxis, yAxis);
		areaChart.setTitle("Number Of Male And Female");

		yAxis.setLabel("Total Number");
		maleseries.setName(Male);
		femaleseries.setName(Female);
		
		InputEntryCSV dao = new InputEntryCSV();
		List<FetchCSV> listdata = dao.readAll();
		
		int totalemale = 0, totalfemale = 0;
		for (int i = 0; i < listdata.size(); i++) {

			if (listdata.get(i).getSex().equals("male")) {
				totalemale = totalemale + 1;
				maleseries.getData().add(new XYChart.Data(Male, totalemale));
			}
			if (listdata.get(i).getSex().equals("female")) {
				totalfemale = totalfemale + 1;
				femaleseries.getData().add(new XYChart.Data(Female, totalfemale));
			}
		}

		Scene scene = new Scene(areaChart, 800, 600);
		areaChart.getData().addAll(maleseries, femaleseries);
		stage.setScene(scene);
		stage.show();
	}
}
