package go.euro.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import go.euro.jsontocsv.CSVWriter;
import go.euro.jsontocsv.JsonFlattener;

public class GenerateCsv {
	
	public static void GenerateCsvFromString(String JsonString, String cityName){
		System.out.println("Generating CSV for : " + cityName);	
		JsonFlattener parser = new JsonFlattener();
        CSVWriter writer = new CSVWriter();
        DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	    Date today = Calendar.getInstance().getTime();        
	    String reportCsvDate = df.format(today);
	    String fileName =cityName+"_"+reportCsvDate;
        List<Map<String, String>> flatJson;
		try {
			flatJson = parser.parseJson(JsonString);
			writer.writeAsCSV(flatJson, fileName+".csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
