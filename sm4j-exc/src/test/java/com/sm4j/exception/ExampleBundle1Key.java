package com.sm4j.exception;

public enum ExampleBundle1Key implements IMessageKey {
	testKey,
	testKeyParams;

	@Override
	public String getBundleName() {
		return "bundle.ExampleBundle1";
	}

	@Override
	public String getMessageKey() {
		return name();
	}

}
