package module_info;

//import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import module_exceptions.WebScrappingException;

public class InfoSPState extends Info {
	private HtmlPage page;
	private String siteInfo[];
	private static final String SITEVACCINES = "https://vacinaja.sp.gov.br/";
	private static final String SITEDATA = "https://www.saopaulo.sp.gov.br/coronavirus/";
	private static final String XPATHCLASS_VACCINES = "//div[contains(@class, 'row row-new-vacinometro')]";
	private static final String XPATHCLASS_DATA = "//div[contains(@class, 'row quadros-protocolos quadros-home')]";
	//private static final String XPATHCLASS_CALENDAR = "//div[contains(@class, 'accordion cronograma-vacina')]";
	
	protected String updatedDate, updatedTime, vaccinatedPercentage;
	protected float investedValue;
	
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
	
	private InfoSPState() throws WebScrappingException, NullPointerException, IndexOutOfBoundsException, PatternSyntaxException, NumberFormatException {
		this.page = getHTMLPAGE(SITEVACCINES);
		siteInfo = getInfoFromXPATHClass(page, XPATHCLASS_VACCINES);
		this.updatedDate = siteInfo[3];
		this.updatedTime = siteInfo[4];
		this.vaccinatedPercentage = siteInfo[5];
		this.vaccineDosesApplied = Integer.parseInt(siteInfo[17].replace(".", ""));
		this.firstDoseApplied = Integer.parseInt(siteInfo[18].replace(".", ""));
		this.secondDoseApplied = Integer.parseInt(siteInfo[21].replace(".", ""));
		this.singleDoseApplied = Integer.parseInt(siteInfo[24].replace(".", ""));
		
		//TODO getCalendar
		//this.vaccineCalendar = getCalendarFromXPATHClass(page, XPATHCLASS_CALENDAR);
		/*for(String s : siteInfo) {
			System.out.println(s);
		}*/
		
		this.page = getHTMLPAGE(SITEDATA);
		siteInfo = getInfoFromXPATHClass(page, XPATHCLASS_DATA);
		this.confirmedCases = Integer.parseInt(siteInfo[5].replace(".", ""));
		this.confirmedDeaths = Integer.parseInt(siteInfo[7].replace(".", ""));
		this.investedValue = Float.parseFloat(siteInfo[38].replace(",", "."));
		this.page = null;
		siteInfo = null;
	}
	
	private HtmlPage getHTMLPAGE(String url) throws WebScrappingException {
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
	
	private String[] getInfoFromXPATHClass(HtmlPage page, String XPATHCLASS) throws IndexOutOfBoundsException {
		List<HtmlDivision> vaccinationInfo = page.getByXPath(XPATHCLASS);
		String string[] = vaccinationInfo.get(0).asNormalizedText().replace("\n", " ").split(" ");
		return string;
	}
	
	//TODO getCalendar
	/*private List<String> getCalendarFromXPATHClass(HtmlPage page, String XPATHCLASS){
		List<String> list = new ArrayList<String>();
		List<HtmlDivision> vaccinationInfo = page.getByXPath(XPATHCLASS);
		String result[] = vaccinationInfo.get(0).asNormalizedText().split("\n");
		for(String s : result) {
			System.out.println(s);
		}
		
		return list;
	}*/
	
	@Override
	public String toString() {
		return "Update in: " + this.updatedDate + 
				"\nUpdate at: " + this.updatedTime + 
				"\nPercentage vaccinated: " + this.vaccinatedPercentage + 
				"\nTotal doses: " + this.vaccineDosesApplied + 
				"\nFirst doses applied: " + this.firstDoseApplied + 
				"\nSecond doses applied: " + this.secondDoseApplied + 
				"\nSingle doses appllied: " + this.singleDoseApplied + 
				"\nConfirmed cases: " + this.confirmedCases + 
				"\nConfirmed deaths: " + this.confirmedDeaths + 
				"\nInvested value: R$ " + this.investedValue + " billions";
	}
}
