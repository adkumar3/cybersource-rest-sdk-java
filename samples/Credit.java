import java.math.BigDecimal;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.cybersource.payments.ApiException;
import com.cybersource.payments.Configuration;
import com.cybersource.payments.Configuration.ConfigurationBuilder;
import com.cybersource.payments.model.CreditRequest;
import com.cybersource.payments.model.GetCredit;
import com.cybersource.payments.model.Payment;
import com.cybersource.payments.api.CreditsApi;

public class Credit {
	public static void main(String[] args) {
		// Set ApiKey, secretKey and timeoutMilliseconds
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setApiKey("apikey").setSecretKey("secretkey")
				.setTimeoutMilliseconds(30000);
		String nextYear = Integer.toString((Calendar.getInstance().get(
				Calendar.YEAR) + 1));

		Configuration config = builder.build();
		CreditsApi creditApi = new CreditsApi(config);

		CreditRequest creditRequest = new CreditRequest();
		Payment payment = new Payment();
		payment.setCardNumber("4111111111111111");
		payment.setCardExpirationMonth("10");
		payment.setCardExpirationYear(nextYear);

		creditRequest.setPayment(payment);
		creditRequest.setAmount(new BigDecimal(5.00));
		creditRequest.setCurrency("USD");

		try {
			// Perform a credit
			com.cybersource.payments.model.Credit credit = creditApi
					.createCredit(creditRequest);
			String creditId = credit.getId();
			System.out.println("Credit created and returned with creditId: "
					+ creditId);

			// Please note that there could be a delay for the transaction
			// detail to be available for retrieval after a requests is posted
			// to the server for processing.
			TimeUnit.SECONDS.sleep(2);

			// Retrieve a credit
			GetCredit getCredit = creditApi.getCredit(creditId);
			System.out.println("Retrieve a credit: " + getCredit);
		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
