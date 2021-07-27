package local_database;

public class Main {
    
    public static void main(String args[]) {

        try {
        	String[] newData = {"bACANa", "new", "sad", "ASd", "sadfsd", "grsgf", "sdfouiksdhiofus"};
			DataFileHandler.updateDataInExternalFile(2, newData);
			System.out.println("Updated!");
		} catch (Exception e) {
			return;
		}

    }

}
