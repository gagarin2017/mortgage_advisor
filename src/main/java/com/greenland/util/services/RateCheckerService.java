package com.greenland.util.services;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jsoup.nodes.Element;

import com.google.common.collect.ImmutableMap;
import com.greenland.model.RateChecker;
import com.greenland.model.RateObject;
import com.greenland.util.RateCheckers;

/**
 * Common service methods for all Rate Checkers.
 * 
 * @author Yury
 *
 */
public abstract class RateCheckerService {
	
	/**
	 * {@link RateChecker} class type - {@link RateChecker} service relationship Map.
	 */
	/*private*/ static Map<Class<? extends RateChecker>, RateCheckerService> rateCheckerServicesMap = 
			ImmutableMap.of(RateCheckers.BOI.getRateCheckerClassType(),RateCheckers.BOI.getRelevantService());
	
	/**
	 * This method adds all the data to the httpsession object, which will be passed to the the front end.
	 * Method creates an instance of the RateChecker object (for example, BOIRateChecker) gets and places its data to the session attributes.
	 * @param session 
	 * 				-current session
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void updateSessionWithRateCheckerData(final HttpSession session) throws InstantiationException, IllegalAccessException {
		
		for (final RateCheckers rateChecker : RateCheckers.values()) {
			final RateChecker rateCheckerInstance = rateChecker.getRateCheckerClassType().newInstance();
			rateCheckerInstance.init();
			session.setAttribute(rateCheckerInstance.getAllRatesTableSessionAttribute(), rateCheckerInstance.getAllRatesHtmlTable());
			session.setAttribute(rateCheckerInstance.getUrlSessionAttribute(), rateCheckerInstance.getUrl());
			session.setAttribute(rateCheckerInstance.getBestRateSessionAttribute(), getBestRateObject(rateCheckerInstance.getAllRatesHtmlTable(),rateCheckerInstance.getClass()));
		}
	}
	
	/**
	 * Method finds the appropriate Service and calls getBestRateObject method on this service.
	 * 
	 * @param allRatesHtmlTable - table to be filtered in order to find the best Rate
	 * @param childRateChecker - RateChecker instance to find the appropriate Service.
	 * @return RateObject - the best Rate found in allRatesHtmlTable
	 */
	public static RateObject getBestRateObject(final Element allRatesHtmlTable, final Class<? extends RateChecker> childRateChecker) {
		final RateObject rateObject;
		final RateCheckerService rateCheckerService = rateCheckerServicesMap.get(childRateChecker);
		if (rateCheckerService == null) {
			throw new RuntimeException(String.format("Snap! Service for Rate Checker \"%s\" does not exist",childRateChecker.getName()));
		} else {
			rateObject = rateCheckerService.getBestRateObject(allRatesHtmlTable);
		}
		return rateObject;
	}

	/**
	 * Enforcing child class to implement this method
	 * 
	 * @param allRatesHtmlTable - table to be filtered in order to find the best Rate
	 * @return RateObject - the best Rate found in allRatesHtmlTable
	 */
	abstract RateObject getBestRateObject(Element allRatesHtmlTable);

}
