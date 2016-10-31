package com.sm4j.exception;

/**
 * @author Ireth
 */
public interface IMessageKey {

	/** @return the name of the resource bundle with the exception messages */
	String getBundleName();

	/** @return key of the message in the resource bundle */
	String getMessageKey();
}
