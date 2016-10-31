package com.sm4j.exception;

public class ExampleException extends ApplicationException {

	/** */
	private static final long serialVersionUID = -7850265247882751590L;

	public ExampleException(IMessageKey key, Object... params) {
		super(key, params);
	}

	public ExampleException(Throwable throwable, IMessageKey key, Object... params) {
		super(key, throwable, params);
	}

}
