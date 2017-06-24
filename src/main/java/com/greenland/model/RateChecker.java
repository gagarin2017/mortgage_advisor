package com.greenland.model;

import org.jsoup.nodes.Element;

public interface RateChecker {

	Element getAllRatesHtmlTable();

	void init();
	
}
