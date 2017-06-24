package com.greenland.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class AbstractRateChecker implements RateChecker {
	
	private String url;
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

	protected String getUrl() {
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
	
	
	
}
