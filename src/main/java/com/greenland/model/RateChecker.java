package com.greenland.model;

import org.jsoup.nodes.Element;

public interface RateChecker {
	
	String getUrl();
	String getUrlSessionAttribute();
	String getAllRatesTableSessionAttribute();
	String getBestRateSessionAttribute();
	Element getAllRatesHtmlTable();
	void init();
	RateObject getBestRateObject();
	
}
