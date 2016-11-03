package com.sm4j.exception.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.sm4j.exception.IMessageKey;

/**
 * Utility class for forming a message
 */
public final class MessageFormatter {

	/**
	 * Returns formated message from the given resource file by its key. Uses
	 * the dafault locale.
	 *
	 * @param key
	 *            - message key
	 * @param params
	 *            - params in the message, if available
	 * @return formatted message
	 */
	public static String format(IMessageKey key, Object[] params) {
		return format(null, key, params);
	}

	/**
	 * Returns formated message from the given resource file by its key.
	 *
	 * @param locale
	 *            - specific locale
	 * @param key
	 *            - message key
	 * @param params
	 *            - params in the message, if available
	 * @return formatted message
	 */
	public static String format(Locale locale, IMessageKey key, Object[] params) {
		Locale tempLocale = (locale == null) ? Locale.getDefault() : locale;
		ResourceBundle bundle = ResourceBundle.getBundle(key.getBundleName(), tempLocale);
		String msg = null;
		try {
			msg = bundle.getString(key.getMessageKey());
			msg = params != null ? MessageFormat.format(msg, params) : msg;
		} catch (MissingResourceException e) {
			msg = "Key " + key + " missing from bundle: " + bundle.getBaseBundleName();
		}
		return msg;
	}

}