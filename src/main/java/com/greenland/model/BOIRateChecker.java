package com.greenland.model;

public class BOIRateChecker extends AbstractRateChecker {
	
	private final static String BOI_RATES_TABLE_URL = "https://personalbanking.bankofireland.com/borrow/mortgages/rate-table/";
	
	private final static String RATES_TABLE_ELEMENT_STRING = "table";
	
	private final static String ALL_RATES_SESSION_ATT = "boiAllRates";
	private final static String URL_SESSION_ATT = "boiUrl";
	private final static String BEST_RATE_SESSION_ATT = "boiBestRate";
	
	public BOIRateChecker() {
		setUrlSessionAttribute(URL_SESSION_ATT);
		setAllRatesTableSessionAttribute(ALL_RATES_SESSION_ATT);

		// setting the source data
		setUrl(BOI_RATES_TABLE_URL);
		setRootDomElement(RATES_TABLE_ELEMENT_STRING);
		setAllRatesTableName("myTable");
		
		// setting the Best Rate for this specific RateChecker
		setBestRateSessionAttribute(BEST_RATE_SESSION_ATT);
	}
	
}
