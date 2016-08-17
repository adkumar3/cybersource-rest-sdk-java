package com.visa.payments.api;

import com.visa.payments.ApiException;
import com.visa.payments.ApiClient;
import com.visa.payments.Configuration;
import com.visa.payments.Pair;
import com.visa.payments.TypeRef;

import java.util.*;

import com.visa.payments.model.AuthorizationLinks;
import com.visa.payments.model.TransactionSearch;
import com.visa.payments.model.CreditCollection;
import com.visa.payments.model.VoidRequest;
import com.visa.payments.model.AuthCaptureRequest;
import com.visa.payments.model.ResponseStatusDetails;
import com.visa.payments.model.ErrorResource;
import com.visa.payments.model.TransactionSearchCollection;
import com.visa.payments.model.Capture;
import com.visa.payments.model.Item;
import com.visa.payments.model.CaptureCollection;
import com.visa.payments.model.BillTo;
import com.visa.payments.model.Void;
import com.visa.payments.model.GetRefund;
import com.visa.payments.model.GetSale;
import com.visa.payments.model.GetCredit;
import com.visa.payments.model.SaleCollection;
import com.visa.payments.model.AuthorizationCollection;
import com.visa.payments.model.CollectionLinks;
import com.visa.payments.model.Payment;
import com.visa.payments.model.Refund;
import com.visa.payments.model.Transaction;
import com.visa.payments.model.ResponseStatus;
import com.visa.payments.model.Link;
import com.visa.payments.model.GetCapture;
import com.visa.payments.model.GetSaleLinks;
import com.visa.payments.model.Sale;
import com.visa.payments.model.CaptureLinks;
import com.visa.payments.model.GetCaptureLinks;
import com.visa.payments.model.CreditRequest;
import com.visa.payments.model.GetAuthorizationLinks;
import com.visa.payments.model.ReverseAuthRequest;
import com.visa.payments.model.SaleLinks;
import com.visa.payments.model.Authorization;
import com.visa.payments.model.Credit;
import com.visa.payments.model.MerchantDescriptor;
import com.visa.payments.model.RefundLinks;
import com.visa.payments.model.MerchantDefinedData;
import com.visa.payments.model.ReversedAuthorization;
import com.visa.payments.model.TransactionSearchRequest;
import com.visa.payments.model.CreditLinks;
import com.visa.payments.model.SelfLink;
import com.visa.payments.model.Error;
import com.visa.payments.model.RefundCollection;
import com.visa.payments.model.SearchResult;
import com.visa.payments.model.Terminal;
import com.visa.payments.model.GetAuthorization;
import com.visa.payments.model.RefundRequest;
import com.visa.payments.model.Links;
import com.visa.payments.model.ShipTo;
import com.visa.payments.model.CaptureRequest;


import java.io.File;
import java.util.Map;
import java.util.HashMap;


public class RefundsApi {
  private ApiClient apiClient;

  public RefundsApi(Configuration configuration) {
    this.apiClient = new ApiClient(configuration);
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Lists refunds for a capture.
   * Returns a list of refunds for a particular capture transaction.
   * @param captureId The ID of the capture to refund.
   * @param offset offset
   * @param limit limit
   * @return List<RefundCollection>
   */
  public List<RefundCollection> getCaptureRefunds (String captureId, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'captureId' is set
    if (captureId == null) {
       throw new ApiException(400, "Missing the required parameter 'captureId' when calling getCaptureRefunds");
    }
    

    // create path and map variables
    String path = "payments/v1/captures/{id}/refunds".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "captureId" + "\\}", apiClient.escapeString(captureId.toString()));

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
    
    TypeRef returnType = new TypeRef<List<RefundCollection>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Refund a captured payment.
   * Creates a refund for a particular capture.
   * @param id ID of the capture to refund.
   * @param request Capture request data.
   * @return Refund
   */
  public Refund refundCapture (String id, RefundRequest request) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling refundCapture");
    }
    

    // create path and map variables
    String path = "payments/v1/captures/{id}/refunds".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<Refund>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * List refunds.
   * Lists all successful refunds.
   * @param offset offset
   * @param limit limit
   * @return RefundCollection
   */
  public RefundCollection getRefunds (Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "payments/v1/refunds".replaceAll("\\{format\\}","json");

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
    
    TypeRef returnType = new TypeRef<RefundCollection>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Retrieve a refund.
   * Retrieves a specific refund transaction by specifying the ID of the refund.
   * @param id The ID of the refund.
   * @return GetRefund
   */
  public GetRefund getRefund (String id) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling getRefund");
    }
    

    // create path and map variables
    String path = "payments/v1/refunds/{id}".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<GetRefund>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * List refunds for a sale.
   * Returns a list of refunds for a particular sale transaction.
   * @param saleId The ID of the sale to refund.
   * @param offset offset
   * @param limit limit
   * @return RefundCollection
   */
  public RefundCollection getSaleRefunds (String saleId, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'saleId' is set
    if (saleId == null) {
       throw new ApiException(400, "Missing the required parameter 'saleId' when calling getSaleRefunds");
    }
    

    // create path and map variables
    String path = "payments/v1/sales/{id}/refunds".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "saleId" + "\\}", apiClient.escapeString(saleId.toString()));

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
    
    TypeRef returnType = new TypeRef<RefundCollection>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
  /**
   * Refund a sale payment.
   * Creates a refund for a particular sale.
   * @param id ID of the sale to refund.
   * @param request Sale request data.
   * @return Refund
   */
  public Refund refundSale (String id, RefundRequest request) throws ApiException {
    Object postBody = request;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling refundSale");
    }
    

    // create path and map variables
    String path = "payments/v1/sales/{id}/refunds".replaceAll("\\{format\\}","json")
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
    
    TypeRef returnType = new TypeRef<Refund>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, returnType);
    
  }
  
}

