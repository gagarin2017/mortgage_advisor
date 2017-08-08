package com.greenland.util.services;

import javax.servlet.http.HttpSession;

import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.greenland.model.BOIRateChecker;

import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class BOIRateCheckerServiceTest {
		
		@Tested(fullyInitialized = true)
		private BOIRateCheckerService boiRateCheckerService;
		
		@Mocked
		private HttpSession httpSessionMock;
		
		@Injectable
		private BOIRateChecker bOIRateChecker;
		
		@Injectable
		RateCheckerService rateCheckerService;
		
		@Test(expected = NullPointerException.class)
		public void getBestRateObject_noTablePassed_ThrowNullPointerException() {
			
			final Element nullElement = null;
			boiRateCheckerService.getBestRateObject(nullElement);
		}
		
		@Test(expected = NullPointerException.class)
		public void getBestRateObject_FilledTablePassed_ReturnBestRate() {
			
			final Element nullElement = null;
			boiRateCheckerService.getBestRateObject(nullElement);
		}

	
}
