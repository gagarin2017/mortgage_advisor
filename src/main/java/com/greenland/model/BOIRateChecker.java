package com.greenland.model;

public class BOIRateChecker extends AbstractRateChecker {
	
	private final static String BOI_RATES_TABLE_URL = "https://personalbanking.bankofireland.com/borrow/mortgages/rate-table/";
	private final static String RATES_TABLE_ELEMENT_STRING = "table";
	
	public BOIRateChecker() {
		setUrl(BOI_RATES_TABLE_URL);;
		setRootDomElement(RATES_TABLE_ELEMENT_STRING);
	}

}
