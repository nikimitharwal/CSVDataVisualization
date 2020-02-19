package fr.epita.nikita.CSVDataApplication;

import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class SpouseParentSurvival {
	@SuppressWarnings("unchecked")
	
	// get survival rate acc spouse/sibling size
	
//	Spouse Survival graph  in three 
	public SpouseParentSurvival(Stage stage) throws Exception {

		final String SpouseSurvival = "Spouse Survival";
		final String Spousedeath= "Spouse Death";
		

		final String first = "0-2";
		final String second = "3-5";
		final String third = "6-8";
		

		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();

		final XYChart.Series<String, Number> spousesurvival = new XYChart.Series<>();
		final XYChart.Series<String, Number> spousedeath = new XYChart.Series<>();
		

		stage.setTitle("Line Chart");
		final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Spouse/Sibling/Family size wise Survival");
		
		xAxis.setLabel("Family Size");
		yAxis.setLabel("Total Number");
		InputEntryCSV dao = new InputEntryCSV();
		List<FetchCSV> listdata = dao.readAll();
		int sposefirstsurvival=0;
		int sposesecondsurvival=0;
		int sposethirdsurvival=0;
		
		int sposefirstdeath=0;
		int sposeseconddeath=0;
		int sposethirddeath=0;
		for (int i = 0; i < listdata.size(); i++) {
			FetchCSV csv=listdata.get(i);
			if(csv.getSpouse()<=2&&csv.getSurvived()==1) {
				sposefirstsurvival=sposefirstsurvival+1;
			}
			if(csv.getSpouse()>2&&csv.getSpouse()<=5&&csv.getSurvived()==1) {
				sposesecondsurvival=sposesecondsurvival+1;
			}
			if(csv.getSpouse()>5&&csv.getSpouse()<=8&&csv.getSurvived()==1) {
				sposethirdsurvival=sposethirdsurvival+1;
			}
			
			if(csv.getSpouse()<=2&&csv.getSurvived()==0) {
				sposefirstdeath=sposefirstdeath+1;
			}
			if(csv.getSpouse()>2&&csv.getSpouse()<=5&&csv.getSurvived()==0) {
				sposeseconddeath=sposeseconddeath+1;
			}
			if(csv.getSpouse()>5&&csv.getSpouse()<=8&&csv.getSurvived()==0) {
				sposethirddeath=sposeseconddeath+1;
			}
		}
		
		spousesurvival.setName(SpouseSurvival);
		addDataItem(spousesurvival, first, sposefirstsurvival);
		addDataItem(spousesurvival, second, sposesecondsurvival);
		addDataItem(spousesurvival, third, sposethirdsurvival);
		
		
		
		
		spousedeath.setName(Spousedeath);
		addDataItem(spousedeath, first, sposefirstdeath);
		addDataItem(spousedeath, second, sposeseconddeath);
		addDataItem(spousedeath, third, sposethirddeath);
	

		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().addAll(spousesurvival,spousedeath);
		stage.setScene(scene);
		stage.show();
	}

	public void addDataItem(XYChart.Series<String, Number> series,
            String x, Number y) {
        series.getData().add(new XYChart.Data<>(x, y));
    }

}
