package module_interface;

import java.awt.Container;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WindowCasesAndDeaths
{
	//Janela atual
	private JFrame janela;
	
	//Layout da p�gina
	private SpringLayout layout;
	
	//Componente da p�gina (utilizando somente um para facilitar)
	private Container contentPane;
	
	//Tamanho horizontal da janela.
	private int xSize = 1200;
	
	//Tamanho vertical da janela.
	private int ySize = 700;
	
	//Offset horizontal entre os valores da primeira e da segunda coluna.
	private int horizontalDataOffsetValues = 500;
	
	//Offset vertical entre informa��es de uma linha para outra.
	private int vericalDataOffsetValues = 60;
	
	//Offset horizontal dos valores em rela��o ao lado esquerdo da janela.
	private int horizontalWindowOffsetValues = 150;
	
	//Offset vertical dos valores em rela��o � janela.
	private int verticalWindowOffsetValues = 330;
	
	//Fonte de todos os textos da tela.
	private String font = "Arial";
	
	//Tamanho da fonte do t�tulo principal.
	private int sizeMainTitleFont = 50;
	
	//Tamanho da fonte do subt�tulo principal.
	private int sizeSubTitleFont = 22;
	
	//Tamanho da fonte dos valores apresentados na tela.
	private int sizeValueFont = 20;
	
	//Tamanho da fonte do texto dos bot�es.
	private int sizeButtonFont = 25;

	private InfoSPSate info;
	
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	private void createMainTitleInScreen(String dataAtualizacao)
	{
		JLabel labelTitulo = new JLabel("Informa��es Casos e �bitos");
		labelTitulo.setFont(new Font(font, Font.BOLD, sizeMainTitleFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 50, SpringLayout.NORTH, contentPane);
		contentPane.add(labelTitulo);
		
		JLabel labelSubTitulo = new JLabel("Informa��es atualizadas em: " + dataAtualizacao);
		labelSubTitulo.setFont(new Font(font, Font.BOLD, sizeSubTitleFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelSubTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelSubTitulo, 65, SpringLayout.NORTH, labelTitulo);
		contentPane.add(labelSubTitulo);
	}
	
	/*
	 * Cria na tela o t�tulo da informa��o buscada e o seu correspondente valor
	 * levando em considera��o a linha e a coluna desejada.
	 */
	private void createInfoInScreen(String title, String value, int linha, int coluna)
	{
		JLabel labelTitle = new JLabel(title);
		labelTitle.setFont(new Font(font, Font.BOLD, sizeValueFont));
		layout.putConstraint(SpringLayout.WEST, labelTitle, horizontalWindowOffsetValues + (coluna - 1)*horizontalDataOffsetValues, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelTitle, verticalWindowOffsetValues + (linha - 1)*vericalDataOffsetValues, SpringLayout.NORTH, contentPane);
		contentPane.add(labelTitle);
		
		JLabel labelValue = new JLabel(value);
		labelValue.setFont(new Font(font, Font.PLAIN, sizeValueFont));
		layout.putConstraint(SpringLayout.WEST, labelValue, 0, SpringLayout.EAST, labelTitle);
		layout.putConstraint(SpringLayout.NORTH, labelValue, 0, SpringLayout.NORTH, labelTitle);
		contentPane.add(labelValue);
	}
	
	public WindowCasesAndDeaths()
	{
		String dataAtualizacao = getDateTime();
		this.janela = new JFrame("Informa��es da Vacina��o (at� " + dataAtualizacao + ")");
		
		janela.setSize(xSize, ySize);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = janela.getContentPane();
		this.layout = new SpringLayout();
		
		
		//T�TULO DA JANELA
		createMainTitleInScreen(dataAtualizacao);
		
		
		//MOSTRANDO OS VALORES!
		//TODO Mudar para obter valores do registro local

		String titleConfirmedCases = "Casos confirmados: ";
		String valueConfirmedCases;
		String titleDeaths = "�bitos: ";
		String valueDeaths;
		String titleIsolatingIndex = "�ndice de isolamento ";
		String valueIsolatingIndex;
		String titlePercentageVaccinated = "Porcentagem da popula��o vacinada: ";
		String valuePercentageVaccinated;
		String errorOccurred = "Nao foi possivel captar os dados";

		try{
			info = new InfoSPState();
			valueConfirmedCases = info.getConfirmedCases();
			valueDeaths = info.getConfirmedDeaths();
			valueIsolatingIndex = info.getIsolationPercentageState();
			valuePercentageVaccinated = info.getVaccinatedPercentage();
		}
		catch(WebScrappingException wse){
			valueConfirmedCases = errorOccurred;
			valueDeaths = errorOccurred;
			valueIsolatingIndex = errorOccurred;
			valuePercentageVaccinated = errorOccurred;
		}
		
		//PRIMEIRA COLUNA
		createInfoInScreen(titleConfirmedCases, valueConfirmedCases, 1, 1);
		createInfoInScreen(titleDeaths, valueDeaths, 2, 1);
		//SEGUNDA COLUNA
		createInfoInScreen(titleIsolatingIndex, valueIsolatingIndex, 1, 2);
		createInfoInScreen(titlePercentageVaccinated, valuePercentageVaccinated, 2, 2);
		
		
		//BOT�ES
		JButton buttonMainMenu = new JButton("Voltar ao menu principal");
		buttonMainMenu.setFont(new Font(font, Font.BOLD, sizeButtonFont));
		layout.putConstraint(SpringLayout.EAST, buttonMainMenu, -50, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, buttonMainMenu, -50, SpringLayout.SOUTH, contentPane);
		buttonMainMenu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new WindowMain();
		    	janela.setVisible(false);
		    	janela.dispose();
		    }
		});
		contentPane.add(buttonMainMenu);
		
		
		contentPane.setLayout(layout);
		janela.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new WindowCasesAndDeaths();
	}
}