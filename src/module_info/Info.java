package module_info;

import java.util.List;

import module_exceptions.WebScrappingException;

public abstract class Info {
	protected String confirmedCases, confirmedDeaths, vaccineDosesApplied, firstDoseApplied, secondDoseApplied, singleDoseApplied, totalVaccinatedPercentage;
	protected List<String> vaccineCalendar;
	
	public abstract String getConfirmedCases();
	
	public abstract String getConfirmedDeaths();
	
	public abstract String getVaccineDosesApplied();
	
	public abstract String getFirstDoseApplied();
	
	public abstract String getSecondDoseApplied();
	
	public abstract String getSingleDoseApplied();
	
	public abstract String getVaccinatedPercentage();
	
	public abstract List<String> getVaccineCalendar();
	
	public abstract int getConfirmedCasesToInt() throws WebScrappingException;
	
	public abstract int getConfirmedDeathsToInt() throws WebScrappingException;
	 
	public abstract int getVaccineDosesAppliedToInt() throws WebScrappingException;
	
	public abstract int getFirstDoseAppliedToInt() throws WebScrappingException;
	
	public abstract int getSecondDoseAppliedToInt() throws WebScrappingException;
	
	public abstract int getSingleDoseAppliedToInt() throws WebScrappingException;
	
	public abstract float getVaccinatedPercentageToFloat() throws WebScrappingException;		
}
