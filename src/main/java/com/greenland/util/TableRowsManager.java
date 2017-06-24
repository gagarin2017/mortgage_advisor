package com.greenland.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.greenland.model.RateObject;

public class TableRowsManager {
	
	private static List<RateObject> onlyBestRateObjects;
	private static RateObject bestRate;

	public static String getBestRates(final Elements tableRows) {
		
		final Element tbody = new Element("tbody");
		final List<RateObject> allRowsAsRateObjects = TableRowsToRateObjectMapper.convertRowsToRateObjects(tableRows);
		
		Map<String, List<RateObject>> ratesMap = convertListToMap(allRowsAsRateObjects);
 		
		onlyBestRateObjects = new ArrayList<RateObject>();
		
		if (onlyBestRateObjects != null && !onlyBestRateObjects.isEmpty()) {
			Collections.sort(onlyBestRateObjects, new RateObjectComparator());
			bestRate = onlyBestRateObjects.get(0);
		}
		
		for (final Map.Entry<String, List<RateObject>> entry : ratesMap.entrySet()) {
			final List<RateObject> entryRateObjects = entry.getValue();
			Collections.sort(entryRateObjects, new RateObjectComparator());
			onlyBestRateObjects.add(entryRateObjects.get(0));
		}
		
		final Elements resultTableRows = getResultTableRows(onlyBestRateObjects);
		tbody.append(resultTableRows.outerHtml());
		
		return tbody.outerHtml();
	}
	
	private static Elements getResultTableRows(final List<RateObject> onlyBestRateObjects) {
		
		final List<Element> rows = new ArrayList<Element>();
		
		for (final RateObject rateObject : onlyBestRateObjects) {
			final Element row = new Element("tr");
			final Elements tds = TableRowsToRateObjectMapper.covertRateObjectToColumns(rateObject);
			row.append(tds.outerHtml());
			rows.add(row);
		}
		
		return new Elements(rows);
	}

	private static Map<String, List<RateObject>> convertListToMap(final List<RateObject> allRowsAsRateObjects) {
		
		final Map<String, List<RateObject>> ratesMap = new HashMap<String, List<RateObject>>();
		
		for (final RateObject rateObject : allRowsAsRateObjects) {
			
			List<RateObject> rates = new ArrayList<RateObject>();

			if (ratesMap.containsKey(rateObject.getMortgageType())) {
				rates = ratesMap.get(rateObject.getMortgageType());
			}
			
			rates.add(rateObject);
			ratesMap.put(rateObject.getMortgageType(), rates);
		}
		
		return ratesMap;
	}

	public static RateObject getBestRate() {
		return bestRate;
	}
	

	protected static class RateObjectComparator implements Comparator<RateObject> {

		@Override
		public int compare(RateObject o1, RateObject o2) {
			final Double apr1 = o1.getApr();
			final Double apr2 = o2.getApr();
			int result = apr1.compareTo(apr2);
			
			if (result == 0) {
				final Integer minPercentage1 = o1.getLtvMinPercentage();
				final Integer minPercentage2 = o2.getLtvMinPercentage();
				result = minPercentage1.compareTo(minPercentage2);
			}
			
			if (result == 0) {
				final Integer maxPercentage1 = o1.getLtvMaxPercentage();
				final Integer maxPercentage2 = o2.getLtvMaxPercentage();
				result = maxPercentage1.compareTo(maxPercentage2);
			}
			
			if (result == 0) {
				final Integer rateNumberOfYears1 = o1.getRateNumberOfYears();
				final Integer rateNumberOfYears2 = o2.getRateNumberOfYears();
				result = rateNumberOfYears1.compareTo(rateNumberOfYears2);
			}
			
			return result;
		}
	}

}
