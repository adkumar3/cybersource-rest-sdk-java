import java.math.BigDecimal;
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

public class ApplePay {
    public static void main(String[] args) {
        // Set ApiKey, secretKey and timeoutMilliseconds
        ConfigurationBuilder builder = new ConfigurationBuilder();
                builder.setApiKey("apikey")
                        .setSecretKey("secretkey")
            .setTimeoutMilliseconds(30000);

        Configuration config = builder.build();
        AuthorizationsApi authApi = new AuthorizationsApi(config);
        CapturesApi captureApi = new CapturesApi(config);

        AuthCaptureRequest authCaptureRequest = new AuthCaptureRequest();
        Payment payment = new Payment();
        payment.setEncryptedData("encrypted payment data");
        payment.setEncryptedDescriptor("descriptor of encrypted payment data");
        payment.setEncryptedEncoding("Base64");

        authCaptureRequest.setPayment(payment);
        authCaptureRequest.setAmount(new BigDecimal(5.00));
        authCaptureRequest.setCurrency("USD");
        authCaptureRequest.setReferenceId("123");

        // Identifies Apple Pay as the payment solution that is being used for the transaction:
        // Set the value for this field to 001.
        // Note This unique ID differentiates digital solution transactions within the CyberSource platform for reporting purposes.
        authCaptureRequest.setPaymentSolution("001");
        
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
            captureRequest.setPaymentSolution("001");
            
            Capture capture = captureApi.captureAuthorization(id, captureRequest);
            System.out.println("Capture output against authorization: " + capture);
        } catch (ApiException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}