package samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import com.cybersource.payments.model.GetAuthorization;
import com.cybersource.payments.model.GetRefund;
import com.cybersource.payments.model.GetSale;
import com.cybersource.payments.model.Payment;
import com.cybersource.payments.model.RefundRequest;
import com.cybersource.payments.model.ReverseAuthRequest;
import com.cybersource.payments.model.ReversedAuthorization;
import com.cybersource.payments.model.Sale;
import com.cybersource.payments.model.VoidRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {

	public static void main(String[] args) {
		String argument = Arrays.toString(args);
		argument = argument.substring(1, argument.length() - 1);
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		//merchant should set the apiKey and Secretkey
		builder.setApiKey("apiKey").setSecretKey("Secret Key")
		.setTimeoutMilliseconds(30000);
		String nextYear = Integer.toString((Calendar.getInstance().get(
				Calendar.YEAR) + 1));

		Configuration config = builder.build();
		AuthorizationsApi authApi = new AuthorizationsApi(config);
		CapturesApi captureApi = new CapturesApi(config);
		CreditsApi creditApi = new CreditsApi(config);
		SalesApi saleApi = new SalesApi(config);
		RefundsApi refundApi = new RefundsApi(config);
		ReversalsApi reversalsApi = new ReversalsApi(config);
		VoidsApi voidApi = new VoidsApi(config);

		ObjectMapper mapper = new ObjectMapper();

		switch (argument) {
				
		case "AuthCapture":
			try {
				AuthCaptureRequest authCaptureRequest1 = mapper
						.readValue(
								new File(Thread.currentThread()
										.getContextClassLoader()
										.getResource("AuthCaptureRequest.json")
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
			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		
		case "Credit":
			try {
				CreditRequest CreditRequest = mapper.readValue(
						new File(Thread.currentThread().getContextClassLoader()
								.getResource("CreditRequest.json").toURI()),
						CreditRequest.class);
				// Perform an authorization
				
				com.cybersource.payments.model.Credit credit = creditApi
						.createCredit(CreditRequest);
				String id = credit.getId();
				System.out.println("Credit created and returned with authId: "
						+ id);
			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		case "Sale":
			try {

				AuthCaptureRequest authCaptureRequest1 = mapper
						.readValue(
								new File(Thread.currentThread()
										.getContextClassLoader()
										.getResource("AuthCaptureRequest.json")
										.toURI()), AuthCaptureRequest.class);
				// Perform an authorization
				
				Sale sale1 = saleApi.createSale(authCaptureRequest1);
				String id = sale1.getId();
				System.out.println("Sale created and returned with authId: "
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
				AuthCaptureRequest authCaptureRequest1 = mapper
						.readValue(
								new File(Thread.currentThread()
										.getContextClassLoader()
										.getResource("AuthCaptureRequest.json")
										.toURI()), AuthCaptureRequest.class);
				
				Sale sale1 = saleApi.createSale(authCaptureRequest1);
				String id = sale1.getId();
				// Run Refund
				RefundRequest refundRequest = mapper.readValue(
						new File(Thread.currentThread().getContextClassLoader()
								.getResource("RefundRequest.json").toURI()),
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
				AuthCaptureRequest authCaptureRequest1 = mapper
						.readValue(
								new File(Thread.currentThread()
										.getContextClassLoader()
										.getResource("AuthCaptureRequest.json")
										.toURI()), AuthCaptureRequest.class);
				S
				Sale sale1 = saleApi.createSale(authCaptureRequest1);
				String id = sale1.getId();
				// Run Reversal
				ReverseAuthRequest reverseAuth = mapper
						.readValue(
								new File(Thread.currentThread()
										.getContextClassLoader()
										.getResource("ReverseAuthRequest.json")
										.toURI()), ReverseAuthRequest.class);
				
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

				AuthCaptureRequest authCaptureRequest1 = mapper
						.readValue(
								new File(Thread.currentThread()
										.getContextClassLoader()
										.getResource("AuthCaptureRequest.json")
										.toURI()), AuthCaptureRequest.class);
				// Perform an authorization
				Sale sale1 = saleApi.createSale(authCaptureRequest1);
				String id = sale1.getId();
				VoidRequest voidRequest = mapper
						.readValue(
								new File(Thread.currentThread()
										.getContextClassLoader()
										.getResource("AuthCaptureRequest.json")
										.toURI()), VoidRequest.class);
				com.cybersource.payments.model.Void voidOutput = voidApi
						.voidSale(id, voidRequest);

			} catch (ApiException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		default:
			break;
		}
	}

}
