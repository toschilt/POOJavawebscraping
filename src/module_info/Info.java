package module_info;

import java.util.List;

public abstract class Info {
	protected String confirmedCases, confirmedDeaths, vaccineDosesApplied, firstDoseApplied, secondDoseApplied, singleDoseApplied, totalVaccinatedPercentage;
	protected List<String> vaccineCalendar;
	
	public abstract String getConfirmedCases();
	
	//public abstract void setConfirmedCases(String confirmedCases);
	
	public abstract String getConfirmedDeaths();
	
	//public abstract void setConfirmedDeaths(String confirmedDeaths);
	
	public abstract String getVaccineDosesApplied();
	
	//public abstract void setVaccineDosesApplied(String vaccineDosesApplied);
	
	public abstract String getFirstDoseApplied();
	
	//public abstract void setFirstDoseApplied(String firstDoseApplied);
	
	public abstract String getSecondDoseApplied();
	
	//public abstract void setSecondDoseApplied(String secondDoseApplied);
	
	public abstract String getSingleDoseApplied();
	
	//public abstract void setSingleDoseApplied(String singleDoseApplied);
	
	public abstract String getVaccinatedPercentage();
	
	//public abstract void setVaccinatedPercentage(String vaccinatedPercentage);
	
	public abstract List<String> getVaccineCalendar();
	
	public abstract int getConfirmedCasesToInt();
	
	public abstract int getConfirmedDeathsToInt();
	
	public abstract int getVaccineDosesAppliedToInt();
	
	public abstract int getFirstDoseAppliedToInt();
	
	public abstract int getSecondDoseAppliedToInt();
	
	public abstract int getSingleDoseAppliedToInt();
	
	public abstract float getVaccinatedPercentageToFloat();
		
}
