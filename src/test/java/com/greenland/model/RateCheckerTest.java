package com.greenland.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Common tests for all Rate Checker instances.
 * 
 * @author Yury
 *
 */

@RunWith(JUnitPlatform.class)
@Tag("fast")
public class RateCheckerTest {

	private static RateChecker boiRateChecker;

	@BeforeAll
	@DisplayName("Setting up the test data.")
	static void initAll() {

		boiRateChecker = new BOIRateChecker();
		boiRateChecker.init();

	}

	@Test
	@DisplayName("Make sure result table has DataTable flavour.")
	void dataTableFlavourTest(final TestInfo testInfo) {
		assertNotNull(boiRateChecker.getAllRatesHtmlTable(), "Check that HTML table Rate Checker returns is not NULL.");
		assertEquals("table", boiRateChecker.getAllRatesHtmlTable().tagName(), "Check if <table> is returned.");
		assertThat("Check the resulting table has a class.", 
				boiRateChecker.getAllRatesHtmlTable().classNames().size(),
				greaterThan(0));
		assertThat("Check the class name is \"display\".", 
				boiRateChecker.getAllRatesHtmlTable().classNames().contains("display"),
				is(true));
		assertThat("Check table has \"cellspacing\" attribute.", 
				boiRateChecker.getAllRatesHtmlTable().hasAttr("cellspacing"),
				is(true));
		assertThat("Check the \"cellspacing\" value is 0.", 
				boiRateChecker.getAllRatesHtmlTable().attr("cellspacing"),
				is("0"));
		assertThat("Check table has \"width\" attribute.", 
				boiRateChecker.getAllRatesHtmlTable().hasAttr("width"),
				is(true));
		assertThat("Check the \"width\" value is 100%.", 
				boiRateChecker.getAllRatesHtmlTable().attr("width"),
				is("100%"));
	}

}
