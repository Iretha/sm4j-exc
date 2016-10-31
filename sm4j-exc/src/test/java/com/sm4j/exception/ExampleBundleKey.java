package com.sm4j.exception;

public enum ExampleBundleKey implements IMessageKey {
	testKey,
	testKeyParams;

	@Override
	public String getBundleName() {
		return "ExampleBundle";
	}

	@Override
	public String getMessageKey() {
		return name();
	}

}
