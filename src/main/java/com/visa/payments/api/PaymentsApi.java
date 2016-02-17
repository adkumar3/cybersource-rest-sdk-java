package com.visa.payments.api;

import com.visa.payments.ApiException;
import com.visa.payments.ApiClient;
import com.visa.payments.Configuration;
import com.visa.payments.Pair;
import com.visa.payments.TypeRef;

import java.util.*;

import com.visa.payments.model.AuthorizationLinks;
import com.visa.payments.model.Sale;
import com.visa.payments.model.TransactionSearch;
import com.visa.payments.model.CaptureLinks;
import com.visa.payments.model.CreditCollection;
import com.visa.payments.model.VoidRequest;
import com.visa.payments.model.GetCaptureLinks;
import com.visa.payments.model.CreditRequest;
import com.visa.payments.model.AuthCaptureRequest;
import com.visa.payments.model.GetAuthorizationLinks;
import com.visa.payments.model.ResponseStatusDetails;
import com.visa.payments.model.ErrorResource;
import com.visa.payments.model.TransactionSearchCollection;
import com.visa.payments.model.SaleLinks;
import com.visa.payments.model.Capture;
import com.visa.payments.model.Authorization;
import com.visa.payments.model.Item;
import com.visa.payments.model.CaptureCollection;
import com.visa.payments.model.Credit;
import com.visa.payments.model.MerchantDescriptor;
import com.visa.payments.model.BillTo;
import com.visa.payments.model.RefundLinks;
import com.visa.payments.model.Void;
import com.visa.payments.model.GetRefund;
import com.visa.payments.model.MerchantDefinedData;
import com.visa.payments.model.GetSale;
import com.visa.payments.model.GetCredit;
import com.visa.payments.model.SaleCollection;
import com.visa.payments.model.TransactionSearchRequest;
import com.visa.payments.model.CreditLinks;
import com.visa.payments.model.SelfLink;
import com.visa.payments.model.AuthorizationCollection;
import com.visa.payments.model.Error;
import com.visa.payments.model.RefundCollection;
import com.visa.payments.model.SearchResult;
import com.visa.payments.model.CollectionLinks;
import com.visa.payments.model.GetAuthorization;
import com.visa.payments.model.Payment;
import com.visa.payments.model.Refund;
import com.visa.payments.model.RefundRequest;
import com.visa.payments.model.Transaction;
import com.visa.payments.model.ResponseStatus;
import com.visa.payments.model.Links;
import com.visa.payments.model.ShipTo;
import com.visa.payments.model.CaptureRequest;
import com.visa.payments.model.Link;
import com.visa.payments.model.GetCapture;
import com.visa.payments.model.GetSaleLinks;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class PaymentsApi {
  private ApiClient apiClient;

  public PaymentsApi(Configuration configuration) {
    this.apiClient = new ApiClient(configuration);
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Get the error detail, including the associated request and response data, by specifying the Correlation ID that uniquely identifies the error.
   * Get the error detail, including the associated request and response data, by specifying the Correlation ID that uniquely identifies the error.
   * @param id Correlation id
   * @return ErrorResource
   */
  public ErrorResource getError (String id) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling getError");
    }
    

    // create path and map variables
    String path = "payments/v1/errors/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    String accept = null;
    final String[] accepts = {
      "application/json"
    };
    accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<ErrorResource>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Transaction Search
   * Transaction search
   * @param request Search transaction request 
   * @param offset This paging parameter is used to specify the page number.
   * @param limit This paging parameter is used to specify the page size, i.e. number of records.
   * @return TransactionSearchCollection
   */
  public TransactionSearchCollection searchPayment (TransactionSearchRequest request, Integer offset, Integer limit) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'request' is set
    if (request == null) {
       throw new ApiException(400, "Missing the required parameter 'request' when calling searchPayment");
    }
    

    // create path and map variables
    String path = "payments/v1/search".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    
    queryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    

    

    

    String accept = null;
    

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<TransactionSearchCollection>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Get submitted authorizations, sales, captures, or refunds
   * The payments endpoint returns information about your submitted payments. The response includes transaction details.
   * @param id transaction id
   * @return Transaction
   */
  public Transaction getPayment (String id) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling getPayment");
    }
    

    // create path and map variables
    String path = "payments/v1/search/{id}".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<Transaction>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
}
