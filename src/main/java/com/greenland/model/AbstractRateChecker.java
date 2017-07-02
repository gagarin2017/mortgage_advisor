package com.greenland.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class AbstractRateChecker implements RateChecker {
	
	private static final String DATA_TABLE_CLASS_NAME = "display";
	private static String allRatesSessionAttribute;
	private static String url;
	private String rootDomElement;
	private Element bankRatesHTMLTable;
	private String allRatesTableName;
	
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
	 * @param bankRatesHTMLTable2
	 */
	private void addDataTableFlavor(final Element bankRatesHTMLTable, final String tableDOM_id) {
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

	public void setRootDomElement(String rootDomElement) {
		this.rootDomElement = rootDomElement;
	}

	public String getAllRatesSessionAttribute() {
		return allRatesSessionAttribute;
	}

	protected static void setAllRatesSessionAttribute(String allRatesSessionAttribute) {
		AbstractRateChecker.allRatesSessionAttribute = allRatesSessionAttribute;
	}

	protected String getAllRatesTableName() {
		return allRatesTableName;
	}

	protected void setAllRatesTableName(String allRatesTableName) {
		this.allRatesTableName = allRatesTableName;
	}

	
}
