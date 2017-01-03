# Cybersource REST API Library for Java
[![Build Status](https://travis-ci.org/CyberSource/cybersource-rest-sdk-java.png?branch=master)]
(https://travis-ci.org/CyberSource/cybersource-rest-sdk-java)

Java client bindings for the CyberSource REST API. Documentation for the CyberSource Payments REST API can be found [here](https://vdp.visa.com/products/cybersource/reference).

##Package Managers

### Maven
To install the cybersource-sdk-java from central repository,add dependency to your application pom.xml as below.
````
        <dependency>
            <groupId>com.cybersource</groupId>
            <artifactId>rest-sdk-java</artifactId>
            <version>1.0.0</version>
        </dependency> 
````
 Run mvn install, to install dependency

## Requirements
1. Java SDK 1.8  
2. Maven 3 and later  
3. A [VDP](https://vdp.visa.com) account with CyberSource enabled
    
## Running the Samples
The Sample.java class in the ```samples/``` folder demonstrate the basics of using the API. Before building and running the samples, make sure to set the API key and secret key in the sample Java file first:
```java
ConfigurationBuilder builder = new ConfigurationBuilder();
builder.setApiKey("apikey")
       .setSecretKey("secretkey")
```
The sample.java accepts the type of transaction as program argument. So of we want to run a authCapture transaction we need to pass AuthCapture as the program argument.

It reads the request from the resources folder. All the request is kept under the resources folder.

If you've already built the SDK with Maven, you can build the samples from the main directory. Just run:
```
javac -cp target/rest-sdk-java-1.0.0-SNAPSHOT.jar samples/*.java
```

You can then run the sample from the same directory. For example, here's the command to run the SearchPayment example (if you're on Windows, change the path separator from ````:```` to ````;````):
```
java -cp target/lib/*:target/*:./samples/ SearchPayment
```

### Authorization and Capture (Credit Card) Example
case "AuthCapture":
			try {
				AuthCaptureRequest authCaptureRequest1 = mapper
						.readValue(
								new File(Thread.currentThread()
										.getContextClassLoader()
										.getResource("AuthCaptureRequest.json") // map json to AuthCaptureRequest.class
										.toURI()), AuthCaptureRequest.class);
				// Perform an authorization
				
				Authorization auth = authApi
						.createAuthorization(authCaptureRequest1);
				String id = auth.getId();
				System.out
						.println("Authorization created and returned with authId: "
								+ id);

				CaptureRequest authCapture = mapper.readValue(
						new File(Thread.currentThread().getContextClassLoader()
								.getResource("CaptureRequest.json").toURI()),
						CaptureRequest.class);
				
				Capture capture = captureApi.captureAuthorization(id,
						authCapture);
				System.out.println("Capture output against authorization: "
						+ capture);
    
## Tests

Run the test suite with ```mvn test```.

