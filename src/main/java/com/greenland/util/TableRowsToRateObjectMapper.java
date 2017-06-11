package com.greenland.util;

import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.greenland.model.RateObject;

/**
 * Rate object utility class
 * @author Yury
 *
 */
public class TableRowsToRateObjectMapper {

	public static List<RateObject> convertRowsToRateObjects(final Elements tableRows) {

		final List<RateObject> resultList = new LinkedList<RateObject>();
		
		for (int i=0; i < tableRows.size(); i++) {
			final RateObject rateObject = convertRowToRateObject(tableRows.get(i));
			resultList.add(rateObject);
		}
		
		return resultList;
	}

	protected static RateObject convertRowToRateObject(final Element element) {
		final RateObject rateObject = new RateObject();
		
		final Elements cols = element.select("td");
		
		rateObject.setMortgageType(cols.get(0).text());
		rateObject.setFixed(cols.get(1).text());
		rateObject.setLtvRule(cols.get(2).text());
		rateObject.setLtvDescription(cols.get(3).text());
		rateObject.setInterestRatePercentage(cols.get(4).text());
		rateObject.setApr(cols.get(5).text());
		
		return rateObject;
	}

	public static Elements covertRateObjectToColumns(final RateObject rateObject) {
		
		final Element td1 = new Element("td");
		td1.text(rateObject.getMortgageType());
		
		final Element td2 = new Element("td");
		td2.text(rateObject.getFixedAsString());
		
		final Element td3 = new Element("td");
		td3.text(rateObject.getLtvRule());
		
		final Element td4 = new Element("td");
		td4.text(rateObject.getLtvDescription());
		
		final Element td5 = new Element("td");
		td5.text(String.valueOf(rateObject.getApr()));
		
		final Element td6 = new Element("td");
		td6.text(String.valueOf(rateObject.getInterestRatePercentage()));
		
		final Elements tds = new Elements(td1, td2, td3, td4, td5, td6);
		
		return tds;
	}

}
