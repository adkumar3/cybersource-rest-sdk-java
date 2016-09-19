import java.math.BigDecimal;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.visa.payments.ApiException;
import com.visa.payments.Configuration;
import com.visa.payments.Configuration.ConfigurationBuilder;
import com.visa.payments.model.AuthCaptureRequest;
import com.visa.payments.model.GetSale;
import com.visa.payments.model.Payment;
import com.visa.payments.api.SalesApi;

public class Sale {
	public static void main(String[] args) {
		// Set ApiKey, secretKey and timeoutMilliseconds
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setApiKey("apikey")
			.setSecretKey("secretkey")
			.setTimeoutMilliseconds(30000);
		String nextYear = Integer.toString((Calendar.getInstance().get(Calendar.YEAR) + 1));

		Configuration config = builder.build();
		SalesApi saleApi = new SalesApi(config);

		AuthCaptureRequest authRequest = new AuthCaptureRequest();
		Payment payment = new Payment();
		payment.setCardNumber("4111111111111111");
		payment.setCardExpirationMonth("10");
		payment.setCardExpirationYear(nextYear);

		authRequest.setPayment(payment);
		authRequest.setAmount(new BigDecimal(5.00));
		authRequest.setCurrency("USD");
		authRequest.setReferenceId("123");

		try {
			// Perform a sale
			com.visa.payments.model.Sale sale = saleApi.createSale(authRequest);
			String saleId = sale.getId();
			System.out.println("Sale created and returned with saleId: " + saleId);
			
			TimeUnit.SECONDS.sleep(2);
			
			// Retrieve a sale
			GetSale getSale = saleApi.getSale(saleId);
			System.out.println("Retrieve a sale: " + getSale);
		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
