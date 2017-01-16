
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Calendar;
import java.net.URL;
import com.cybersource.payments.ApiException;
import com.cybersource.payments.Configuration;
import com.cybersource.payments.Configuration.ConfigurationBuilder;
import com.cybersource.payments.api.AuthorizationsApi;
import com.cybersource.payments.api.CapturesApi;
import com.cybersource.payments.api.CreditsApi;
import com.cybersource.payments.api.RefundsApi;
import com.cybersource.payments.api.ReversalsApi;
import com.cybersource.payments.api.SalesApi;
import com.cybersource.payments.api.VoidsApi;
import com.cybersource.payments.model.AuthCaptureRequest;
import com.cybersource.payments.model.Authorization;
import com.cybersource.payments.model.Capture;
import com.cybersource.payments.model.CaptureRequest;
import com.cybersource.payments.model.CreditRequest;
import com.cybersource.payments.model.GetRefund;
import com.cybersource.payments.model.RefundRequest;
import com.cybersource.payments.model.ReverseAuthRequest;
import com.cybersource.payments.model.ReversedAuthorization;
import com.cybersource.payments.model.Sale;
import com.cybersource.payments.model.VoidRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestTransaction{

	public static void main(String[] args) {
		String file_name = null;
		String service_name = null;
		if(args.length >0 ){
			service_name = args[0];
			if(args.length >1)
			file_name=args[1];
		}
		else{
			System.out.println("No Arguments Passed ... Program will exit");
			System.exit(0);
		}
		ConfigurationBuilder builder = new ConfigurationBuilder();
		//merchant should set the apiKey and Secretkey
		builder.setApiKey("ApiKey").setSecretKey("SecretKey")
		.setTimeoutMilliseconds(30000);
	

		
		Configuration config = builder.build();
		AuthorizationsApi authApi = new AuthorizationsApi(config);
		CapturesApi captureApi = new CapturesApi(config);
		CreditsApi creditApi = new CreditsApi(config);
		SalesApi saleApi = new SalesApi(config);
		RefundsApi refundApi = new RefundsApi(config);
		ReversalsApi reversalsApi = new ReversalsApi(config);
		VoidsApi voidApi = new VoidsApi(config);

		ObjectMapper mapper = new ObjectMapper();
	
		
		File file1=null;
		String path=System.getProperty("user.dir");
		switch (service_name) {
		
		case "AuthCapture":
			try {
			
				AuthCaptureRequest authCaptureRequest1=null;
				if(file_name!=null){
					file1 = new File(path+"/resources/"+file_name);
					authCaptureRequest1 = mapper
							.readValue(file1, AuthCaptureRequest.class);
				}
				else{
					file1 = new File(path+"/resources/AuthCaptureRequest.json");
				 authCaptureRequest1 = mapper.readValue(file1,AuthCaptureRequest.class);
				}
				 // Perform an authorization
				
				Authorization auth = authApi
						.createAuthorization(authCaptureRequest1);
				String id = auth.getId();
				System.out
						.println("Authorization created and returned with authId: "
								+ id);
				CaptureRequest authCapture=null;
				file1 = new File(path+"/resources/CaptureRequest.json");
				
					 authCapture = mapper.readValue(file1,CaptureRequest.class);
				
				Capture capture = captureApi.captureAuthorization(id,
						authCapture);
				System.out.println("Capture output against authorization: "
						+ capture);
			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		
		case "Credit":
			try {
				CreditRequest CreditRequest=null;
				if(file_name!=null){
					file1 = new File(path+"/resources/"+file_name);
					CreditRequest = mapper.readValue(file1,CreditRequest.class);
				}
				else{
					file1 = new File(path+"/resources/CreditRequest.json");
					 CreditRequest = mapper.readValue(file1,CreditRequest.class);
				}
				// Perform an authorization
				
				com.cybersource.payments.model.Credit credit = creditApi
						.createCredit(CreditRequest);
				String id = credit.getId();
				System.out.println("Credit created and returned with Id: "
						+ id);
			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		case "Sale":
			try {
				AuthCaptureRequest authCaptureRequest1=null;
				if(file_name!=null){
					file1 = new File(path+"/resources/"+file_name);
				 authCaptureRequest1 = mapper.readValue(file1, AuthCaptureRequest.class);
				}
				else{
					file1 = new File(path+"/resources/Sale.json");
					authCaptureRequest1 = mapper
							.readValue(file1, AuthCaptureRequest.class);
				}
				 
				 // Perform an authorization
				 
				Sale sale1 = saleApi.createSale(authCaptureRequest1);
				String id = sale1.getId();
				System.out.println("Sale created and returned with Id: "
						+ id);
			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		case "Refund":
			try {
				// Run A Sale Transaction
				file1 = new File(path+"/resources/AuthCaptureRequest.json");
				AuthCaptureRequest authCaptureRequest1 =null;
				if(file_name!=null){
					authCaptureRequest1 = mapper
						.readValue(file1, AuthCaptureRequest.class);
				}
				else{
					file1 = new File(path+"/resources/AuthCaptureRequest.json");
					authCaptureRequest1 = mapper
							.readValue(file1, AuthCaptureRequest.class);
				}
				Sale sale1 = saleApi.createSale(authCaptureRequest1);
				String id = sale1.getId();
				
				// Run Refund
				file1 = new File(path+"/resources/"+file_name);
				RefundRequest refundRequest = mapper.readValue(file1,
						RefundRequest.class);
				com.cybersource.payments.model.Refund refund = refundApi
						.refundSale(id, refundRequest);
				System.out.println("Sale refunded: " + refund);
				GetRefund getRefund = refundApi.getRefund(refund.getId());
				System.out.println("Retrieve refund: " + getRefund);
			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
			
		case "AuthReversal":
			try {
				// Run A Sale Transaction
				file1 = new File(path+"/resources/AuthCaptureRequest.json");
				AuthCaptureRequest authCaptureRequest1 = mapper
						.readValue(file1, AuthCaptureRequest.class);
				
				Sale sale1 = saleApi.createSale(authCaptureRequest1);
				String id = sale1.getId();
				// Run Reversal
				ReverseAuthRequest reverseAuth=null;
				if(file_name!=null){
					file1 = new File(path+"/resources/"+file_name);
				 reverseAuth = mapper
						.readValue(file1, ReverseAuthRequest.class);
				}
				else{
					file1 = new File(path+"/resources/ReverseAuthRequest.json");
					reverseAuth = mapper
							.readValue(file1, ReverseAuthRequest.class);
				}
				ReversedAuthorization reversed = reversalsApi
						.reverseAuthorization(id, reverseAuth);
				System.out.println("Reversed authorization: " + reversed);
			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		case "Void":
			try {
				file1 = new File(path+"/resources/AuthCaptureRequest.json");
				AuthCaptureRequest authCaptureRequest1 = mapper
						.readValue(file1, AuthCaptureRequest.class);
				// Perform an authorization
				Sale sale1 = saleApi.createSale(authCaptureRequest1);
				String id = sale1.getId();
				VoidRequest voidRequest=null;
				if(file_name!=null){
					file1 = new File(path+"/resources/"+file_name);
				voidRequest = mapper
						.readValue(file1, VoidRequest.class);
				}
				else{
					file1 = new File(path+"/resources/Void.json");
					voidRequest = mapper
							.readValue(file1, VoidRequest.class);
				}
				com.cybersource.payments.model.Void voidOutput = voidApi
						.voidSale(id, voidRequest);
				System.out.println(voidOutput);
			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		case "Help":
			System.out.println("\n\n\n\t To compile the program run the following command \n\n"+
					"\t\t javac -cp target/rest-sdk-java-1.0.1-SNAPSHOT.jar:target/lib/* samples/*.java \n\n"+" \t To Execute A transaction use the following command \n\n"
					+ "\t\t java -cp target/lib/*:target/*:./samples/ TestTransaction <Service_name> <name_of_the_payload_ file> \n\n"
					+"\t Example if you want to execute an AuthCapture Transaction then the following command can be used \n\n"
					+"\t\t java -cp target/lib/*:target/*:./samples/ TestTransaction AuthCapture AuthCaptureRequest.json \n\n"
					+"\t If we dont specify payload file name then it will take the default value for the payload file name\n"
					+"\t User must specify Service_name agrument while executing. If no argument is passed the program will terminate \n"
					+"\t User defined Json Files can be placed under the resources folder and the same filename can be passed while executing the program\n\n"
					
					
					);
		
		default:
			break;
		}
	}

}
