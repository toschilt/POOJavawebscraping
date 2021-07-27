package local_database;

public class Register {
    
	//Pessoa relacionada ao registro
    Person personalInfo;

    //Construtores
    public Register(String type, String group, String fullName, String gender, String birth, String mothersName, String cpf) {
        personalInfo = new Person(type, group, fullName, gender, birth, mothersName, cpf);
    }

    public Register(String[] data) {
        personalInfo = new Person(data);
    }


    //Atualiza informações
    public void update(String[] newData) {
    	personalInfo.setFullName(newData[0]);
        personalInfo.setCPF(newData[1]);
        personalInfo.setGender(newData[2]);
        personalInfo.setStatus(newData[3]);
        personalInfo.setGroup(newData[4]);
        personalInfo.setBirth(newData[5]);
        personalInfo.setMother(newData[6]);
    }

    //Coleta informações do registro
    public Person getPersonalData() { return this.personalInfo; }

}
