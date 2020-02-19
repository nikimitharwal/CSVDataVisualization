package fr.epita.nikita.CSVDataApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class InputEntryCSV {
	 public List<FetchCSV> readAll(){
	        List<FetchCSV>alldata= new ArrayList<>();
	        try {
	            List<String> lines=Files.readAllLines(new File("C:\\Users\\HP\\Desktop\\input.csv").toPath());
	            //because of headers
	            lines.remove(0);
	            for (String line:lines){
	                String[]parts=line.split(",");
	                FetchCSV model=new FetchCSV();
	                model.setSurvived(Integer.parseInt(parts[0]));
	                model.setPclass(Integer.parseInt(parts[1]));
	                model.setName(parts[2]);
	                model.setSex(parts[3]);
	                model.setAge(Double.parseDouble(parts[4]));
	                model.setSpouse(Integer.parseInt(parts[5]));
	                model.setParents(Integer.parseInt(parts[6]));
	                model.setFare(Double.parseDouble(parts[7]));
	              
	                alldata.add(model);
	            }
	            return alldata;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return alldata;
	    }
}
