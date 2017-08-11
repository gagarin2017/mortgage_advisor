package com.greenland.util.services;

import javax.servlet.http.HttpSession;

import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.greenland.model.AbstractRateChecker;
import com.greenland.model.BOIRateChecker;
import com.greenland.model.RateObject;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class RateCheckerServiceTest {
	
	@Mocked
	private HttpSession httpSessionMock;
	
	@Mocked
	private AbstractRateChecker abstractRateChecker;
	
	@Test
	public void updateSessionWithRateCheckerData_allSetUpdateRateCheckerDataMethodsCalled() throws InstantiationException, IllegalAccessException {
		
		new Expectations() {
			{
				abstractRateChecker.init();
				abstractRateChecker.getAllRatesTableSessionAttribute();
				abstractRateChecker.getAllRatesHtmlTable();
				abstractRateChecker.getUrlSessionAttribute();
				abstractRateChecker.getUrl();
				abstractRateChecker.getBestRateSessionAttribute();
				RateCheckerService.getBestRateObject(abstractRateChecker.getAllRatesHtmlTable(), BOIRateChecker.class);
				
			}
		};
		
		RateCheckerService.updateSessionWithRateCheckerData(httpSessionMock);
	}
	
	@Test
	public void getBestRateObject_allRatesHtmlTableNotEmpty_BestRateObject(@Mocked final BOIRateCheckerService boiRateCheckerService) {
		
		final Element allRatesHTMLTable = new Element("table");
		
		new Expectations(BOIRateCheckerService.class) {
			{
				boiRateCheckerService.getBestRateObject(allRatesHTMLTable);
			}
		};
		
		final RateObject bestRateObject = RateCheckerService.getBestRateObject(allRatesHTMLTable, BOIRateChecker.class);
		assertNotNull(bestRateObject);
	}
	
	
	@Test
	public void getBestRateObject_allRatesHtmlTableIsEmpty_RuntimeExceptionIsThrown(@Mocked final BOIRateCheckerService boiRateCheckerService) {
		
		final Element allRatesHTMLTable = new Element("table");
		
		new Expectations(BOIRateCheckerService.class) {
			{
				boiRateCheckerService.getBestRateObject(allRatesHTMLTable);
				
				RateCheckerService.rateCheckerServicesMap.get(BOIRateChecker.class);
				result = null;
			}
		};
		
		final RateObject bestRateObject = RateCheckerService.getBestRateObject(allRatesHTMLTable, BOIRateChecker.class);
		assertNull(bestRateObject);
	}

}
