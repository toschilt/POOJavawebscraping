package local_database;

import java.io.IOException;
import java.util.ArrayList;
import module_exceptions.*;


public class RegistersHandler {
    
    private ArrayList<Register> registers;
    
    private static final String deathStatus = "Óbito";
    private static final String caseStatus = "Contaminado";
    private static final String vaccinatedStatus = "Vacinado";
    //Adicionar opção de doses?
    

    public RegistersHandler() throws CannotCreateDataFileException {
    	//Inicialização do arquivo
    	try { registers = DataFileHandler.loadDataFromExternalFile(); }
	    catch(Exception e) {
	    	//Arquivo de dados não existe
	    	registers = new ArrayList<Register>();
	    	
	    	try { DataFileHandler.createDataFile(); }
	    	catch(Exception q) { //Não foi possível criar arquivo de dados
	    		throw new CannotCreateDataFileException("Unable to create data file");
			}
		}
    }

    
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
    
    private boolean userExists(String name, String cpf) {
    	
    	for(Register register : registers) {
        	String nextName = register.getPersonalData().getFullName();
        	String nextCPF = register.getPersonalData().getCPF();
            
        	if(name.equals(nextName) || cpf.equals(nextCPF)) {
                return true;
            }
    	}
    	
    	return false;
    }
    

    public void registerNewCase(String[] data) throws RegisterExistsException, IOException {
    	
    	if(userExists(data[0], data[1])) {
    		throw new RegisterExistsException("Cadastro já existente");
    	}
    	
        Register newRegister = new Register(data);
        registers.add(newRegister);
        
        DataFileHandler.saveToExternalFile(data);
        
    }


    public String[] searchForCase(String identifier) throws PersonNotFoundException {
        
    	Register register = userExists(identifier);
    	if(register != null) {
    		return register.getPersonalData().getFullData();
    	}
        
        throw new PersonNotFoundException("Pessoa não encontrada");
    }


    public void updateInformation(String identifier, String updatedData) throws PersonNotFoundException {
        
        for(Register register : registers) {
        	String nextName = register.getPersonalData().getFullName();
        	String nextCPF = register.getPersonalData().getCPF();
            
        	if(identifier.equals(nextName) || identifier.equals(nextCPF)) {
                register.update(updatedData);
            }
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
