package module_interface;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WindowShowOnlineInfo  {
	
	//Janela atual
	private JFrame janela;

    public WindowShowOnlineInfo() {
        
        // criando as variaveis
    	janela = new JFrame("Visualização de Informações On-Line");
    	janela.setSize(1200, 700);
    	
        Container contentPane = janela.getContentPane();
        SpringLayout layout = new SpringLayout();
        
        JLabel titulo = new JLabel("Visualização de Informações On-Line");
        JLabel subTitulo = new JLabel("Estado de São Paulo - Brasil");
        
        JButton buttonVac = new JButton("Vacinação");
        buttonVac.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	new WindowVaccinationInfo();
		    }
		});
        
        JButton buttonCases = new JButton("Casos e Óbitos");
        buttonCases.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	new WindowCasesAndDeaths();
		    }
		});
        
        JButton buttonBack = new JButton("Voltar ao Menu Principal");
        buttonBack.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	new WindowMain();
		    }
		});

        // titulo
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, titulo, 50, SpringLayout.NORTH, contentPane);
        contentPane.add(titulo);
        
        //subtitulo
        subTitulo.setFont(new Font("Arial", Font.BOLD, 35));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, subTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, subTitulo, 120, SpringLayout.NORTH, contentPane);
		contentPane.add(subTitulo);
		
        
        // botões
        buttonVac.setFont(new Font("Arial", Font.BOLD, 25));
        buttonCases.setFont(new Font("Arial", Font.BOLD, 25));
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonVac, -200, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonVac, 300, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonCases, 200, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonCases, 300, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonBack, 300, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, buttonBack, 500, SpringLayout.NORTH, contentPane);
        
        // adicionando ao painel
        contentPane.add(buttonVac);
        contentPane.add(buttonCases);
        contentPane.add(buttonBack);
        contentPane.setLayout(layout);
        janela.setVisible(true); 
        
    } 
    
    public static void main(String[] args){
    	new WindowShowOnlineInfo();
    }
}
