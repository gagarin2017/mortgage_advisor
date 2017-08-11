package com.greenland.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class AbstractRateChecker implements RateChecker {
	
	private static final String DATA_TABLE_CLASS_NAME = "display";
	
	private String allRatesTableSessionAttribute;
	private String urlSessionAttribute;
	private String bestRateSessionAttribute;
	private String url;
	private String rootDomElement;
	private Element bankRatesHTMLTable;
	private String allRatesTableName;
	private RateObject bestRateObject;
	
	@Override
	public void init() {
		try {
			final Document doc = Jsoup.connect(url).get();
			bankRatesHTMLTable = doc.select(rootDomElement).get(0);
			addDataTableFlavor(bankRatesHTMLTable, allRatesTableName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method adds DataModel flavor to the resulting table
	 *
	 * @param bankRatesHTMLTable - table which need to have data table parameters
	 * @param tableDOM_id - result table id
	 */
	void addDataTableFlavor(final Element bankRatesHTMLTable, final String tableDOM_id) {
		bankRatesHTMLTable.removeAttr("class");
		bankRatesHTMLTable.addClass(DATA_TABLE_CLASS_NAME);
		bankRatesHTMLTable.attr("cellspacing","0");
		bankRatesHTMLTable.attr("width","100%");
		bankRatesHTMLTable.attr("id",tableDOM_id);
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

	public void setRootDomElement(final String rootDomElement) {
		this.rootDomElement = rootDomElement;
	}

	public String getAllRatesTableSessionAttribute() {
		return allRatesTableSessionAttribute;
	}

	protected void setAllRatesTableSessionAttribute(final String allRatesTableSessionAttribute) {
		this.allRatesTableSessionAttribute = allRatesTableSessionAttribute;
	}

	protected String getAllRatesTableName() {
		return allRatesTableName;
	}

	protected void setAllRatesTableName(final String allRatesTableName) {
		this.allRatesTableName = allRatesTableName;
	}

	public String getUrlSessionAttribute() {
		return urlSessionAttribute;
	}

	/**
	 * Setter for the session attribute 
	 * 
	 * @param urlSessionAttribute - attribute name
	 */
	protected void setUrlSessionAttribute(final String urlSessionAttribute) {
		this.urlSessionAttribute = urlSessionAttribute;
	}

	public String getBestRateSessionAttribute() {
		return bestRateSessionAttribute;
	}

	protected void setBestRateSessionAttribute(final String bestRateSessionAttribute) {
		this.bestRateSessionAttribute = bestRateSessionAttribute;
	}

	public RateObject getBestRateObject() {
		return bestRateObject;
	}

	protected void setBestRateObject(final RateObject bestRateObject) {
		this.bestRateObject = bestRateObject;
	}

	
}
