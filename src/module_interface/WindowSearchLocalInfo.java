package module_interface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class WindowSearchLocalInfo extends JFrame  {

    public WindowSearchLocalInfo() {
        
        // criando as variaveis
        super("Visualização de Informações Locais");
        Container contentPane = this.getContentPane();
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
        this.setSize(1200, 700);
        
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
        buttonCancel.setFont(new Font("Arial", Font.BOLD, 25));
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonSearch, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
	layout.putConstraint(SpringLayout.NORTH, buttonSearch, 450, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonCancel, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
	layout.putConstraint(SpringLayout.NORTH, buttonCancel, 500, SpringLayout.NORTH, contentPane);
        //buttonSearch.addActionListener(this);
        //buttonCancel.addActionListener(this);
        
        // adicionando ao painel
        contentPane.add(labelName);
        contentPane.add(name);
        contentPane.add(labelCPF);
        contentPane.add(cpf);
        contentPane.add(buttonSearch);
        contentPane.add(buttonCancel);
        contentPane.setLayout(layout);
        this.setVisible(true); 
        
    } 
    
    public static void main(String[] args){
	new WindowSearchLocalInfo();
    }
    
}
