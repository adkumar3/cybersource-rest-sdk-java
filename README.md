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
The TestTransaction.java class in the ```samples/``` folder demonstrate the basics of using the API. Before building and running the samples, make sure to set the API key and secret key in the sample Java file first:
```java
ConfigurationBuilder builder = new ConfigurationBuilder();
builder.setApiKey("apikey")
       .setSecretKey("secretkey")
```
The TestTransaction.java accepts the Service Name and name of the payload file as program argument. So if we want to run a authCapture transaction we need to pass AuthCapture AuthCaptureRequest.json as the program argument.
 TestTransaction <Service_name> <payload_file_name>
 
 Service_name parameter is mandatory in program arguments while running the TestTransaction class. If no arguments is passed then the program will exit.

It reads the request from the resources folder. All the request payload files are kept under the resources folder.

If you've already built the SDK with Maven, you can build the samples from the main directory. Just run:
```

```javac -cp target/rest-sdk-java-1.0.1-SNAPSHOT.jar:target/lib/* samples/*.java

You can then run the sample from the same directory. For example, here's the command to run the TestTransaction example (if you're on Windows, change the path separator from ````:```` to ````;````):
```
java -cp target/lib/*:target/*:./samples/ TestTransaction <Service_name> <name_of_the_payload_ file>
```

To Run through the Help Menu Type the following command on the command prompt.
java -cp target/lib/*:target/*:./samples/ TestTransaction Help

### Authorization and Capture (Credit Card) Example
case "AuthCapture":
			try {
				AuthCaptureRequest authCaptureRequest1=null;
				if(file_name!=null){
					file1 = new File(path+"/resources/"+file_name);
					authCaptureRequest1 = mapper.readValue(file1, AuthCaptureRequest.class);
				}
				else{
					file1 = new File(path+"/resources/AuthCaptureRequest.json");
				 authCaptureRequest1 = mapper.readValue(file1,AuthCaptureRequest.class);
				}
				 // Perform an authorization
				Authorization auth = authApi.createAuthorization(authCaptureRequest1);
				String id = auth.getId();
				System.out.println("Authorization created and returned with authId: "+ id);
				CaptureRequest authCapture=null;
				file1 = new File(path+"/resources/CaptureRequest.json");
				authCapture = mapper.readValue(file1,CaptureRequest.class);
				Capture capture = captureApi.captureAuthorization(id,authCapture);
				
    
## Tests

Run the test suite with ```mvn test```.

