package local_database;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

import module_exceptions.*;


public class RegistersHandler {
    
    private ArrayList<Register> registers;
    
    //Defines para o nome de cada "status"
    private static final String deathStatus = "Óbito";
    private static final String caseStatus = "Contaminado";
    private static final String vaccinatedStatus = "Vacinado";
    

    //Construtor
    public RegistersHandler() throws CannotCreateDataFileException {
    	//Inicializa��o do arquivo
    	try { registers = DataFileHandler.loadDataFromExternalFile(); }
	    catch(Exception e) {
	    	//Arquivo de dados não existe
	    	registers = new ArrayList<Register>();
	    	
	    	try { DataFileHandler.createDataFile(); }
	    	catch(Exception q) { //N�o foi poss�vel criar arquivo de dados
	    		throw new CannotCreateDataFileException("Unable to create data file");
			}
		}
    }

    
    //Verifica se um usuário já existe com base em um identificador (nome ou CPF)
    private Register userExists(String identifier) {
    	for(Register register : registers) {
        	
    		String nextName = register.getPersonalData().getFullName();
        	String nextCPF = register.getPersonalData().getCPF();
        	
        	if(identifier.equals(nextName) || identifier.equals(nextCPF)) {
                return register;
            }
    	}
    	return null;
    }
    
    //Verifica se um usuário já existe com base no nome e CPF
    private Register userExists(String name, String cpf) {
    	for(Register register : registers) {
        	String nextName = register.getPersonalData().getFullName();
        	String nextCPF = register.getPersonalData().getCPF();
            
        	if(name.equals(nextName) || cpf.equals(nextCPF)) {
                return register;
            }
    	}
    	return null;
    }
    
    //Verifica se um usuário já existe com base no nome e CPF, retornando o índice deste nos registros
    private int userExists(String name, String cpf, boolean index) {
    	for(Register register : registers) {
        	String nextName = register.getPersonalData().getFullName();
        	String nextCPF = register.getPersonalData().getCPF();
            
        	if(name.equals(nextName) || cpf.equals(nextCPF)) {
                return registers.indexOf(register);
            }
    	}
    	return -1;
    }
    
 
    public void registerNewCase(String[] data) throws RegisterExistsException, IOException {
    	//Checa se um usuário com essas informações já existe
    	if(userExists(data[0], data[1]) != null) {
    		//Em caso afirmativo, retorna uma excessão
    		throw new RegisterExistsException("Cadastro já existente");
    	}
    	
    	//Registra o novo usuário e salva no CSV
        Register newRegister = new Register(data);
        registers.add(newRegister);
        
        DataFileHandler.saveToExternalFile(data);
    }


    public String[] searchForCase(String identifier) throws PersonNotFoundException {
    	
    	//Verifica se o registro já existe
    	Register register = userExists(identifier);
    	if(register != null) {
    		//Caso exista, retorna um vetor de String com as informações
    		return register.getPersonalData().getFullData();
    	}
        
    	//Caso contrário, lança uma nova excessão
        throw new PersonNotFoundException("Pessoa não encontrada");
    }


    public void updateInformation(String[] updatedData) throws PersonNotFoundException, IOException, CsvException {
        
    	int registerIndex = userExists(updatedData[0], updatedData[1], true);
    	System.out.println(registerIndex + "");
    	
    	if(registerIndex != -1) {
    		Register registerToUpdate = registers.get(registerIndex);
    		registerToUpdate.update(updatedData);
    		DataFileHandler.updateDataInExternalFile(registerIndex, updatedData);
    		return;
    	}
        
        throw new PersonNotFoundException("Pessoa não encontrada");
    }
    
    
    public int getDeaths() {
    	int deaths = 0;
    	for(Register register : registers) {
    		if(register.getPersonalData().getStatus().equals(deathStatus)) {
    			deaths++;
    		}
    	}
    	return deaths;
    }
    
    public int getCases() {
    	int cases = 0;
    	for(Register register : registers) {
    		if(register.getPersonalData().getStatus().equals(caseStatus)) { cases++; }
    	}
    	return cases;
    }
    
    public int getVaccinated() {
    	int vaccinated = 0;
    	for(Register register : registers) {
    		if(register.getPersonalData().getStatus().equals(vaccinatedStatus)) { vaccinated++; }
    	}
    	return vaccinated;
    }
    
}
