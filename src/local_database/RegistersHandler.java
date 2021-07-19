package local_database;

import java.util.ArrayList;
import module_exceptions.*;


public class RegistersHandler {
    
    private ArrayList<Register> registers;
    
    private static final String deathStatus = "Óbito";
    private static final String caseStatus = "Contaminado";
    private static final String vaccinatedStatus = "Vacinado";
    //Adicionar opção de doses?
    

    public RegistersHandler() {
    	//Inicialização do arquivo
    	try { registers = DataFileHandler.loadDataFromExternalFile(); }
	    catch(Exception e) {
	    	//Arquivo de dados não existe
	    	registers = new ArrayList<Register>();
	    	
	    	try { DataFileHandler.createDataFile(); }
	    	catch(Exception q) { //Não foi possível criar arquivo de dados
	    		//Envia uma excessão que encerra o programa
			}
		}
    }


    public void registerNewCase(String[] data) {
    	
        Register newRegister = new Register(data);
        registers.add(newRegister);
        
        try { DataFileHandler.saveToExternalFile(data); }
        
        //Adicionar excessão para problema com arquivo de dados
        catch(Exception e) { return; }
    }


    public String searchForCase(String identifier) throws PersonNotFoundException {
        
        for(Register register : registers) {
        	String nextName = register.getPersonalData().getFullName();
        	String nextCPF = register.getPersonalData().getCPF();
            
        	if(identifier.equals(nextName) || identifier.equals(nextCPF)) {
                return register.getPersonalData().toString();
            }
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
