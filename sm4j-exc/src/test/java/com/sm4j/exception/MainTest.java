package com.sm4j.exception;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	private static final String MSG = "Test message ";
	private static final List<String> TEST_LOCALES = Arrays.asList("en_UK", "en_US", "bg_BG");

	/**
	 * Message from the corresponding ExampleBundle_x_X.properties file is
	 * expected
	 */
	@Test
	public void testLocalizedMessage() {
		Locale.setDefault(new Locale("fake")); // only for testing purposes

		ExampleException e = new ExampleException(ExampleBundle1Key.testKey);

		Assert.assertEquals("Test message default", e.getMessage());
		for (String test : TEST_LOCALES) {
			Assert.assertEquals(MSG + test, e.getLocalizedMessage(new Locale(test)));
		}
	}

	/**
	 * Formatted message from the corresponding ExampleBundle_x_X.properties
	 * file is expected
	 */
	@Test
	public void testMessageWithParams() {
		Locale.setDefault(new Locale("fake")); // only for testing purposes

		ExampleException e = new ExampleException(ExampleBundle1Key.testKeyParams, "string", 2);

		Assert.assertEquals("Par 1: string, Par2: 2 default", e.getMessage());
		for (String test : TEST_LOCALES) {
			Assert.assertEquals("Par 1: string, Par2: 2 " + test, e.getLocalizedMessage(new Locale(test)));
		}
	}

	/**
	 * Message from the corresponding ExampleBundle_x_X.properties file is
	 * expected
	 */
	@Test
	public void testSupportedLocale() {
		Locale.setDefault(new Locale(TEST_LOCALES.get(0))); // for testing purposes

		ExampleException e = new ExampleException(ExampleBundle1Key.testKey);

		Assert.assertEquals(MSG + TEST_LOCALES.get(0), e.getMessage());
	}

	/**
	 * Message from the default ExampleBundle.properties file is expected
	 */
	@Test
	public void testUnsupportedLocale() {
		Locale.setDefault(new Locale("fake")); // only for testing purposes

		ExampleException e = new ExampleException(ExampleBundle1Key.testKey);
		Assert.assertEquals("Test message default", e.getMessage());
	}
	
	/**
	 * Message from the default ExampleBundle.properties file is expected
	 */
	@Test
	public void testBundleOutOfThePackage() {
		Locale.setDefault(new Locale("fake")); // only for testing purposes

		ExampleException e = new ExampleException(ExampleBundle2Key.testKey);
		Assert.assertEquals("Bundle out of the package", e.getMessage());
	}

}
