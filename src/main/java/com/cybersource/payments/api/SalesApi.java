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


public class SalesApi {
  private ApiClient apiClient;

  public SalesApi(Configuration configuration) {
    this.apiClient = new ApiClient(configuration);
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Search for all sales.
   * Search for all sales transactions using several paging options to narrow the results.
   * @param offset Element number
   * @param limit Page size
   * @return SaleCollection
   */
  public SaleCollection getSales (Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "payments/v1/sales".replaceAll("\\{format\\}","json");

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
    
    TypeRef returnType = new TypeRef<SaleCollection>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Perform a sale.
   * A sale transaction authorizes and captures a payment.
   * @param request Perform a sale.
   * @return Sale
   */
  public Sale createSale (AuthCaptureRequest request) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'request' is set
    if (request == null) {
       throw new ApiException(400, "Missing the required parameter 'request' when calling createSale");
    }
    

    // create path and map variables
    String path = "payments/v1/sales".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    String accept = null;
    

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<Sale>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Search for a sale.
   * Search for a specific sale transaction by specifying its ID.
   * @param id Sales ID
   * @return GetSale
   */
  public GetSale getSale (String id) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling getSale");
    }
    

    // create path and map variables
    String path = "payments/v1/sales/{id}".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<GetSale>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
}

