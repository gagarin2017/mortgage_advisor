package com.greenland.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.jsoup.nodes.Element;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Test for TableRowsToRateObjectMapper utility class.
 * 
 * @author Yury
 *
 */

@RunWith(JUnitPlatform.class)
@Tag("fast")
public class BOIRateCheckerTest {

		private static Element specificRateTR;
		private static Element ratesTable;
		
		private static final String EXPECTED_MORTGAGE_TYPE = "First Time Buyer";
		private static final String EXPECTED_FIXED_OR_VARIABLE = "Fixed";
		private static final String EXPECTED_LTV_RULE = "<=60%";
		private static final String EXPECTED_PRODUCT_DESC = "1 Year LTV <=60%";
		private static final String EXPECTED_RATE_PERCENTAGE = "3.40";
		private static final String EXPECTED_APR = "3.90";
		
		@BeforeAll
		@DisplayName("Setting up the test data.")
	    static void initAll() {
			
			specificRateTR = setTheRowWithASpecificRate();
			
			ratesTable = new Element("table");
			ratesTable.appendChild(getRandomRateTR());
			ratesTable.appendChild(getRandomRateTR());
			ratesTable.appendChild(specificRateTR);
			ratesTable.appendChild(getRandomRateTR());
			ratesTable.appendChild(specificRateTR);
			ratesTable.appendChild(getRandomRateTR());
	    }


		private static Element getRandomRateTR() {
			final Element randomRateRow = new Element("tr");
			
			final Element mortgageTypeNameCol = new Element("td");
			mortgageTypeNameCol.text(EXPECTED_MORTGAGE_TYPE);
			final Element ltvRuleCol = new Element("td");
			ltvRuleCol.text(EXPECTED_LTV_RULE);
			final Element productDescCol = new Element("td");
			productDescCol.text(EXPECTED_PRODUCT_DESC);
			final Element fixedOrVarCol = new Element("td");
			fixedOrVarCol.text(EXPECTED_FIXED_OR_VARIABLE);
			
			final Element ratePercentageCol = new Element("td");
			ratePercentageCol.text(EXPECTED_RATE_PERCENTAGE);
			final Element aprCol = new Element("td");
			aprCol.text(EXPECTED_APR);
			
			randomRateRow.appendChild(mortgageTypeNameCol);
			randomRateRow.appendChild(fixedOrVarCol);
			randomRateRow.appendChild(ltvRuleCol);
			randomRateRow.appendChild(productDescCol);
			randomRateRow.appendChild(ratePercentageCol);
			randomRateRow.appendChild(aprCol);
			
			return randomRateRow;
		}


		/**
		 * This method creates very specific row with the rate which going to be used later in the following test(-s).
		 * 
		 * @return TR with a specific rate
		 */
		private static Element setTheRowWithASpecificRate() {
			
			final Element specificRateRow = new Element("tr");
			specificRateRow.addClass("specificRate");
			
			final Element mortgageTypeNameCol = new Element("td");
			mortgageTypeNameCol.text(EXPECTED_MORTGAGE_TYPE);
			final Element ltvRuleCol = new Element("td");
			ltvRuleCol.text(EXPECTED_LTV_RULE);
			final Element productDescCol = new Element("td");
			productDescCol.text(EXPECTED_PRODUCT_DESC);
			final Element fixedOrVarCol = new Element("td");
			fixedOrVarCol.text(EXPECTED_FIXED_OR_VARIABLE);
			final Element ratePercentageCol = new Element("td");
			ratePercentageCol.text(EXPECTED_RATE_PERCENTAGE);
			final Element aprCol = new Element("td");
			aprCol.text(EXPECTED_APR);
			
			specificRateRow.appendChild(mortgageTypeNameCol);
			specificRateRow.appendChild(fixedOrVarCol);
			specificRateRow.appendChild(ltvRuleCol);
			specificRateRow.appendChild(productDescCol);
			specificRateRow.appendChild(ratePercentageCol);
			specificRateRow.appendChild(aprCol);
			
			return specificRateRow;
		}

		@Test
		@DisplayName("Check if we can access BOI rates data")
		void myFirstTest(final TestInfo testInfo) {
			final RateChecker rateChecker = new BOIRateChecker();
			rateChecker.init();
			assertNotNull(rateChecker.getAllRatesHtmlTable(), "BOI rates check.");
		}
		
}
