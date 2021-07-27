package local_database;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataFileHandler {
	
	public static final String fileName = "LocalData.csv";
	public static final String SEPARATOR = ",";
	
	
	private DataFileHandler() {}
	
	public static ArrayList<Register> loadDataFromExternalFile() throws Exception {
    	
		//Carrega informações do arquivo CSV em memória
    	ArrayList<Register> registers = new ArrayList<Register>();
    	BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
    	
    	String row;
    	while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(SEPARATOR);
            registers.add(new Register(data));
        }
    	
    	csvReader.close();
    	return registers;
    }
    
    
    public static void createDataFile() throws IOException {	
    	try {
    		//Cria o arquivo CSV
    		FileWriter csvWriter = new FileWriter(fileName);
	
	    	csvWriter.append("FullName").append(SEPARATOR);
	    	csvWriter.append("CPF").append(SEPARATOR);
	    	csvWriter.append("Gender").append(SEPARATOR);
	    	csvWriter.append("Status").append(SEPARATOR);
	    	csvWriter.append("Group").append(SEPARATOR);
	    	csvWriter.append("Birth").append(SEPARATOR);
	    	csvWriter.append("MothersName").append("\n");
	
	    	csvWriter.flush();
	    	csvWriter.close();
    	
    	} catch(Exception e) { throw new IOException("Unable to create data file"); }
    }
    

    public static void saveToExternalFile(String[] data) throws IOException {

    	//Adiciona o novo registro no fim do arquvo CSV
    	FileWriter csvWriter = new FileWriter(fileName, true);

	    csvWriter.append(String.join(SEPARATOR, data));
	    csvWriter.append("\n");

    	csvWriter.flush();
    	csvWriter.close();
    }
    
    
    public static void updateDataInExternalFile(int row, String[] newData) throws IOException {
    	
    	//Atualiza uma certa linha do CSV
    	//Circula todas as linhas até encontrar o campo a ser atualizado
		String tempFile = "dump.txt";
		File oldFile = new File(fileName);
		File newFile = new File(tempFile);
		
		String[] nextData = new String[newData.length];
	
		FileWriter fw = new FileWriter(tempFile, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		Scanner scanner = new Scanner(new File(fileName));
		scanner.useDelimiter("[,\n]");
		
		while(scanner.hasNext()) {
			for(int i = 0; i < nextData.length; i++) {
				nextData[i] = scanner.next();
			}
			
			if(nextData[0].equals(newData[0]) || nextData[1].equals(newData[1])) {
				for(int i = 0; i < newData.length - 1; i++) {
					pw.printf(newData[i] + SEPARATOR);
				}
				pw.printf(newData[newData.length-1] + "\n");
			}
			
			else { 
				for(int i = 0; i < nextData.length - 1; i++) {
					pw.printf(nextData[i] + SEPARATOR);
				}
				pw.printf(nextData[nextData.length-1] + "\n");
			}
		}
		
		scanner.close();
		pw.flush();
		pw.close();
		oldFile.delete();
		File dump = new File(fileName);
		newFile.renameTo(dump);
    	
    }
    
}
