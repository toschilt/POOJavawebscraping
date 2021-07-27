package module_interface;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import com.opencsv.exceptions.CsvException;

import local_database.RegistersHandler;
import module_exceptions.PersonNotFoundException;
import module_exceptions.RegisterExistsException;

public class WindowInfoReg  {

	//Janela atual
	private JFrame janela;
	
    public WindowInfoReg() {
        
        // criando as variaveis
    	this.janela = new JFrame("Cadastro de Informações");

        Container contentPane = janela.getContentPane();
        SpringLayout layout = new SpringLayout();
        JLabel titulo = new JLabel("Cadastro de Informações");
        
        JButton buttonReg = new JButton("Cadastrar");
        JButton buttonCancel = new JButton("Cancelar");
        
        JLabel labelCaseType = new JLabel("Tipo de Caso");
        JTextField caseType = new JTextField(20);
        
        JLabel labelName = new JLabel("Nome");
        JTextField name = new JTextField(40);
        
        JLabel labelGender = new JLabel("Sexo");
        JTextField gender = new JTextField(20);
        
        JLabel labelCPF = new JLabel("CPF");
        JTextField cpf = new JTextField(20);
        
        JLabel labelbirthDate = new JLabel("Data de Nascimento");
        JTextField birthDate = new JTextField(20);
        
        JLabel labelattGroup = new JLabel("Grupo de Atendimento");
        JTextField attGroup = new JTextField(20);
        
        JLabel labelmotherName = new JLabel("Nome da Mãe");
        JTextField motherName = new JTextField(40);

        // titulo
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, titulo, 50, SpringLayout.NORTH, contentPane);
        contentPane.add(titulo);
        janela.setSize(1200, 700);
        
        // campos de texto
        layout.putConstraint(SpringLayout.WEST, labelCaseType, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelCaseType, 165, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, caseType, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, caseType, 165 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelName, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelName, 165 + 60, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, name, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, name, 165 + 60 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelGender, 100 + 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelGender, 165 + 60, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, gender, 100 + 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, gender, 165 + 60 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelCPF, 100 + 800, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelCPF, 165 + 60, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, cpf, 100 + 800, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, cpf, 165 + 60 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelbirthDate, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelbirthDate, 165 + 120, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, birthDate, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, birthDate, 165 + 120 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelattGroup, 100 + 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelattGroup, 165 + 120, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, attGroup, 100 + 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, attGroup, 165 + 120 + 20, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST, labelmotherName, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelmotherName, 165 + 180, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, motherName, 100, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, motherName, 165 + 180 + 20, SpringLayout.NORTH, contentPane);
        
        // botões
        buttonReg.setFont(new Font("Arial", Font.BOLD, 25));
        buttonReg.addActionListener(new ActionListener() {
		    
        	@Override
		    public void actionPerformed(ActionEvent e) {
        		RegistersHandler reg = null;
        		
        		try {
        			reg = new RegistersHandler();
        		}
        		catch(Exception exc) {
        			new WindowError("Não é possível acessar as informações locais!");
        		}
		    	
		    	String[] infos = new String[7];
		    	infos[0] = name.getText();
		    	infos[1] = cpf.getText();
		    	infos[2] = gender.getText();
		    	infos[3] = caseType.getText();
		    	infos[4] = attGroup.getText();
		    	infos[5] = birthDate.getText();
		    	infos[6] = motherName.getText();
		    	
		    	boolean algumCampoVazio = false;
		    	for(int i = 0; i < infos.length; i++)
		    	{
		    		if(infos[i].isEmpty())
		    		{
		    			algumCampoVazio = true;
		    		}
		    	}
		    	
		    	
		    	if(algumCampoVazio)
		    	{
		    		new WindowError("Preencha todos os campos!");
		    	}
		    	else
		    	{
		    		try {
			    		reg.registerNewCase(infos);
			    		
			    		janela.setVisible(false);
			    		janela.dispose();
			    		new WindowSucess("Cadastro realizado com sucesso!");
			    		
			    	}
		    		catch(IOException ioExc)
		    		{
		    			new WindowError("Não é possível acessar as informações locais!");
		    		}
			    	catch(RegisterExistsException existExc) {
		                Object[] options = {"Sim", "Não", "Cancelar"};
		                JOptionPane op = new JOptionPane();
		                op.setSize(600, 300);
		                int input = JOptionPane.showOptionDialog(null, "Atualizar Cadastro?", "Atenção!", JOptionPane.YES_NO_CANCEL_OPTION,
		                            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		                switch (input) {
		                    case JOptionPane.OK_OPTION:
								try {
									reg.updateInformation(infos);
									janela.setVisible(false);
						    		janela.dispose();
									new WindowSucess("Atualizado com sucesso!");
								} catch (Exception InfoExc) {
									new WindowError("Não é possível acessar as informações locais!");
								}                	
		                        break;
		                    case JOptionPane.CANCEL_OPTION:
		                        op.setVisible(false);
		                        break;
		                    default:
		                    	op.setVisible(false);
		                    	janela.setVisible(false);
		                    	janela.dispose();
		                    	new WindowMain();
		                        break;
		                }
			    	}
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
        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonReg, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonReg, 450, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonCancel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonCancel, 500, SpringLayout.NORTH, contentPane);
        
        // adicionando ao painel
        contentPane.add(labelCaseType);
        contentPane.add(caseType);
        contentPane.add(labelName);
        contentPane.add(name);
        contentPane.add(labelGender);
        contentPane.add(gender);
        contentPane.add(labelCPF);
        contentPane.add(cpf);
        contentPane.add(labelbirthDate);
        contentPane.add(birthDate);
        contentPane.add(labelattGroup);
        contentPane.add(attGroup);
        contentPane.add(labelmotherName);
        contentPane.add(motherName);
        contentPane.add(buttonReg);
        contentPane.add(buttonCancel);
        contentPane.setLayout(layout);
        janela.setVisible(true); 
    }  
    
    public static void main(String[] args){
    	new WindowInfoReg();
    }
}
