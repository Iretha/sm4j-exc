package com.sm4j.exception;

import java.util.Locale;

import com.sm4j.exception.util.MessageFormatter;

/**
 * General Application Exception
 *
 * @author Ireth
 */
public abstract class ApplicationException extends Exception {

	/** UID */
	private static final long serialVersionUID = -3445771018605382161L;
	/** Message key (if available) */
	private IMessageKey key = null;
	/** Params (if available) */
	private Object[] params = null;

	/**
	 * @param key
	 *            - message key in the resource bundle
	 * @param throwable
	 *            - exception
	 * @param params
	 *            - message params
	 */
	protected ApplicationException(IMessageKey key, Object[] params) {
		this(key, null, params);
	}

	/**
	 * @param key
	 *            - message key in the resource bundle
	 * @param throwable
	 *            - exception
	 * @param params
	 *            - message params
	 */
	protected ApplicationException(IMessageKey key, Throwable throwable, Object[] params) {
		super(MessageFormatter.format(key, params), throwable);
		this.key = key;
		this.params = params;
	}

	/**
	 * @param message
	 */
	protected ApplicationException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	protected ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	protected ApplicationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Message for specific locale
	 *
	 * @param locale
	 * @return message
	 */
	public String getLocalizedMessage(Locale locale) {
		if (this.key == null) {
			return getMessage();
		}
		return MessageFormatter.format(locale, this.key, this.params);
	}

	/**
	 * Message for specific locale
	 *
	 * @param locale
	 * @return message
	 */
	public String getLocalizedMessage(String locale) {
		return getLocalizedMessage(new Locale(locale));
	}
}
