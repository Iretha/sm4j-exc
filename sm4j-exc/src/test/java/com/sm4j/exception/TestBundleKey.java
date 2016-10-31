package com.sm4j.exception;

public enum TestBundleKey implements IMessageKey {
	testKey,
	testKeyParams;

	@Override
	public String getBundleName() {
		return "TestBundle";
	}

	@Override
	public String getMessageKey() {
		return name();
	}

}
