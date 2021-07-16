package module_info;

import java.util.List;

public abstract class Info {
	protected int confirmedCases, confirmedDeaths, vaccineDosesApplied, firstDoseApplied, secondDoseApplied, singleDoseApplied;
	protected List<String> vaccineCalendar;
	
	//TODO Info instantiation?
	
	public int getConfirmedCases() {
		return confirmedCases;
	}
	
	public int getConfirmedDeaths() {
		return confirmedDeaths;
	}
	
	public int getVaccineDosesApplied() {
		return vaccineDosesApplied;
	}
	
	public int getFirstDoseApplied() {
		return firstDoseApplied;
	}
	
	public int getSecondDoseApplied() {
		return secondDoseApplied;
	}
	
	public int getSingleDoseApplied() {
		return singleDoseApplied;
	}
	
	public List<String> getVaccineCalendar() {
		return vaccineCalendar;
	}
	
	//private static final String baseUrl = "https://www.saopaulo.sp.gov.br/coronavirus/";
}
