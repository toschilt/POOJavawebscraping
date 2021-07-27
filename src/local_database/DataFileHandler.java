package local_database;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataFileHandler {
	
	public static final String fileName = "LocalData.csv";
	
	
	private DataFileHandler() {}
	
	public static ArrayList<Register> loadDataFromExternalFile() throws Exception {
    	
    	ArrayList<Register> registers = new ArrayList<Register>();
    	BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
    	
    	String row;
    	while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            registers.add(new Register(data));
        }
    	
    	csvReader.close();
    	return registers;
    }
    
    
    public static void createDataFile() throws IOException {	
    	try {
	    	FileWriter csvWriter = new FileWriter(fileName);
	
	    	csvWriter.append("FullName").append(",");
	    	csvWriter.append("CPF").append(",");
	    	csvWriter.append("Gender").append(",");
	    	csvWriter.append("Status").append(",");
	    	csvWriter.append("Group").append(",");
	    	csvWriter.append("Birth").append(",");
	    	csvWriter.append("MothersName").append("\n");
	
	    	csvWriter.flush();
	    	csvWriter.close();
    	
    	} catch(Exception e) { throw new IOException("Unable to create data file"); }
    }
    

    public static void saveToExternalFile(String[] data) throws IOException {

    	FileWriter csvWriter = new FileWriter(fileName, true);

	    csvWriter.append(String.join(",", data));
	    csvWriter.append("\n");

    	csvWriter.flush();
    	csvWriter.close();
    }
    
    
    public static void updateDataInExternalFile(int row, String[] newData) throws IOException, CsvException {
    	
    	File dataFile = new File(fileName);
    	CSVReader csvReader = new CSVReader(new FileReader(dataFile));
    	List<String[]> csvBody = csvReader.readAll();
    	
    	for(int i = 0; i < newData.length; i++) {
    		csvBody.get(row)[i] = newData[i];
    	}
    	csvReader.close();
    	
    	CSVWriter csvWriter = new CSVWriter(new FileWriter(dataFile));
    	csvWriter.writeAll(csvBody);
    	csvWriter.flush();
    	csvWriter.close();
    }
    
}
