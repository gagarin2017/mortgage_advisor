package com.greenland.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This Business Object contains the rate details: Type, APR, Rate etc.
 * 
 * @author Yury
 *
 */
public class RateObject {
	
	private String mortgageType;
	private boolean fixed;
	
	private String ltvRuleString;
	private int actualLTV = 50;			// default LTV = 50 %
	private int ltvMinPercentage;
	private int ltvMaxPercentage;
	
	private String ltvDescriptionString;
	private int rateNumberOfYears;
	private double apr;
	private double interestRatePercentage;
	
	public String getMortgageType() {
		return mortgageType;
	}
	public void setMortgageType(final String mortgageType) {
		this.mortgageType = mortgageType;
	}
	public boolean isFixed() {
		return fixed;
	}
	public void setFixed(final boolean fixed) {
		this.fixed = fixed;
	}
	public String getLtvRule() {
		return ltvRuleString;
	}
	public void setLtvRule(final String ltvRuleString) {
		this.ltvRuleString = ltvRuleString;
		
		if (ltvRuleString != null && ltvRuleString.length() > 0) {
			ltvMinPercentage = setLTV_MinPercentage(ltvRuleString);
			ltvMinPercentage = setLTV_MaxPercentage(ltvRuleString);
		}
	}
	
	private int setLTV_MaxPercentage(final String ltvRuleString) {
		// String to be scanned to find the pattern.
		String line = ltvRuleString;
		String pattern = "(\\d+)%\\s?-\\s?((\\d+))%";
		
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);
		
		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			ltvMaxPercentage = Integer.valueOf(m.group(2));
		} else {
			ltvMaxPercentage = 0;
		}
		
		return ltvMaxPercentage;
	}
	
	private int setLTV_MinPercentage(final String ltvRuleString) {
		// String to be scanned to find the pattern.
		String line = ltvRuleString;
		String pattern = "(\\d+)";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			ltvMinPercentage = Integer.valueOf(m.group(0));
		} else {
			ltvMinPercentage = 0;
		}

		return ltvMinPercentage;
	}
	
	public String getLtvDescription() {
		return ltvDescriptionString;
	}
	
	public void setLtvDescription(final String ltvDescriptionString) {
		this.ltvDescriptionString = ltvDescriptionString;
		rateNumberOfYears = setLTV_NumberOfYears(ltvDescriptionString);
	}
	
	private int setLTV_NumberOfYears(final String ltvDescriptionString) {
		// String to be scanned to find the pattern.
		String line = ltvDescriptionString;
		String pattern = "(\\d+)\\s?Year";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			rateNumberOfYears = Integer.valueOf(m.group(1));
		} else {
			rateNumberOfYears = 100;
		}

		return rateNumberOfYears;
	}
	
	public double getApr() {
		return apr;
	}
	public void setApr(final double apr) {
		this.apr = apr;
	}
	public double getInterestRatePercentage() {
		return interestRatePercentage;
	}
	public void setInterestRatePercentage(double interestRatePercentage) {
		this.interestRatePercentage = interestRatePercentage;
	}

	public void setFixed(final String columnValue) {
		if (columnValue != null && columnValue.length() > 0 
				&& columnValue.equalsIgnoreCase("fixed")) {
			fixed = true;
		} else {
			fixed = false;
		}
	}
	
	public void setApr(final String apr) {
		this.apr = Double.parseDouble(apr);
	}
	
	public void setInterestRatePercentage(final String columnValue) {
		this.interestRatePercentage = Double.parseDouble(columnValue);
	}
	
	public String getFixedAsString() {
		return fixed ? "Fixed" : "Variable";
	}
	public int getActualLTV() {
		return actualLTV;
	}
	public void setActualLTV(int actualLTV) {
		this.actualLTV = actualLTV;
	}
	public int getLtvMinPercentage() {
		return ltvMinPercentage;
	}
	public void setLtvMinPercentage(int ltvMinPercentage) {
		this.ltvMinPercentage = ltvMinPercentage;
	}
	public int getLtvMaxPercentage() {
		return ltvMaxPercentage;
	}
	public void setLtvMaxPercentage(int ltvMaxPercentage) {
		this.ltvMaxPercentage = ltvMaxPercentage;
	}
	public int getRateNumberOfYears() {
		return rateNumberOfYears;
	}
	public void setRateNumberOfYears(int rateNumberOfYears) {
		this.rateNumberOfYears = rateNumberOfYears;
	}
	
	@Override
	public String toString() {
		return "RateObject [mortgageType=" + mortgageType + ", fixed=" + fixed + ", ltvRuleString=" + ltvRuleString
				+ ", actualLTV=" + actualLTV + ", ltvMinPercentage=" + ltvMinPercentage + ", ltvMaxPercentage="
				+ ltvMaxPercentage + ", ltvDescriptionString=" + ltvDescriptionString + ", rateNumberOfYears="
				+ rateNumberOfYears + ", apr=" + apr + ", interestRatePercentage=" + interestRatePercentage + "]";
	}

}
