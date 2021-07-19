package local_database;

public class Main {
    
    public static void main(String args[]) {
        
        RegistersHandler reg = new RegistersHandler();

        /*  
			TODO Não permitir casos duplicados
			Casos duplicados atualizam o database
        */
        
        reg.registerNewCase(new String[] { "a", "b", "c", "d", "e", "j", "k" });
        reg.registerNewCase(new String[] { "asd", "asd", "asd", "sad", "asd", "sad", "asd" });
        
        String namer = new String();
        
        try { namer = reg.searchForCase("a"); }
        catch(Exception e) {}
        
        System.out.println(namer);
     
        
        System.out.println("Done!");
    }

}
