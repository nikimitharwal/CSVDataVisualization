package fr.epita.nikita.CSVDataApplication;

import java.util.List;
import java.util.stream.Collectors;


import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class AgeWiseSurvival {
	
	//Divide Age In two Group and get survival rate acc age group and survived

	@SuppressWarnings("unchecked")
	public AgeWiseSurvival(Stage stage) throws Exception {

		final String maleSurvival = "Male Survival";
		final String femaleSurvival = "Female Survival";
		final String maledeath = "Male Death";
		final String femaledeath = "Female Death";

		final String first = "0-40";
		final String second = "41-80";
	

		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();

		final XYChart.Series<String, Number> MalesurvivalSeries = new XYChart.Series<>();
		final XYChart.Series<String, Number> FemaleSurvivalSeries = new XYChart.Series<>();
		final XYChart.Series<String, Number> MaledeathSeries = new XYChart.Series<>();
		final XYChart.Series<String, Number> FemaledeathSeries = new XYChart.Series<>();

		stage.setTitle("Bar Chart");
		final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("Age And Sex Surviaval Rate");
		
		xAxis.setLabel("Category");
		yAxis.setLabel("Total Number");
		InputEntryCSV dao = new InputEntryCSV();
		List<FetchCSV> listdata = dao.readAll();
		int malesurvivalfirst=0;
		int malesurvivalsecond=0;
		int femalesurvivalfirst=0;
		int femalesurvivalsecond=0;
		int maledeathfirst=0;
		int maledeathsecond=0;
		int femaledeathfirst=0;
		int femaledeathsec=0;
		
		for (int i = 0; i < listdata.size(); i++) {
			FetchCSV csv=listdata.get(i);
			
			if(csv.getAge()>0&&csv.age<=40&&csv.getSex().equals("male")&&csv.getSurvived()==1) {
				malesurvivalfirst=malesurvivalfirst+1;
			}
			if(csv.getAge()>41&&csv.age<=80&&csv.getSex().equals("male")&&csv.getSurvived()==1) {
				malesurvivalsecond=malesurvivalsecond+1;
			}
			
			if(csv.getAge()>0&&csv.age<=40&&csv.getSex().equals("female")&&csv.getSurvived()==1) {
				femalesurvivalfirst=femalesurvivalfirst+1;
			}
			if(csv.getAge()>41&&csv.age<=80&&csv.getSex().equals("female")&&csv.getSurvived()==1) {
				femalesurvivalsecond=femalesurvivalsecond+1;
			}
			

			if(csv.getAge()>0&&csv.age<=40&&csv.getSex().equals("male")&&csv.getSurvived()==0) {
				maledeathfirst=maledeathfirst+1;
			}
			if(csv.getAge()>41&&csv.age<=80&&csv.getSex().equals("male")&&csv.getSurvived()==0) {
				maledeathsecond=maledeathsecond+1;
			}
			
			if(csv.getAge()>0&&csv.age<=40&&csv.getSex().equals("female")&&csv.getSurvived()==0) {
				femaledeathfirst=femaledeathfirst+1;
			}
			if(csv.getAge()>41&&csv.age<=80&&csv.getSex().equals("female")&&csv.getSurvived()==0) {
				femaledeathsec=femaledeathsec+1;
			}
			
			
		}
		
		
		MalesurvivalSeries.setName(maleSurvival);
		addDataItem(MalesurvivalSeries, first, malesurvivalfirst);
		addDataItem(MalesurvivalSeries, second, malesurvivalsecond);
		
		FemaleSurvivalSeries.setName(femaleSurvival);
		addDataItem(FemaleSurvivalSeries, first, femalesurvivalfirst);
		addDataItem(FemaleSurvivalSeries, second, femalesurvivalsecond);
		
		MaledeathSeries.setName(maledeath);
		addDataItem(MaledeathSeries, first, maledeathfirst);
		addDataItem(MaledeathSeries, second, maledeathsecond);
		
		FemaledeathSeries.setName(femaledeath);
		addDataItem(FemaledeathSeries, first, femaledeathfirst);
		addDataItem(FemaledeathSeries, second, femaledeathsec);
		
		Scene scene = new Scene(barChart, 800, 600);
		barChart.getData().addAll(MalesurvivalSeries,FemaleSurvivalSeries,MaledeathSeries,FemaledeathSeries);
		stage.setScene(scene);
		stage.show();
	}

	public void addDataItem(XYChart.Series<String, Number> series,
            String x, Number y) {
        series.getData().add(new XYChart.Data<>(x, y));
    }

}
