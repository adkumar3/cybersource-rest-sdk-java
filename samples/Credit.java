import java.math.BigDecimal;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.visa.payments.ApiException;
import com.visa.payments.Configuration;
import com.visa.payments.Configuration.ConfigurationBuilder;
import com.visa.payments.model.CreditRequest;
import com.visa.payments.model.GetCredit;
import com.visa.payments.model.Payment;
import com.visa.payments.api.CreditsApi;

public class Credit {
	public static void main(String[] args) {
		// Set ApiKey, secretKey and timeoutMilliseconds
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setApiKey("apikey")
			.setSecretKey("secretkey")
			.setTimeoutMilliseconds(30000);
		String nextYear = Integer.toString((Calendar.getInstance().get(Calendar.YEAR) + 1));

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
			com.visa.payments.model.Credit credit = creditApi.createCredit(creditRequest);
			String creditId = credit.getId();
			System.out.println("Credit created and returned with creditId: " + creditId);
			
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
