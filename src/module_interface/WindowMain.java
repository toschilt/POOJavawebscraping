package module_interface;

import java.awt.Container;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowMain
{
	//Janela atual
	private JFrame janela;
	
	//Layout da página
	private SpringLayout layout;
	
	//Componente da página (utilizando somente um para facilitar)
	private Container contentPane;
	
	//Tamanho horizontal da janela.
	private int xSize = 1200;
	
	//Tamanho vertical da janela.
	private int ySize = 700;
	
	//Offset vertical dos valores em relação à janela.
	private int verticalWindowOffsetValues = 175;
	
	//Offset vertical entre botões.
	private int verticalButtonOffsetValues = 120;
	
	//Fonte de todos os textos da tela.
	private String font = "Arial";
	
	//Tamanho da fonte do título principal.
	private int sizeMainTitleFont = 50;
	
	//Tamanho da fonte do texto dos botões.
	private int sizeButtonFont = 25;
	
	/*
	 * Cria o título principal na tela.
	 */
	private void createMainTitleInScreen()
	{
		JLabel labelTitulo = new JLabel("Consulta COVID-19");
		labelTitulo.setFont(new Font(font, Font.BOLD, sizeMainTitleFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 50, SpringLayout.NORTH, contentPane);
		contentPane.add(labelTitulo);
	}
	
	public WindowMain()
	{
		this.janela = new JFrame("Consulta COVID-19");
		
		janela.setSize(xSize, ySize);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = janela.getContentPane();
		this.layout = new SpringLayout();
		
		
		//TÍTULO DA JANELA
		createMainTitleInScreen();
		
		//BOTÕES
		JButton buttonInfoRegister = new JButton("Cadastrar informações");
		buttonInfoRegister.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonInfoRegister, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, buttonInfoRegister, verticalWindowOffsetValues + 0*verticalButtonOffsetValues, SpringLayout.NORTH, contentPane);
		buttonInfoRegister.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	//TODO colocar o new Página() aqui!
		    }
		});
		contentPane.add(buttonInfoRegister);
		
		JButton buttonToViewLocalInfo = new JButton("Visualizar informações locais");
		buttonToViewLocalInfo.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonToViewLocalInfo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, buttonToViewLocalInfo, verticalWindowOffsetValues + 1*verticalButtonOffsetValues, SpringLayout.NORTH, contentPane);
		buttonToViewLocalInfo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	//TODO colocar o new Página() aqui!
		    }
		});
		contentPane.add(buttonToViewLocalInfo);
		
		JButton buttonSearchOnLineInfo = new JButton("Buscar informações on-line");
		buttonSearchOnLineInfo.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonSearchOnLineInfo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, buttonSearchOnLineInfo, verticalWindowOffsetValues + 2*verticalButtonOffsetValues, SpringLayout.NORTH, contentPane);
		buttonSearchOnLineInfo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    	//TODO colocar o new Página() aqui!
		    }
		});
		contentPane.add(buttonSearchOnLineInfo);
		
		JButton buttonQuit = new JButton("Sair");
		buttonQuit.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonQuit, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, buttonQuit, verticalWindowOffsetValues + 3*verticalButtonOffsetValues, SpringLayout.NORTH, contentPane);
		buttonQuit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	janela.setVisible(false);
		    	janela.dispose();
		    }
		});
		contentPane.add(buttonQuit);
		
		contentPane.setLayout(layout);
		janela.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new WindowMain();
	}
}