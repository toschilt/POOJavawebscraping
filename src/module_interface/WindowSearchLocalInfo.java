package module_interface;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import local_database.RegistersHandler;
import module_exceptions.PersonNotFoundException;

public class WindowSearchLocalInfo  {

	//Janela atual
	private JFrame janela;
	
    public WindowSearchLocalInfo() {
        
        // criando as variaveis
    	this.janela = new JFrame("Visualização de Informações Locais");
    	
        Container contentPane = janela.getContentPane();
        SpringLayout layout = new SpringLayout();
        JLabel titulo = new JLabel("Visualização de Informações Locais");
        
        JButton buttonSearch = new JButton("Buscar");
        JButton buttonCancel = new JButton("Cancelar");
        
        JLabel labelName = new JLabel("Nome");
        JTextField name = new JTextField(40);
        
        JLabel labelCPF = new JLabel("CPF");
        JTextField cpf = new JTextField(20);

        // titulo
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, titulo, 50, SpringLayout.NORTH, contentPane);
        contentPane.add(titulo);
        janela.setSize(1200, 700);
        
        // campos de texto
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelName, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelName, 165 + 60, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, name, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, name, 165 + 60 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelCPF, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelCPF, 165 + 120, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, cpf, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, cpf, 165 + 120 + 20, SpringLayout.NORTH, contentPane);
        
        // botões
        buttonSearch.setFont(new Font("Arial", Font.BOLD, 25));
        buttonSearch.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	RegistersHandler reg = null;
        		
        		try {
        			reg = new RegistersHandler();
        		}
        		catch(Exception exc) {
        			new WindowError("Não é possível acessar as informações locais!");
        		}
		    	
		    	if(!cpf.getText().isEmpty())
		    	{
		    		try
		    		{
		    			String[] infos = reg.searchForCase(cpf.getText());
		    			
		    			janela.setVisible(false);
		    			new WindowShowLocalInfo(infos);
				    	janela.dispose();
		    		}
		    		catch(PersonNotFoundException exc)
		    		{
		    			new WindowError("Registro não encontrado!");
		    		}
		    	}
		    	else if(!name.getText().isEmpty())
		    	{
		    		try
		    		{
		    			String[] infos = reg.searchForCase(name.getText());
		    			
		    			janela.setVisible(false);
		    			new WindowShowLocalInfo(infos);
				    	janela.dispose();
		    		}
		    		catch(PersonNotFoundException exc)
		    		{
		    			new WindowError("Registro não encontrado!");
		    		}
		    	}
		    	else
		    	{
		    		new WindowError("Insira pelo menos uma chave de busca!");
		    	}
		    }
		});
        
        buttonCancel.setFont(new Font("Arial", Font.BOLD, 25));
        buttonCancel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	new WindowMain();
		    }
		});
        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonSearch, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonSearch, 450, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonCancel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonCancel, 500, SpringLayout.NORTH, contentPane);
        
        // adicionando ao painel
        contentPane.add(labelName);
        contentPane.add(name);
        contentPane.add(labelCPF);
        contentPane.add(cpf);
        contentPane.add(buttonSearch);
        contentPane.add(buttonCancel);
        contentPane.setLayout(layout);
        janela.setVisible(true); 
        
    } 
    
    public static void main(String[] args){
    	new WindowSearchLocalInfo();
    }
    
}
