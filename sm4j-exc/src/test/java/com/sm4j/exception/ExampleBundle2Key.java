package com.sm4j.exception;

public enum ExampleBundle2Key implements IMessageKey {
	testKey,
	testKeyParams;

	@Override
	public String getBundleName() {
		return "ExampleBundle2";
	}

	@Override
	public String getMessageKey() {
		return name();
	}

}
