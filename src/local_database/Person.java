package local_database;

public class Person {
    
    private String fullName, cpf;
    private String status, group;
    private String gender, birth, mothersName;

    public Person(String status, String group, String fullName, 
    		String gender, String birth, String mothersName, String cpf) {
        this.status = status;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.birth = birth;
        this.mothersName = mothersName;
        this.cpf = cpf;
    }

    
    public Person(String[] data) {
    	this.fullName = data[0];
    	this.cpf = data[1];
    	this.gender = data[2];
    	this.status = data[3];
    	this.group = data[4];
    	this.birth = data[5];
    	this.mothersName = data[6];
    }
    
    
    @Override
    public String toString() {
        //String contendo as informações de person, separar em formato CSV
        StringBuilder s = new StringBuilder();
        s.append("information {\n");
        s.append("\tName: " + getFullName() + "\n");
        s.append("\tCPF: " + getCPF() + "\n");
        s.append("\tStatus: " + getStatus() + "\n");
        s.append("\tGroup: " + getGroup() + "\n");
        s.append("\tGender: " + getGender() + "\n");
        s.append("\tBirth: " + getBirth() + "\n");
        s.append("\tMother: " + getMother() + "\n");
        s.append("}");
        return s.toString();
    }

    //Getters
	public String getCPF() 		{ return this.cpf; }
	public String getFullName() { return this.fullName; }
	public String getStatus() 	{ return this.status; }
	public String getGroup() 	{ return this.group; }
	public String getGender() 	{ return this.gender; }
	public String getBirth() 	{ return this.birth; }
	public String getMother() 	{ return this.mothersName; }
	
	//Setters
	public void setFullName(String fullName) { this.fullName = fullName; }
	public void setCPF(String cpf) { this.cpf = cpf; }
	public void setStatus(String status) { this.status = status; }
	public void setGroup(String group) { this.group = group; }
	public void setGender(String gender) { this.gender = gender; }
	public void getBirth(String birth) { this.birth = birth; }
	public void getMother(String mothersName) { this.mothersName = mothersName; }

}
