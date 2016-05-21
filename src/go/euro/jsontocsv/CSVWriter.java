package go.euro.jsontocsv;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class CSVWriter {
	
	private String[] filterColumn= {"_id","name","type","latitude","longitude"};

    public void writeAsCSV(List<Map<String, String>> flatJson, String fileName) throws FileNotFoundException {
        Set<String> headers = collectHeaders(flatJson);
        String output = StringUtils.join(headers.toArray(), ",") + "\n";
        for (Map<String, String> map : flatJson) {
        
            output = output + getCommaSeperatedRow(headers, map) + "\n";
            
        }
        writeToFile(output, fileName);
    }

    private void writeToFile(String output, String fileName) throws FileNotFoundException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(writer);
            JOptionPane.showMessageDialog(null, "CSV file generated  : " + fileName);
        }
    }

    private void close(BufferedWriter writer) {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCommaSeperatedRow(Set<String> headers, Map<String, String> map) {
        List<String> items = new ArrayList<String>();
        for (String header : headers) {
            String value = map.get(header) == null ? "" : map.get(header).replace(",", "");
            items.add(value);
        }
        return StringUtils.join(items.toArray(), ",");
    }

    private Set<String> collectHeaders(List<Map<String, String>> flatJson) {
        Set<String> headers = new TreeSet<String>();
        for (Map<String, String> map : flatJson) {
            headers.addAll(map.keySet());
        }
        Iterator<String> iterator = headers.iterator();
    	
     
    	// Filtering column
    	while (iterator.hasNext()) {
    		if(!Arrays.asList(filterColumn).contains(iterator.next())){
    			iterator.remove();
    		}
    	}
        return headers;
    }
}