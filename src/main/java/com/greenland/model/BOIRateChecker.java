package com.greenland.model;

import com.greenland.util.services.RateCheckerService;

public class BOIRateChecker extends AbstractRateChecker {
	
	private final static String BOI_RATES_TABLE_URL = "https://personalbanking.bankofireland.com/borrow/mortgages/rate-table/";
	
	private final static String RATES_TABLE_ELEMENT_STRING = "table";
	
	private final static String ALL_RATES_SESSION_ATT = "boiAllRates";
	private final static String URL_SESSION_ATT = "boiUrl";
	private final static String BEST_RATE_SESSION_ATT = "boiBestRate";
	
	public BOIRateChecker() {
		setUrlSessionAttribute(URL_SESSION_ATT);
		setUrl(BOI_RATES_TABLE_URL);;

		setAllRatesTableSessionAttribute(ALL_RATES_SESSION_ATT);
		setRootDomElement(RATES_TABLE_ELEMENT_STRING);
		setAllRatesTableName("myTable");

//		setBestRateSessionAttribute(BEST_RATE_SESSION_ATT);
		
//		setBestRateObject(RateCheckerService.getBestRateObject(getAllRatesHtmlTable(), this.getClass()));
	}
	
}
