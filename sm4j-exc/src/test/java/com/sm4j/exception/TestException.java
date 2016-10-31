package com.sm4j.exception;

public class TestException extends ApplicationException {

	/** */
	private static final long serialVersionUID = -7850265247882751590L;

	public TestException(IMessageKey key, Object... params) {
		super(key, params);
	}

	public TestException(Throwable throwable, IMessageKey key, Object... params) {
		super(key, throwable, params);
	}

}
