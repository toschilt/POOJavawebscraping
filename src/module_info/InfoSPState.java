package module_info;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import module_exceptions.WebScrappingException;

public class InfoSPState extends Info {
	private static final String SITEVACCINES = "https://vacinaja.sp.gov.br/";
	private static final String SITEDATA = "https://www.saopaulo.sp.gov.br/coronavirus/";
	
	protected String adultsWithFirstDosePercentage, totalPopulationWithFirstDosePercentage, totalInvested;

	private static final String XPATHVACCINES[] = {
			"/html/body/section[3]/div/div/div[2]/div[1]/div/div",
			"/html/body/section[3]/div/div/div[2]/div[2]/div[1]/div[1]/p[1]",
			"/html/body/section[3]/div/div/div[2]/div[2]/div[1]/div[2]/p[1]",
			"/html/body/section[3]/div/div/div[2]/div[2]/div[1]/div[3]/p[1]",
			"/html/body/section[3]/div/div/div[2]/div[3]/h3",
			"/html/body/section[3]/div/div/div[2]/div[4]/h3",
			"/html/body/section[3]/div/div/div[2]/div[5]/h3",
	};
	
	private static final String XPATHDATA[] = {
			"/html/body/section[5]/div/div/div[1]/div[2]/div[1]/p[2]",
			"/html/body/section[5]/div/div/div[1]/div[2]/div[2]/p[2]",
			"/html/body/section[5]/div/div/div[3]/div[2]/div/p[2]",
			"/html/body/section[5]/div/div/div[3]/div[2]/div/p[3]",
	};
	
	private static final String XPATHCALENDAR[] = {
			"//div[contains(@class, 'col-4 col-accordion-Crono col-data')]",
			"//div[contains(@class, 'col-8 col-accordion-Crono flex-fill col-grupo')]",
	};
		
	public static void main(String args[]) {
		try {
			InfoSPState sp = new InfoSPState();
			System.out.println(sp.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public InfoSPState() throws WebScrappingException{
		try {
			HtmlPage pageVaccines = getPage(SITEVACCINES);
			List<HtmlElement> listInfoVaccines = getHtmlDivisionFromXPATH(pageVaccines, XPATHVACCINES);
			List<HtmlElement> listInfoCalendar = getHtmlDivisionFromXPATH(pageVaccines, XPATHCALENDAR);			
			HtmlPage pageData = getPage(SITEDATA);
			List<HtmlElement> listInfoData = getHtmlDivisionFromXPATH(pageData, XPATHDATA);

			this.vaccineDosesApplied = convertHtmlElementToString(listInfoVaccines.remove(0));
			this.firstDoseApplied = convertHtmlElementToString(listInfoVaccines.remove(0));
			this.secondDoseApplied = convertHtmlElementToString(listInfoVaccines.remove(0));
			this.singleDoseApplied = convertHtmlElementToString(listInfoVaccines.remove(0));
			this.adultsWithFirstDosePercentage = convertHtmlElementToString(listInfoVaccines.remove(0));
			this.totalPopulationWithFirstDosePercentage = convertHtmlElementToString(listInfoVaccines.remove(0));
			this.totalVaccinatedPercentage = convertHtmlElementToString(listInfoVaccines.remove(0));
			this.confirmedCases = convertHtmlElementToString(listInfoData.remove(0));
			this.confirmedDeaths = convertHtmlElementToString(listInfoData.remove(0));
			this.totalInvested = convertHtmlElementToString(listInfoData.remove(0)) + " " + convertHtmlElementToString(listInfoData.remove(0));
			
			// TODO - someday (maybe never) I will update this piece of code
			this.vaccineCalendar = new ArrayList<String>();
			for(HtmlElement element : listInfoCalendar) {
				this.vaccineCalendar.add(convertHtmlElementToString(element));
			}
		}
		catch(Exception e) {
			throw new WebScrappingException(e.getMessage(), e.getCause());
		}
	}
	
	private HtmlPage getPage(String url) throws WebScrappingException {
		try(WebClient client = new WebClient()){
			client.getOptions().setJavaScriptEnabled(false);
			client.getOptions().setCssEnabled(false);
			client.getOptions().setUseInsecureSSL(true);
			HtmlPage page = client.getPage(url);
			return page;
		}
		catch(Exception e) {
			throw new WebScrappingException(e.getMessage());
		}
	}
	
	private List<HtmlElement> getHtmlDivisionFromXPATH(HtmlPage page, String arrayXPATH[]){
		List<HtmlElement> htmlDivision = new ArrayList<HtmlElement>();
		for(String xpath : arrayXPATH) {
			for(Object element : page.getByXPath(xpath)) {
				htmlDivision.add((HtmlElement) element);
			}
		}
		return htmlDivision;
	}
	
	private String convertHtmlElementToString(HtmlElement element) {
		return element.asNormalizedText();
	}
	
	@Override
	public String toString() {
		return 	"\nPercentage vaccinated: " + this.totalVaccinatedPercentage + 
				"\nTotal doses: " + this.vaccineDosesApplied + 
				"\nFirst doses applied: " + this.firstDoseApplied + 
				"\nSecond doses applied: " + this.secondDoseApplied + 
				"\nSingle doses appllied: " + this.singleDoseApplied + 
				"\nConfirmed cases: " + this.confirmedCases + 
				"\nConfirmed deaths: " + this.confirmedDeaths +
				"\nTotal invested: " + this.totalInvested;
	}

	@Override
	public String getConfirmedCases() {
		return this.confirmedCases;
	}

	@Override
	public String getConfirmedDeaths() {
		return this.confirmedDeaths;
	}

	@Override
	public String getVaccineDosesApplied() {
		return this.vaccineDosesApplied;
	}

	@Override
	public String getFirstDoseApplied() {
		return this.firstDoseApplied;
	}

	@Override
	public String getSecondDoseApplied() {
		return this.secondDoseApplied;
	}

	@Override
	public String getSingleDoseApplied() {
		return this.singleDoseApplied;
	}

	@Override
	public String getVaccinatedPercentage() {
		return this.totalVaccinatedPercentage;
	}

	@Override
	public List<String> getVaccineCalendar() {
		return this.vaccineCalendar;
	}

	@Override
	public int getConfirmedCasesToInt() {
		return Integer.parseInt(this.confirmedCases.replace(".", ""));
	}

	@Override
	public int getConfirmedDeathsToInt() {
		return Integer.parseInt(this.confirmedDeaths.replace(".", ""));
	}

	@Override
	public int getVaccineDosesAppliedToInt() {
		return Integer.parseInt(this.vaccineDosesApplied.replace(".", ""));
	}

	@Override
	public int getFirstDoseAppliedToInt() {
		return Integer.parseInt(this.firstDoseApplied.replace(".", ""));
	}

	@Override
	public int getSecondDoseAppliedToInt() {
		return Integer.parseInt(this.secondDoseApplied.replace(".", ""));
	}

	@Override
	public int getSingleDoseAppliedToInt() {
		return Integer.parseInt(this.singleDoseApplied.replace(".", ""));
	}

	@Override
	public float getVaccinatedPercentageToFloat() {
		return Float.parseFloat(this.totalVaccinatedPercentage.replace(",", "."));
	}
	
	public String getAdultsWithFirstDosePercentage() {
		return adultsWithFirstDosePercentage;
	}

	public String getTotalPopulationWithFirstDosePercentage() {
		return totalPopulationWithFirstDosePercentage;
	}

	public float getAdultsWithFirstDosePercentageToFloat() {
		return Float.parseFloat(adultsWithFirstDosePercentage.replace(",", "."));
	}
	
	public float getTotalPopulationWithFirstDosePercentageToFloat() {
		return Float.parseFloat(totalPopulationWithFirstDosePercentage.replace(",", "."));
	}
}
