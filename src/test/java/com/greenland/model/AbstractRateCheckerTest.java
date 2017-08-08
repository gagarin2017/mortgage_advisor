package com.greenland.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class AbstractRateCheckerTest {
	
	@Tested
	private BOIRateChecker boiRateChecker;
	
	@Test
	public void init_success() throws IOException {
		final Element tableElement = new Element("table");
		
		new Expectations() {
			{
				boiRateChecker.addDataTableFlavor(tableElement, anyString); times = 1;
			}
		};
		
		boiRateChecker.init();
	}
	
	
	@Test
	public void addDataTableFlavor_elementWithWrongClass_DataTablePropertiesSet() {
		
		final String expectedId = "expectedID";
		final String expectedClassName = "display";
		final String expectedCellspacingValue = "0";
		final String expectedWidthValue = "100%";
		final Element tableElement = new Element("table");
		tableElement.addClass("TestClass");
		
		boiRateChecker.addDataTableFlavor(tableElement, expectedId);
		
		assertThat(tableElement.attributes().size(), is(4));
		assertEquals("Checking if class name is \"display\"", tableElement.className(),expectedClassName);
		assertEquals("Checking if id  attribute is set properly", tableElement.attr("id"),expectedId);
		assertEquals("Checking if cellspacing attribute is set properly", tableElement.attr("cellspacing"),expectedCellspacingValue);
		assertEquals("Checking if width attribute is set properly", tableElement.attr("width"),expectedWidthValue);
		
	}

}
