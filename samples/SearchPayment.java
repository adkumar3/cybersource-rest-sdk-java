import java.math.BigDecimal;

import com.visa.payments.ApiException;
import com.visa.payments.Configuration;
import com.visa.payments.Configuration.ConfigurationBuilder;
import com.visa.payments.model.AuthCaptureRequest;
import com.visa.payments.model.Payment;
import com.visa.payments.model.TransactionSearchRequest;
import com.visa.payments.model.TransactionSearchCollection;
import com.visa.payments.api.PaymentsApi;

public class SearchPayment {
	public static void main(String[] args) {
		// Set ApiKey, secretKey and timeoutMilliseconds
		ConfigurationBuilder builder = new ConfigurationBuilder();
                builder.setApiKey("apikey")
                                .setSecretKey("secretkey")
				.setTimeoutMilliseconds(30000);

		Configuration config = builder.build();
		PaymentsApi paymentApi = new PaymentsApi(config);

		AuthCaptureRequest authRequest = new AuthCaptureRequest();
		Payment payment = new Payment();
		payment.setCardNumber("4111111111111111");
		payment.setCardExpirationMonth("10");
		payment.setCardExpirationYear("2016");

		authRequest.setPayment(payment);
		authRequest.setAmount(new BigDecimal(5.00));
		authRequest.setCurrency("USD");
		authRequest.setReferenceId("123");

		try {
			// Search for a transaction
			TransactionSearchRequest request = new TransactionSearchRequest();
			request.setQuery("accountSuffix=1111");
			TransactionSearchCollection collection = paymentApi.searchPayment(request, null, null);
			System.out.println("Search payment collection: " + collection);
		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
