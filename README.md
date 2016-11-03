# sm4j-exc

**Description:**

Get rid of the literals when throwing an exception!

This is a very simple and lightweight java exception framework, which allows exception messages to be stored in different resource bundle files. All message keys are kept in the corresponding bundle enumeration files.

When throwing an exception, just point the message key from the enumeration and pass the specific parameters.

If you need locale specific message, use the provided method and get it.

- - -

**How to get it?**

 - Simply fork it!
 - As a jar file

> Find the latest version [here](https://github.com/Iretha/sm4j-exc/tree/master/sm4j-exc/target).

 - As a Maven dependency

> ***WARNING!*** It's a github hosted repository, so you'd better not use it. If someone finds it useful, it can be easily published to the Maven Central Repository.

```xml
<repository>
	<id>smdev.local</id>
	<name>sm4j-exc</name>
	<url>https://github.com/Iretha/maven-repo/tree/master/maven-repo</url>
</repository>

<dependency>
	<groupId>com.smdev</groupId>
	<artifactId>sm4j-exc</artifactId>
	<version>0.0.1</version>
</dependency>
```

- - -

**How to setup your application?**

1. Create a resource bundle 
> Place your files under the ***resources*** directory of the java project. You can put  them directly or under a hierarchy of directories.

1. Add supported locales i.e.
	- ExampleBundle.properties  
	>Do not forget the default locale! It serves well when an unsupported locale is requested.
	
	- ExampleBundle_en_UK.properties
	- ExampleBundle_bg_BG.properties
	- ExampleBundle_xx_XX.properties
1. Add an enumeration file for the bundle which will keep the message keys
	- Enum should implement **com.sm4j.exception.IMessageKey**
	- Implement required methods as follows:
```Java
	 @Override
	public String getBundleName() {
	// if the files are placed in a subdir called *example*
	// return "example.ExampleBundle";

	// if the files are placed directly
		return "ExampleBundle";
	}

	@Override
	public String getMessageKey() {
		return name();
	}
```

2. Your custom exceptions should extend **com.sm4j.exception.ApplicationException**

- - -

**How it works?**

1. Add a message to the bundle
```xml
testKey=Test message default
testKeyParams=Par 1: {0}, Par2: {1} default
```

1. Add the keys to the enumeration
```java
testKey, testKeyParams;
```
1. Throw an exception with the key - choose the constructor that best suits your needs.
> Here are only two examples:
>- *Without params:*
```java
throw new ExampleException(ExampleEnum.testKey);
```
>- *With any number of params:*
```java
throw new ExampleException(ExampleEnum.testKeyParams, "string", 2);
```

1. Exception Message
>Exception message will correspond to the application locale.
>```java
String msg = e.getMessage();
```
1. Localized Exception Message
>If you want to get the localized message in order to show it to an user with a session specific locale, you need to catch the exception (which is the best practice btw.) and simply call:
```java
String localizedMsg = e.getLocalizedMessage(new Locale("en_UK"))
```
>
>***NOTE:***
>- If you request an unsupported locale, the code above will return the message from your default bundle file.
>- In case you have used default exception constructor with a hardcoded String message, this will return the hardcoded message.

- - -

**Full example**
You can find a full example under the [test directory](https://github.com/Iretha/sm4j-exc/tree/master/sm4j-exc/src/test) of the project.
