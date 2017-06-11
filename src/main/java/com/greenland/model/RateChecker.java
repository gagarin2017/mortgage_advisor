package com.greenland.model;

import org.jsoup.nodes.Element;

public interface RateChecker {

	Element getAllRatesHtmlTable();

	Element getBestRatesTable();

	void init();

	RateObject getBestRateObject();
	
}
