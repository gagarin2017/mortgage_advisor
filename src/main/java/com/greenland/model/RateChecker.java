package com.greenland.model;

import org.jsoup.nodes.Element;

public interface RateChecker {
	
	String getUrl();
	String getAllRatesSessionAttribute();
	Element getAllRatesHtmlTable();
	void init();
	
}
