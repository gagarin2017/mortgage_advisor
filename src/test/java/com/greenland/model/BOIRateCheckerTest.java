package com.greenland.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Strings;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

/**
 * Test for BOIRateCheckerTest.
 * 
 * @author Yury
 *
 */

@RunWith(JMockit.class)
public class BOIRateCheckerTest {
	
	private final static String BOI_RATES_TABLE_URL = "https://personalbanking.bankofireland.com/borrow/mortgages/rate-table/";
	
	@Tested
	private BOIRateChecker boiRateChecker;
	
	@Mocked
	private AbstractRateChecker abstractRateChecker;
	
	@Test
	public void constructorTest() {
		
		new Expectations(BOIRateChecker.class) {
			{
				abstractRateChecker.setUrlSessionAttribute("boiUrl");
				abstractRateChecker.setAllRatesTableSessionAttribute("boiAllRates");
				abstractRateChecker.setUrl(BOI_RATES_TABLE_URL);
				abstractRateChecker.setRootDomElement("table");
				abstractRateChecker.setAllRatesTableName("myTable");
				abstractRateChecker.setBestRateSessionAttribute(anyString);
				abstractRateChecker.setBestRateSessionAttribute(anyString);
				
			}
		};
		
		new BOIRateChecker();
	}
	
	@Test
	public void getUrl_and_getAllRatesHtmlTable_NotNull() {
		
		new Expectations(boiRateChecker) {};
		boiRateChecker = new BOIRateChecker();
		boiRateChecker.init();
		
		assertFalse(
				"Check that BOI rates link is still valid (not null or empty).", Strings.isNullOrEmpty(boiRateChecker.getUrl()));
		assertNotNull(
				"Check that HTML table BOI Rate Checker returns is not NULL.", boiRateChecker.getAllRatesHtmlTable());
		
	}
	
	/**
	 * Make sure that BOIRateChecker returns the expected table.
	 */
	@Test
	public void boiRatesAllRatesTableCheck() {
		
		new Expectations(boiRateChecker) {};
		boiRateChecker = new BOIRateChecker();
		boiRateChecker.init();
		
		assertEquals( "Check if <table> is returned.", "table", boiRateChecker.getAllRatesHtmlTable().tagName());
		
		final Element expectedTable;
		Element expectedTbodyElement = null;
		try {
			final Document doc = Jsoup.connect(BOI_RATES_TABLE_URL).get();
			expectedTable = doc.select("table").get(0);
			for (Element element : expectedTable.getAllElements()) {
				if (element.tagName().equalsIgnoreCase("tbody")) {
					expectedTbodyElement = element;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// throw NPE if expected table has no <tbody> i.e. is NULL
		assertEquals("Checking if All rates table returned by Rate Checker has all the rows (rates) as expected.", expectedTbodyElement.childNodeSize(),
				boiRateChecker.getAllRatesHtmlTable().childNode(3).childNodeSize());
	}

}
