package module_interface;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

public class WindowError {
	
	//Janela atual
	private JFrame janela;
	
	//Layout da p�gina
	private SpringLayout layout;
	
	//Componente da p�gina (utilizando somente um para facilitar)
	private Container contentPane;
	
	//Tamanho horizontal da janela.
	private int xSize = 600;
	
	//Tamanho vertical da janela.
	private int ySize = 250;
	
	//Fonte de todos os textos da tela.
	private String font = "Arial";
	
	//Tamanho da fonte do t�tulo principal.
	private int sizeMainTitleFont = 40;
	
	//Tamanho da fonte da descri��o do erro
	private int sizeDescriptionTextFont = 20;
	
	//Tamanho da fonte do texto dos bot�es.
	private int sizeButtonFont = 25;
	
	public WindowError(String errorDescription)
	{
		this.janela = new JFrame("Erro!");
		
		janela.setSize(xSize, ySize);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = janela.getContentPane();
		this.layout = new SpringLayout();
		
		//T�TULO DA JANELA
		JLabel labelTitulo = new JLabel("Erro!");
		labelTitulo.setFont(new Font(font, Font.BOLD, sizeMainTitleFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 25, SpringLayout.NORTH, contentPane);
		contentPane.add(labelTitulo);
		
		//DESCRI��O DO ERRO
		JLabel labelErrorDescription = new JLabel(errorDescription);
		labelErrorDescription.setFont(new Font(font, Font.PLAIN, sizeDescriptionTextFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelErrorDescription, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelErrorDescription, 70, SpringLayout.NORTH, labelTitulo);
		contentPane.add(labelErrorDescription);
		
		//BOT�ES
		JButton acceptErrorButton = new JButton("Fechar");
		acceptErrorButton.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, acceptErrorButton, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, acceptErrorButton, -20, SpringLayout.SOUTH, contentPane);
		acceptErrorButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    }
		});
		contentPane.add(acceptErrorButton);
		
		contentPane.setLayout(layout);
		janela.setVisible(true);
	}
	
	public WindowError(String errorDescription, String args)
	{
		this.janela = new JFrame("Erro!");
		
		janela.setSize(xSize, ySize);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = janela.getContentPane();
		this.layout = new SpringLayout();
		
		//T�TULO DA JANELA
		JLabel labelTitulo = new JLabel("Erro!");
		labelTitulo.setFont(new Font(font, Font.BOLD, sizeMainTitleFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 25, SpringLayout.NORTH, contentPane);
		contentPane.add(labelTitulo);
		
		//DESCRI��O DO ERRO
		JLabel labelErrorDescription = new JLabel(errorDescription);
		labelErrorDescription.setFont(new Font(font, Font.PLAIN, sizeDescriptionTextFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelErrorDescription, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelErrorDescription, 70, SpringLayout.NORTH, labelTitulo);
		contentPane.add(labelErrorDescription);
		
		JLabel labelSecondRow = new JLabel(args);
		labelSecondRow.setFont(new Font(font, Font.PLAIN, 16));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelSecondRow, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelSecondRow, 1, SpringLayout.SOUTH, labelErrorDescription);
		contentPane.add(labelSecondRow);
		
		//BOT�ES
		JButton acceptErrorButton = new JButton("Fechar");
		acceptErrorButton.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, acceptErrorButton, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, acceptErrorButton, -20, SpringLayout.SOUTH, contentPane);
		acceptErrorButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    }
		});
		contentPane.add(acceptErrorButton);
		
		contentPane.setLayout(layout);
		janela.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new WindowError("MENSAGEM DE ERRO TESTE!", "errolkaslkalka");
	}
}