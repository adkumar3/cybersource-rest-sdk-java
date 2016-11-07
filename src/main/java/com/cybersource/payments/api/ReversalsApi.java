package com.cybersource.payments.api;

import com.cybersource.payments.ApiClient;
import com.cybersource.payments.ApiException;
import com.cybersource.payments.Configuration;
import com.cybersource.payments.Pair;
import com.cybersource.payments.TypeRef;
import com.cybersource.payments.model.AuthCaptureRequest;
import com.cybersource.payments.model.Authorization;
import com.cybersource.payments.model.AuthorizationCollection;
import com.cybersource.payments.model.AuthorizationLinks;
import com.cybersource.payments.model.BillTo;
import com.cybersource.payments.model.Capture;
import com.cybersource.payments.model.CaptureCollection;
import com.cybersource.payments.model.CaptureLinks;
import com.cybersource.payments.model.CaptureRequest;
import com.cybersource.payments.model.CollectionLinks;
import com.cybersource.payments.model.Credit;
import com.cybersource.payments.model.CreditCollection;
import com.cybersource.payments.model.CreditLinks;
import com.cybersource.payments.model.CreditRequest;
import com.cybersource.payments.model.Error;
import com.cybersource.payments.model.ErrorResource;
import com.cybersource.payments.model.GetAuthorization;
import com.cybersource.payments.model.GetAuthorizationLinks;
import com.cybersource.payments.model.GetCapture;
import com.cybersource.payments.model.GetCaptureLinks;
import com.cybersource.payments.model.GetCredit;
import com.cybersource.payments.model.GetRefund;
import com.cybersource.payments.model.GetSale;
import com.cybersource.payments.model.GetSaleLinks;
import com.cybersource.payments.model.Item;
import com.cybersource.payments.model.Link;
import com.cybersource.payments.model.Links;
import com.cybersource.payments.model.MerchantDefinedData;
import com.cybersource.payments.model.MerchantDescriptor;
import com.cybersource.payments.model.Payment;
import com.cybersource.payments.model.Refund;
import com.cybersource.payments.model.RefundCollection;
import com.cybersource.payments.model.RefundLinks;
import com.cybersource.payments.model.RefundRequest;
import com.cybersource.payments.model.ResponseStatus;
import com.cybersource.payments.model.ResponseStatusDetails;
import com.cybersource.payments.model.ReverseAuthRequest;
import com.cybersource.payments.model.ReversedAuthorization;
import com.cybersource.payments.model.Sale;
import com.cybersource.payments.model.SaleCollection;
import com.cybersource.payments.model.SaleLinks;
import com.cybersource.payments.model.SearchResult;
import com.cybersource.payments.model.SelfLink;
import com.cybersource.payments.model.ShipTo;
import com.cybersource.payments.model.Terminal;
import com.cybersource.payments.model.Transaction;
import com.cybersource.payments.model.TransactionSearch;
import com.cybersource.payments.model.TransactionSearchCollection;
import com.cybersource.payments.model.TransactionSearchRequest;
import com.cybersource.payments.model.Void;
import com.cybersource.payments.model.VoidRequest;

import java.util.*;
import java.io.File;
import java.util.Map;
import java.util.HashMap;


public class ReversalsApi {
  private ApiClient apiClient;

  public ReversalsApi(Configuration configuration) {
    this.apiClient = new ApiClient(configuration);
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Reverse a payment authorization
   * Reverse a payment authorization given an id
   * @param id authorize transaction id
   * @param request Reverse authorization request data
   * @return ReversedAuthorization
   */
  public ReversedAuthorization reverseAuthorization (String id, ReverseAuthRequest request) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling reverseAuthorization");
    }
    
    // verify the required parameter 'request' is set
    if (request == null) {
       throw new ApiException(400, "Missing the required parameter 'request' when calling reverseAuthorization");
    }
    

    // create path and map variables
    String path = "payments/v1/authorizations/{id}/reversals".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    String accept = null;
    

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<ReversedAuthorization>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Retrieve a reversed authorization
   * Retrieve a reversed authorization by id
   * @param id Unique identifier for the transaction
   * @return ReversedAuthorization
   */
  public ReversedAuthorization getAuthReversal (String id) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling getAuthReversal");
    }
    

    // create path and map variables
    String path = "payments/v1/reversals/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    String accept = null;
    

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<ReversedAuthorization>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
}

