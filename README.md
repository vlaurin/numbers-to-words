# numbers-to-words

Convert numbers in their numeric representation to their British English words representation.
Supports numbers from 0 to 999,999,999.

## Build

Unit and acceptance tests can be run by:

```
mvn test
```

A JAR can be generated and installed as a Maven artifact by running:

```
mvn clean install
```

## Use

A `NumberConversionService` can be instantiated to easily convert `Integer` to `String`.

```java
final NumberConversionService conversionService = new NumberConversionService();
final String result = conversionService.convert(1); // result == "one"
```

For more advanced use cases:

```java
final StringBuilder description = new StringBuilder();
NumberBuilder.parse(1)
             .build()
             .describeTo(description); // `description` contains the string "one"
```
