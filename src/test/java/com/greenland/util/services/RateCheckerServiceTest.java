package com.greenland.util.services;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.greenland.model.AbstractRateChecker;

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
				abstractRateChecker.getBestRateObject();
				
			}
		};
		
		RateCheckerService.updateSessionWithRateCheckerData(httpSessionMock);
	}

}
