package com.greenland.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class AbstractRateChecker implements RateChecker {
	
	private static String allRatesSessionAttribute;
	private static String url;
	private String rootDomElement;
	private Element bankRatesHTMLTable;
	
	@Override
	public void init() {
		try {
			final Document doc = Jsoup.connect(url).get();
			bankRatesHTMLTable = doc.select(rootDomElement).get(0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Element getAllRatesHtmlTable() {
		return bankRatesHTMLTable;
	}

	public String getUrl() {
		return url;
	}

	protected void setUrl(String url) {
		this.url = url;
	}

	public String getRootDomElement() {
		return rootDomElement;
	}

	public void setRootDomElement(String rootDomElement) {
		this.rootDomElement = rootDomElement;
	}

	public String getAllRatesSessionAttribute() {
		return allRatesSessionAttribute;
	}

	protected static void setAllRatesSessionAttribute(String allRatesSessionAttribute) {
		AbstractRateChecker.allRatesSessionAttribute = allRatesSessionAttribute;
	}
	
	
	
}
