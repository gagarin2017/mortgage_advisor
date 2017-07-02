package com.greenland.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.google.common.base.Strings;

/**
 * Test for BOIRateCheckerTest.
 * 
 * @author Yury
 *
 */

@RunWith(JUnitPlatform.class)
@Tag("fast")
public class BOIRateCheckerTest {

	private static RateChecker boiRateChecker;

	@BeforeAll
	@DisplayName("Setting up the test data.")
	static void initAll() {

		boiRateChecker = new BOIRateChecker();
		boiRateChecker.init();

	}

	@Test
	@DisplayName("Check that BOI rates link is still valid (not null or empty).")
	void boiRatesLinkTest(final TestInfo testInfo) {
		assertFalse(Strings.isNullOrEmpty(boiRateChecker.getUrl()),
				"Check that BOI rates link is still valid (not null or empty).");
		assertNotNull(boiRateChecker.getAllRatesHtmlTable(),
				"Check that HTML table BOI Rate Checker returns is not NULL.");
	}

	@Test
	@DisplayName("Check All rates table.")
	void boiRatesAllRatesTableCheck(final TestInfo testInfo) throws IOException {
		assertEquals("table", boiRateChecker.getAllRatesHtmlTable().tagName(), "Check if <table> is returned.");
		final Document doc = Jsoup.connect(boiRateChecker.getUrl()).get();
		final Element expectedTable = doc.select("table").get(0);

		Element expectedTbodyElement = null;

		for (Element element : expectedTable.getAllElements()) {
			if (element.tagName().equalsIgnoreCase("tbody")) {
				expectedTbodyElement = element;
				break;
			}
		}

		// throw NPE if expected table has no <tbody> i.e. is NULL
		assertEquals(expectedTbodyElement.childNodeSize(),
				boiRateChecker.getAllRatesHtmlTable().childNode(3).childNodeSize(),
				"Checking if All rates table returned by Rate Checker has all the rows (rates) as expected.");
	}

}
