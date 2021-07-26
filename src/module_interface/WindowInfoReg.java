package module_interface;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class WindowInfoReg extends JFrame  {

    public WindowInfoReg() {
        
        // criando as variaveis
        super("Cadastro de Informações");
        Container contentPane = this.getContentPane();
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
        this.setSize(1200, 700);
        
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
        buttonCancel.setFont(new Font("Arial", Font.BOLD, 25));
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonReg, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
	layout.putConstraint(SpringLayout.NORTH, buttonReg, 450, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonCancel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
	layout.putConstraint(SpringLayout.NORTH, buttonCancel, 500, SpringLayout.NORTH, contentPane);
        //buttonOK.addActionListener(this);
        //buttonLimpa.addActionListener(this);
        
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
        this.setVisible(true); 
        
    }  
    
    public static void main(String[] args){
	new WindowInfoReg();
    }
}
