package module_interface;

import java.awt.Container;
import java.awt.Font;
import javax.swing.*;

public class WindowShowOnlineInfo extends JFrame  {

    public WindowShowOnlineInfo() {
        
        // criando as variaveis
        super("Visualização de Informações Locais");
        Container contentPane = this.getContentPane();
        SpringLayout layout = new SpringLayout();
        JLabel titulo = new JLabel("Visualização de Informações On-Line");
        
        JButton buttonVac = new JButton("Vacinação");
        JButton buttonCases = new JButton("Casos e Óbitos");
        JButton buttonBack = new JButton("Voltar ao Menu Principal");

        // titulo
	titulo.setFont(new Font("Arial", Font.BOLD, 50));
	layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
	layout.putConstraint(SpringLayout.NORTH, titulo, 50, SpringLayout.NORTH, contentPane);
        contentPane.add(titulo);
        this.setSize(1200, 700);
        
        // botões
        buttonVac.setFont(new Font("Arial", Font.BOLD, 25));
        buttonCases.setFont(new Font("Arial", Font.BOLD, 25));
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonVac, -200, SpringLayout.HORIZONTAL_CENTER, contentPane);
	layout.putConstraint(SpringLayout.NORTH, buttonVac, 300, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonCases, 200, SpringLayout.HORIZONTAL_CENTER, contentPane);
	layout.putConstraint(SpringLayout.NORTH, buttonCases, 300, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonBack, 300, SpringLayout.HORIZONTAL_CENTER, contentPane);
	layout.putConstraint(SpringLayout.NORTH, buttonBack, 500, SpringLayout.NORTH, contentPane);
        //buttonVac.addActionListener(this);
        //buttonCases.addActionListener(this);
        
        // adicionando ao painel
        contentPane.add(buttonVac);
        contentPane.add(buttonCases);
        contentPane.add(buttonBack);
        contentPane.setLayout(layout);
        this.setVisible(true); 
        
    } 
    
    public static void main(String[] args){
	new WindowShowOnlineInfo();
    }
}
