package local_data;

public class Register {
    
    Person personalInfo;

    public Register(String type, String group, String fullName, String gender, String birth, String mothersName, String cpf) {
        personalInfo = new Person(type, group, fullName, gender, birth, mothersName, cpf);
    }

    public Register(String[] data) {
        personalInfo = new Person(data);
    }


    public void update(String updateCSV) {
        //Atualizar informações do objeto com base na string
    	//Ver se realmente é necessário
    }

    public Person getPersonalData() { return this.personalInfo; }

}
