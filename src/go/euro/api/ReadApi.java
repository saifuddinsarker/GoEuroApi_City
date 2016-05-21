/**
 * 
 */
package go.euro.api;

import java.lang.reflect.Array;

import javax.swing.JOptionPane;

/**
 * @author Md Saifuddin Sarker
 * url: www.saifuddin.info
 * 
 */
public class ReadApi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String CityName= "";
		for (int i=0;i<Array.getLength(args);i++){
			 CityName += (i==0) ?  args[i] :  " " + args[i];
		}
		
		if(ValidateInputString(CityName)){
			System.out.println("Getting result for : " + CityName);		
			String JsonString = null;
			// Getting Json String
			try{
				JsonString = ReadJsonFromUrl.ReadJson(CityName);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Could not retrieve Json");
			}
			// generate CSV
			try{
				GenerateCsv.GenerateCsvFromString(JsonString,CityName);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Could not generate CSV. Not enough data or invalid json");
			}
			
			
		}else{
			JOptionPane.showMessageDialog(null, "Invalid city name provided");
		}
		
	}
	
	public static boolean ValidateInputString(String city){
		if(city.isEmpty()){
			return false;
		}
		return city.matches("^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$");
	}

}
