package module_interface;

import java.awt.Container;
import javax.swing.*;

import module_exceptions.WebScrappingException;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import module_info.InfoSPState;

public class WindowVaccinationInfo
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
	
	//Offset horizontal entre os valores da primeira e da segunda coluna.
	private int horizontalDataOffsetValues = 500;
	
	//Offset vertical entre informações de uma linha para outra.
	private int vericalDataOffsetValues = 60;
	
	//Offset horizontal dos valores em relação ao lado esquerdo da janela.
	private int horizontalWindowOffsetValues = 165;
	
	//Offset vertical dos valores em relação à janela.
	private int verticalWindowOffsetValues = 285;
	
	//Fonte de todos os textos da tela.
	private String font = "Arial";
	
	//Tamanho da fonte do título principal.
	private int sizeMainTitleFont = 50;
	
	//Tamanho da fonte do subtítulo principal.
	private int sizeSubTitleFont = 22;
	
	//Tamanho da fonte dos valores apresentados na tela.
	private int sizeValueFont = 20;
	
	//Tamanho da fonte do texto dos botões.
	private int sizeButtonFont = 25;
	
	private InfoSPState info;
	
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	private void createMainTitleInScreen(String dataAtualizacao)
	{
		JLabel labelTitulo = new JLabel("Informação Vacinação");
		labelTitulo.setFont(new Font(font, Font.BOLD, sizeMainTitleFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelTitulo, 50, SpringLayout.NORTH, contentPane);
		contentPane.add(labelTitulo);
		
		JLabel labelSubTitulo = new JLabel("Informações atualizadas em: " + dataAtualizacao);
		labelSubTitulo.setFont(new Font(font, Font.BOLD, sizeSubTitleFont));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelSubTitulo, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, labelSubTitulo, 65, SpringLayout.NORTH, labelTitulo);
		contentPane.add(labelSubTitulo);
	}
	
	/*
	 * Cria na tela o título da informação buscada e o seu correspondente valor
	 * levando em consideração a linha e a coluna desejada.
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
	
	public WindowVaccinationInfo()
	{
		String dataAtualizacao = getDateTime();
		this.janela = new JFrame("Informações da Vacinação (até " + dataAtualizacao + ")");
		
		janela.setSize(xSize, ySize);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = janela.getContentPane();
		this.layout = new SpringLayout();
		
		
		//TÍTULO DA JANELA
		createMainTitleInScreen(dataAtualizacao);
		
		String titleFirstDose = "Nº de primeiras doses: ";
		String valueFirstDose;
		String titleAppliedDose = "Doses Aplicadas: ";
		String valueAppliedDose;
		String titleSecondDose = "Nº de segundas doses: ";
		String valueSecondDose;
		String titleOnlyDose = "Nº de doses únicas: ";
		String valueOnlyDose;
		String titlePercentageVaccinated = "Porcentagem da população vacinada: ";
		String valuePercentageVaccinated;
		String errorOccurred = "Nao foi possivel captar os dados";
		
		try {
			info = new InfoSPState();
			valueFirstDose = info.getFirstDoseApplied();
			valueAppliedDose = info.getVaccineDosesApplied();
			valueSecondDose = info.getSecondDoseApplied();
			valueOnlyDose = info.getSingleDoseApplied();
			valuePercentageVaccinated = info.getVaccinatedPercentage();
		}
		catch(WebScrappingException wse) {
			valueFirstDose = errorOccurred;
			valueAppliedDose = errorOccurred;
			valueSecondDose = errorOccurred;
			valueOnlyDose = errorOccurred;
			valuePercentageVaccinated = errorOccurred;
			System.out.println(wse.getMessage());
		}

		createInfoInScreen(titleAppliedDose, valueAppliedDose, 1, 1);
		createInfoInScreen(titleFirstDose, valueFirstDose, 2, 1);
		createInfoInScreen(titleSecondDose, valueSecondDose, 3, 1);
		createInfoInScreen(titleOnlyDose, valueOnlyDose, 1, 2);
		createInfoInScreen(titlePercentageVaccinated, valuePercentageVaccinated, 2, 2);
		
		//BOTÕES
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
		new WindowVaccinationInfo();
	}
}
