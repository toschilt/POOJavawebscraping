package module_info;

import java.util.List;

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
	
	public abstract int getConfirmedCasesToInt();
	
	public abstract int getConfirmedDeathsToInt();
	
	public abstract int getVaccineDosesAppliedToInt();
	
	public abstract int getFirstDoseAppliedToInt();
	
	public abstract int getSecondDoseAppliedToInt();
	
	public abstract int getSingleDoseAppliedToInt();
	
	public abstract float getVaccinatedPercentageToFloat();		
}
