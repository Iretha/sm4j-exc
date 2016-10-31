1. Create all required reasource bundle files. They are usually stored under "resources" folder.
2. Create enum, which will contain all message keys from your bundle.
3. The enumeration should implement IMessageKey interface
4. Implement required methods:

	@Override
	public String getBundleName() {
		return "ExampleBundle";
	}

	@Override
	public String getMessageKey() {
		return name();
	}
