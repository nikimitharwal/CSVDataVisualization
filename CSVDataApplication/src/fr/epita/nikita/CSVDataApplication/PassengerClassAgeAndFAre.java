package fr.epita.nikita.CSVDataApplication;

import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PassengerClassAgeAndFAre {
	
// Divide Fare in three category and get totalno of male female according fare and Passenger class
	@SuppressWarnings("unchecked")
	public PassengerClassAgeAndFAre(Stage stage) throws Exception {

		final String first = "0-200";
		final String second = "201-400";
		final String third = "401-600";
		

		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();

		final XYChart.Series<String, Number> Pclass1maleseries = new XYChart.Series<>();
		final XYChart.Series<String, Number> Pclass2maleseries = new XYChart.Series<>();
		final XYChart.Series<String, Number> Pclass3maleseries = new XYChart.Series<>();
		final XYChart.Series<String, Number> Pclass1femaleseries = new XYChart.Series<>();
		final XYChart.Series<String, Number> Pclass2femaleseries = new XYChart.Series<>();
		final XYChart.Series<String, Number> Pclass3femaleseries = new XYChart.Series<>();
		

		stage.setTitle("Bar Chart");
		final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("Pclass And Sex And Fare Wise Visualization");
		
		xAxis.setLabel("Fare");
		yAxis.setLabel("TotalNumber");
		InputEntryCSV dao = new InputEntryCSV();
		List<FetchCSV> listdata = dao.readAll();
		
		int p1firstmale=0;
		int p1secondmale=0;
		int p1thirdmale=0;
		
		int p2firstmale=0;
		int p2secondmale=0;
		int p2thirdmale=0;
		
		int p3firstmale=0;
		int p3secondmale=0;
		int p3thirdmale=0;
		
		int p1firstfemale=0;
		int p1secondfemale=0;
		int p1thirfemale=0;
		
		int p2firstfemale=0;
		int p2secondfemale=0;
		int p2thirfemale=0;
		
		int p3firstfemale=0;
		int p3secondfemale=0;
		int p3thirfemale=0;
		for (int i = 0; i < listdata.size(); i++) {
			FetchCSV csv=listdata.get(i);
			
			if(csv.getSex().equals("male")&&csv.getPclass()==1&&csv.getFare()>0&&csv.getFare()<=200) {
				p1firstmale=p1firstmale+1;
			}

			if(csv.getSex().equals("male")&&csv.getPclass()==1&&csv.getFare()>200&&csv.getFare()<=400) {
				p1secondmale=p1secondmale+1;
			}
			
			if(csv.getSex().equals("male")&&csv.getPclass()==1&&csv.getFare()>400&&csv.getFare()<=600) {
				p1thirdmale=p1thirdmale+1;
			}
			
			
			if(csv.getSex().equals("male")&&csv.getPclass()==2&&csv.getFare()>0&&csv.getFare()<=200) {
				p2firstmale=p2firstfemale+1;
			}

			if(csv.getSex().equals("male")&&csv.getPclass()==2&&csv.getFare()>200&&csv.getFare()<=400) {
				p2secondmale=p2secondmale+1;
			}
			
			if(csv.getSex().equals("male")&&csv.getPclass()==2&&csv.getFare()>400&&csv.getFare()<=600) {
				p2thirdmale=p2thirdmale+1;
			}
			
			if(csv.getSex().equals("male")&&csv.getPclass()==3&&csv.getFare()>0&&csv.getFare()<=200) {
				p3firstmale=p3firstfemale+1;
			}

			if(csv.getSex().equals("male")&&csv.getPclass()==3&&csv.getFare()>200&&csv.getFare()<=400) {
				p3secondmale=p3secondmale+1;
			}
			
			if(csv.getSex().equals("male")&&csv.getPclass()==3&&csv.getFare()>400&&csv.getFare()<=600) {
				p3thirdmale=p3thirdmale+1;
			}
			
			if(csv.getSex().equals("female")&&csv.getPclass()==1&&csv.getFare()>0&&csv.getFare()<=200) {
				p1firstfemale=p1firstfemale+1;
			}

			if(csv.getSex().equals("female")&&csv.getPclass()==1&&csv.getFare()>200&&csv.getFare()<=400) {
				p1secondfemale=p1secondfemale+1;
			}
			
			if(csv.getSex().equals("female")&&csv.getPclass()==1&&csv.getFare()>400&&csv.getFare()<=600) {
				p1thirfemale=p1thirfemale+1;
			}
			
			if(csv.getSex().equals("female")&&csv.getPclass()==2&&csv.getFare()>0&&csv.getFare()<=200) {
				p2firstfemale=p2firstfemale+1;
			}

			if(csv.getSex().equals("female")&&csv.getPclass()==2&&csv.getFare()>200&&csv.getFare()<=400) {
				p2secondfemale=p2secondfemale+1;
			}
			
			if(csv.getSex().equals("female")&&csv.getPclass()==2&&csv.getFare()>400&&csv.getFare()<=600) {
				p2thirfemale=p2thirfemale+1;
			}
			
			if(csv.getSex().equals("female")&&csv.getPclass()==3&&csv.getFare()>0&&csv.getFare()<=200) {
				p3firstfemale=p3firstfemale+1;
			}

			if(csv.getSex().equals("female")&&csv.getPclass()==3&&csv.getFare()>200&&csv.getFare()<=400) {
				p3secondfemale=p3secondfemale+1;
			}
			
			if(csv.getSex().equals("female")&&csv.getPclass()==3&&csv.getFare()>400&&csv.getFare()<=600) {
				p3thirfemale=p3thirfemale+1;
			}
		}
		
		Pclass1maleseries.setName("Pclass 1 Male");
		addDataItem(Pclass1maleseries, first, p1firstmale);
		addDataItem(Pclass1maleseries, second, p1secondmale);
		addDataItem(Pclass1maleseries, third, p1thirdmale);
		
		Pclass2maleseries.setName("Pclass 2 Male");
		addDataItem(Pclass2maleseries, first, p2firstmale);
		addDataItem(Pclass2maleseries, second, p2secondmale);
		addDataItem(Pclass2maleseries, third, p2thirdmale);
		
		Pclass3maleseries.setName("Pclass 3 Male");
		addDataItem(Pclass3maleseries, first, p2firstmale);
		addDataItem(Pclass3maleseries, second, p2secondmale);
		addDataItem(Pclass3maleseries, third, p2thirdmale);
		
		
		Pclass1femaleseries.setName("Pclass 1 Female");
		addDataItem(Pclass1femaleseries, first, p1firstfemale);
		addDataItem(Pclass1femaleseries, second, p1secondfemale);
		addDataItem(Pclass1femaleseries, third, p1thirfemale);
		
		Pclass2femaleseries.setName("Pclass 2 FeMale");
		addDataItem(Pclass2femaleseries, first, p2firstfemale);
		addDataItem(Pclass2femaleseries, second, p2secondfemale);
		addDataItem(Pclass2femaleseries, third, p3thirfemale);
		
		Pclass3femaleseries.setName("Pclass 3 FeMale");
		addDataItem(Pclass3femaleseries, first, p3firstfemale);
		addDataItem(Pclass3femaleseries, second, p3secondfemale);
		addDataItem(Pclass3femaleseries, third, p3thirfemale);
	
		Scene scene = new Scene(barChart, 800, 600);
		barChart.getData().addAll(Pclass1maleseries,Pclass1femaleseries,Pclass2maleseries,Pclass2femaleseries,Pclass3maleseries,Pclass3femaleseries);
		stage.setScene(scene);
		stage.show();
	}

	public void addDataItem(XYChart.Series<String, Number> series,
            String x, Number y) {
        series.getData().add(new XYChart.Data<>(x, y));
    }

}
