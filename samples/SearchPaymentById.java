package com.visa.payments.samples;

import com.visa.payments.ApiException;
import com.visa.payments.Configuration;
import com.visa.payments.Configuration.ConfigurationBuilder;
import com.visa.payments.model.Transaction;
import com.visa.payments.api.PaymentsApi;

public class SearchPaymentById {
	public static void main(String[] args) {
		// Set ApiKey, secretKey and timeoutMilliseconds
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setApiKey("apikey").setSecretKey("secretkey")
				.setTimeoutMilliseconds(30000);

		Configuration config = builder.build();
		PaymentsApi paymentApi = new PaymentsApi(config);
		if (args.length != 1) {
			System.out
					.println("Transaction ID is not provided in command line argument. ");
			System.exit(1);
		} else if (args[0].equals("-help")) {
			System.out
					.println("Specify a transaction ID to return a specific payment resource"
							+ "\n"
							+ "Use below command to Search Payment by ID"
							+ "\n " + "java SearchPaymentById [transaction ID]");
			System.exit(1);
		}
		// Specify a transaction ID to return a specific payment resource.
		// This will get submitted authorizations, sales, captures, or refunds.
		String transactionId = args[0];
		try {
			Transaction transaction = paymentApi.getPayment(transactionId);
			System.out.println("Transaction output: " + transaction);
		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
