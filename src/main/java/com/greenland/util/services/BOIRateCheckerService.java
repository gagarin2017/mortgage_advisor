package com.greenland.util.services;

import org.jsoup.nodes.Element;

import com.greenland.model.RateObject;

public class BOIRateCheckerService extends RateCheckerService {
	
	public RateObject getBestRateObject(final Element allRatesHtmlTable) {
		if (allRatesHtmlTable == null) {
			throw new NullPointerException("Snap! All Rates table is null. Not able to find the best rate then ...");
		}
		return new RateObject();
	}

}
