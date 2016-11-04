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


public class VoidsApi {
  private ApiClient apiClient;

  public VoidsApi(Configuration configuration) {
    this.apiClient = new ApiClient(configuration);
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Void a particular captured transaction by specifying the capture ID.
   * 
   * @param id Capture transaction ID.
   * @param request Void request data.
   * @return Void
   */
  public Void voidCapture (String id, VoidRequest request) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling voidCapture");
    }
    

    // create path and map variables
    String path = "payments/v1/captures/{id}/voids".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<Void>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Void a credit.
   * Void a credit by specifying the credit ID.
   * @param id Credit ID.
   * @param request Request data.
   * @return Void
   */
  public Void voidCredit (String id, VoidRequest request) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling voidCredit");
    }
    

    // create path and map variables
    String path = "payments/v1/credits/{id}/voids".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<Void>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Void a refund transaction.
   * 
   * @param id Refund transaction ID.
   * @param request Void request data.
   * @return Void
   */
  public Void voidRefund (String id, VoidRequest request) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling voidRefund");
    }
    

    // create path and map variables
    String path = "payments/v1/refunds/{id}/voids".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<Void>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Void a particular sale transaction by specifying the sale ID.
   * 
   * @param id Sales transaction ID.
   * @param request Void request data.
   * @return Void
   */
  public Void voidSale (String id, VoidRequest request) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling voidSale");
    }
    

    // create path and map variables
    String path = "payments/v1/sales/{id}/voids".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<Void>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Retrieve a void by specifying the void ID.
   * 
   * @param id Unique identifier for the transaction.
   * @return Void
   */
  public Void getVoid (String id) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling getVoid");
    }
    

    // create path and map variables
    String path = "payments/v1/voids/{id}".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<Void>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
}

