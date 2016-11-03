# Cybersource REST API Library for Java
[![Build Status](https://travis-ci.org/CyberSource/cybersource-rest-sdk-java.png?branch=future)]
(https://travis-ci.org/CyberSource/cybersource-rest-sdk-java)

Java client bindings for the CyberSource REST API. Documentation for the CyberSource Payments REST API can be found [here](https://vdp.visa.com/products/cybersource/reference).

##Package Managers

### Maven
To install the cybersource-sdk-java from central repository,add dependency to your application pom.xml as below.
````
        <dependency>
            <groupId>com.visa</groupId>
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
The classes in the ```samples/``` folder demonstrate the basics of using the API. Before building and running the samples, make sure to set the API key and secret key in the sample Java files first:
```java
ConfigurationBuilder builder = new ConfigurationBuilder();
builder.setApiKey("apikey")
       .setSecretKey("secretkey")
```

If you've already built the SDK with Maven, you can build the samples from the main directory. Just run:
```
javac -cp target/rest-sdk-java-1.0.0-SNAPSHOT.jar samples/*.java
```

You can then run the samples from the same directory. For example, here's the command to run the SearchPayment example (if you're on Windows, change the path separator from ````:```` to ````;````):
```
java -cp target/lib/*:target/*:./samples/ SearchPayment
```

### Authorization and Capture (Credit Card) Example
```java
AuthCaptureRequest authRequest = new AuthCaptureRequest();
Payment payment = new Payment();
payment.setCardNumber("4111111111111110");
payment.setCardExpirationMonth("10");
payment.setCardExpirationYear("2016");

authRequest.setPayment(payment);
authRequest.setAmount(new BigDecimal(5.00));
authRequest.setCurrency("USD");
authRequest.setReferenceId("123");

// Perform an authorization
try {
    Authorization auth = authApi.createAuthorization(authRequest);
    String authId = auth.getId();
    System.out.print("Authorization created and returned with authId: " + authId);
  
    // Perform a capture against the previous authorization
    CaptureRequest captureRequest = new CaptureRequest();
    captureRequest.setAmount(new BigDecimal(5.00));
    captureRequest.setCurrency("USD");
    captureRequest.setReferenceId("123");
    Capture capture = captureApi.captureAuthorization(authId, captureRequest);
    System.out.println("Capture authorization: " + capture);
} catch(ApiException e) {
   System.out.println(e.getMessage());
}
```
    
## Tests

Run the test suite with ```mvn test```.

