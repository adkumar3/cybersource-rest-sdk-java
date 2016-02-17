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
   * Search for all sales
   * Search for all sales
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
   * Perform a sale
   * Perform a sale
   * @param request Perform a sale
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
   * Search for a specific sale
   * Search for sale given an id
   * @param id Search for sale given an id
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
