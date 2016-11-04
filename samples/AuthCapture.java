import java.math.BigDecimal;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.cybersource.payments.ApiException;
import com.cybersource.payments.Configuration;
import com.cybersource.payments.Configuration.ConfigurationBuilder;
import com.cybersource.payments.model.AuthCaptureRequest;
import com.cybersource.payments.model.Authorization;
import com.cybersource.payments.model.Capture;
import com.cybersource.payments.model.CaptureRequest;
import com.cybersource.payments.model.GetAuthorization;
import com.cybersource.payments.model.Payment;
import com.cybersource.payments.api.AuthorizationsApi;
import com.cybersource.payments.api.CapturesApi;

public class AuthCapture {
	public static void main(String[] args) {
		// Set ApiKey, secretKey and timeoutMilliseconds
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setApiKey("apikey").setSecretKey("secretkey")
				.setTimeoutMilliseconds(30000);
		String nextYear = Integer.toString((Calendar.getInstance().get(
				Calendar.YEAR) + 1));

		Configuration config = builder.build();
		AuthorizationsApi authApi = new AuthorizationsApi(config);
		CapturesApi captureApi = new CapturesApi(config);

		AuthCaptureRequest authCaptureRequest = new AuthCaptureRequest();
		Payment payment = new Payment();
		payment.setCardNumber("4111111111111111");
		payment.setCardExpirationMonth("10");
		payment.setCardExpirationYear(nextYear);

		authCaptureRequest.setPayment(payment);
		authCaptureRequest.setAmount(new BigDecimal(5.00));
		authCaptureRequest.setCurrency("USD");
		authCaptureRequest.setReferenceId("123");

		try {
			// Perform an authorization
			Authorization auth = authApi
					.createAuthorization(authCaptureRequest);
			String id = auth.getId();
			System.out
					.println("Authorization created and returned with authId: "
							+ id);

			// Please note that there could be a delay for the transaction
			// detail to be available for retrieval after a requests is posted
			// to the server for processing.
			TimeUnit.SECONDS.sleep(2);

			// Retrieve an authorization
			GetAuthorization getAuth = authApi.getAuthorization(id);
			System.out.println("Retrieve authorization with authId '" + id
					+ "': " + getAuth);

			// Perform a capture against an authorization
			CaptureRequest captureRequest = new CaptureRequest();
			captureRequest.setAmount(new BigDecimal(5.00));
			captureRequest.setCurrency("USD");
			captureRequest.setReferenceId("123");
			Capture capture = captureApi.captureAuthorization(id,
					captureRequest);
			System.out.println("Capture output against authorization: "
					+ capture);
		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
