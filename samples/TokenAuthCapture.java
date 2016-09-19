import java.math.BigDecimal;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.visa.payments.ApiException;
import com.visa.payments.Configuration;
import com.visa.payments.Configuration.ConfigurationBuilder;
import com.visa.payments.model.AuthCaptureRequest;
import com.visa.payments.model.Authorization;
import com.visa.payments.model.Capture;
import com.visa.payments.model.CaptureRequest;
import com.visa.payments.model.GetAuthorization;
import com.visa.payments.model.Payment;
import com.visa.payments.api.AuthorizationsApi;
import com.visa.payments.api.CapturesApi;

public class TokenAuthCapture {
    public static void main(String[] args) {
        // Set ApiKey, secretKey and timeoutMilliseconds
        ConfigurationBuilder builder = new ConfigurationBuilder();
                builder.setApiKey("apikey")
                        .setSecretKey("secretkey")
            .setTimeoutMilliseconds(30000);
        String nextYear = Integer.toString((Calendar.getInstance().get(Calendar.YEAR) + 1));

        Configuration config = builder.build();
        AuthorizationsApi authApi = new AuthorizationsApi(config);
        CapturesApi captureApi = new CapturesApi(config);

        AuthCaptureRequest authCaptureRequest = new AuthCaptureRequest();
        Payment payment = new Payment();
        payment.setCardNumber("network token");
        payment.setCardExpirationMonth("10");
        payment.setCardExpirationYear(nextYear);
        payment.setCavv("my cryptogram");
        payment.setXid("my cryptogram");
        payment.setNetworkTokenTransactionType("1");

        authCaptureRequest.setPayment(payment);
        authCaptureRequest.setCommerceIndicator("vbv");
        authCaptureRequest.setAmount(new BigDecimal(5.00));
        authCaptureRequest.setCurrency("USD");
        authCaptureRequest.setReferenceId("123");

        try {
            // Perform an authorization
            Authorization auth = authApi.createAuthorization(authCaptureRequest);
            String id = auth.getId();
            System.out.println("Authorization created and returned with authId: " + id);
            
            TimeUnit.SECONDS.sleep(2);
            
            // Retrieve an authorization
            GetAuthorization getAuth = authApi.getAuthorization(id);
            System.out.println("Retrieve authorization with authId '" + id + "': " + getAuth);
            
            TimeUnit.SECONDS.sleep(2);
            
            // Perform a capture against an authorization
            CaptureRequest captureRequest = new CaptureRequest();
            captureRequest.setAmount(new BigDecimal(5.00));
            captureRequest.setCurrency("USD");
            captureRequest.setReferenceId("123");
            Capture capture = captureApi.captureAuthorization(id, captureRequest);
            System.out.println("Capture output against authorization: " + capture);
        } catch (ApiException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
