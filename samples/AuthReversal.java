import java.math.BigDecimal;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.visa.payments.ApiException;
import com.visa.payments.Configuration;
import com.visa.payments.Configuration.ConfigurationBuilder;
import com.visa.payments.model.AuthCaptureRequest;
import com.visa.payments.model.ReverseAuthRequest;
import com.visa.payments.model.Authorization;
import com.visa.payments.model.ReversedAuthorization;
import com.visa.payments.model.Payment;
import com.visa.payments.api.AuthorizationsApi;
import com.visa.payments.api.ReversalsApi;

public class AuthReversal {
	public static void main(String[] args) {
		// Set ApiKey, secretKey and timeoutMilliseconds
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setApiKey("apikey").setSecretKey("secretkey")
				.setTimeoutMilliseconds(30000);
		String nextYear = Integer.toString((Calendar.getInstance().get(
				Calendar.YEAR) + 1));

		Configuration config = builder.build();
		AuthorizationsApi authApi = new AuthorizationsApi(config);
		ReversalsApi reversalsApi = new ReversalsApi(config);

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
			System.out.println("Authorization created: " + auth);

			// Reverse the authorization
			ReverseAuthRequest reverseAuthRequest = new ReverseAuthRequest();
			reverseAuthRequest.setAmount(new BigDecimal(5.00));
			reverseAuthRequest.setCurrency("USD");
			ReversedAuthorization reversed = reversalsApi.reverseAuthorization(
					id, reverseAuthRequest);
			System.out.println("Reversed authorization: " + reversed);
		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
