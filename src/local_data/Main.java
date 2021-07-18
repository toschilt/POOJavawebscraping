package local_data;

public class Main {
    
    public static void main(String args[]) {
        
        RegistersHandler reg = new RegistersHandler();

        /*  O que quer fazer?
            - Buscar caso
            - Registrar
            - Atualizar informação
        */
        
        reg.registerNewCase(new String[] { "a", "b", "c", "d", "e", "f", "g" });
        reg.registerNewCase(new String[] { "asd", "asd", "asd", "sad", "asd", "sad", "asd" });
        
        String namer = new String();
        
        try { namer = reg.searchForCase("a"); }
        catch(Exception e) {}
        
        System.out.println(namer);
     
        
        System.out.println("Done!");
    }

}
