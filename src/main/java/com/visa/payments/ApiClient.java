package com.visa.payments;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.client.WebResource.Builder;

import javax.ws.rs.core.Response.Status.Family;


import java.math.BigInteger;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import java.net.URLEncoder;


import java.io.UnsupportedEncodingException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ApiClient {
  private static final int DEFAULT_CONNECTION_TIMEOUT = 30000;
  private Map<String, Client> hostMap = new HashMap<String, Client>();
  private Map<String, String> defaultHeaderMap = new HashMap<String, String>();
  private boolean debugging = false;
  private String basePath = "https://sandbox.api.visa.com/cybersource/";
  private JSON json = new JSON();

  private DateFormat dateFormat;
  private String apiKey = "";
  private String secretKey = "";
  private int timeoutMilliseconds = 0;

  public ApiClient(Configuration configuration) {
    // Use ISO 8601 format for date and datetime.
    // See https://en.wikipedia.org/wiki/ISO_8601
    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    // Use UTC as the default time zone.
    this.dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

    // Set default User-Agent.
    setUserAgent("Java-Swagger");

    this.apiKey = configuration.getApiKey();
    this.secretKey = configuration.getSecretKey();
    this.timeoutMilliseconds = configuration.getTimeoutMilliseconds();
  }

  public String getBasePath() {
    return basePath;
  }

  public ApiClient setBasePath(String basePath) {
    this.basePath = basePath;
    return this;
  }


  /**
   * Get the map of API base paths to Jersey Client objects
   */
  public Map<String, Client> getHostMap() {
    return hostMap;
  }

  /**
   * Set the User-Agent header's value (by adding to the default header map).
   */
  public ApiClient setUserAgent(String userAgent) {
    addDefaultHeader("User-Agent", userAgent);
    return this;
  }

  /**
   * Add a default header.
   *
   * @param key The header's key
   * @param value The header's value
   */
  public ApiClient addDefaultHeader(String key, String value) {
    defaultHeaderMap.put(key, value);
    return this;
  }

  /**
   * Check that whether debugging is enabled for this API client.
   */
  public boolean isDebugging() {
    return debugging;
  }

  /**
   * Enable/disable debugging for this API client.
   *
   * @param debugging To enable (true) or disable (false) debugging
   */
  public ApiClient setDebugging(boolean debugging) {
    this.debugging = debugging;
    return this;
  }

  /**
   * Get the date format used to parse/format date parameters.
   */
  public DateFormat getDateFormat() {
    return dateFormat;
  }

  /**
   * Set the date format used to parse/format date parameters.
   */
  public ApiClient getDateFormat(DateFormat dateFormat) {
    this.dateFormat = dateFormat;
    return this;
  }

  /**
   * Parse the given string into Date object.
   */
  public Date parseDate(String str) {
    try {
      return dateFormat.parse(str);
    } catch (java.text.ParseException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Format the given Date object into string.
   */
  public String formatDate(Date date) {
    return dateFormat.format(date);
  }

  /**
   * Format the given parameter object into string.
   */
  public String parameterToString(Object param) {
    if (param == null) {
      return "";
    } else if (param instanceof Date) {
      return formatDate((Date) param);
    } else if (param instanceof Collection) {
      StringBuilder b = new StringBuilder();
      for(Object o : (Collection)param) {
        if(b.length() > 0) {
          b.append(",");
        }
        b.append(String.valueOf(o));
      }
      return b.toString();
    } else {
      return String.valueOf(param);
    }
  }

  /*
    Format to {@code Pair} objects.
  */
  public List<Pair> parameterToPairs(String collectionFormat, String name, Object value){
    List<Pair> params = new ArrayList<Pair>();

    // preconditions
    if (name == null || name.isEmpty() || value == null) return params;

    Collection valueCollection = null;
    if (value instanceof Collection) {
      valueCollection = (Collection) value;
    } else {
      params.add(new Pair(name, parameterToString(value)));
      return params;
    }

    if (valueCollection.isEmpty()){
      return params;
    }

    // get the collection format
    collectionFormat = (collectionFormat == null || collectionFormat.isEmpty() ? "csv" : collectionFormat); // default: csv

    // create the params based on the collection format
    if (collectionFormat.equals("multi")) {
      for (Object item : valueCollection) {
        params.add(new Pair(name, parameterToString(item)));
      }

      return params;
    }

    String delimiter = ",";

    if (collectionFormat.equals("csv")) {
      delimiter = ",";
    } else if (collectionFormat.equals("ssv")) {
      delimiter = " ";
    } else if (collectionFormat.equals("tsv")) {
      delimiter = "\t";
    } else if (collectionFormat.equals("pipes")) {
      delimiter = "|";
    }

    StringBuilder sb = new StringBuilder() ;
    for (Object item : valueCollection) {
      sb.append(delimiter);
      sb.append(parameterToString(item));
    }

    params.add(new Pair(name, sb.substring(1)));

    return params;
  }

  /**
   * Select the Accept header's value from the given accepts array:
   *   if JSON exists in the given array, use it;
   *   otherwise use all of them (joining into a string)
   *
   * @param accepts The accepts array to select from
   * @return The Accept header to use. If the given array is empty,
   *   null will be returned (not to set the Accept header explicitly).
   */
  public String selectHeaderAccept(String[] accepts) {
    if (accepts.length == 0) return null;
    if (StringUtil.containsIgnoreCase(accepts, "application/json")) return "application/json";
    return StringUtil.join(accepts, ",");
  }

  /**
   * Select the Content-Type header's value from the given array:
   *   if JSON exists in the given array, use it;
   *   otherwise use the first one of the array.
   *
   * @param contentTypes The Content-Type array to select from
   * @return The Content-Type header to use. If the given array is empty,
   *   JSON will be used.
   */
  public String selectHeaderContentType(String[] contentTypes) {
    if (contentTypes.length == 0) return "application/json";
    if (StringUtil.containsIgnoreCase(contentTypes, "application/json")) return "application/json";
    return contentTypes[0];
  }

  /**
   * Escape the given string to be used as URL query value.
   */
  public String escapeString(String str) {
    try {
      return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
    } catch (UnsupportedEncodingException e) {
      return str;
    }
  }

  /**
   * Serialize the given Java object into string according the given
   * Content-Type (only JSON is supported for now).
   */
  public String serialize(Object obj, String contentType) throws ApiException {
    if (contentType.startsWith("application/json")) {
      return json.serialize(obj);
    } else {
      throw new ApiException(400, "can not serialize object into Content-Type: " + contentType);
    }
  }

  /**
   * Deserialize response body to Java object according to the Content-Type.
   */
  public <T> T deserialize(ClientResponse response, TypeRef returnType) throws ApiException {
    String contentType = null;
    List<String> contentTypes = response.getHeaders().get("Content-Type");
    if (contentTypes != null && !contentTypes.isEmpty())
      contentType = contentTypes.get(0);
    if (contentType == null)
      throw new ApiException(500, "missing Content-Type in response");

    String body;
    if (response.hasEntity())
      body = (String) response.getEntity(String.class);
    else
      body = "";

    if (contentType.startsWith("application/json") || contentType.startsWith("application/hal+json")) {
      return json.deserialize(body, returnType);
    } else {
      throw new ApiException(500, "can not deserialize Content-Type: " + contentType);
    }
  }

  /**
   * Invoke API by sending HTTP request with the given options.
   *
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "POST", "PUT", and "DELETE"
   * @param queryParams The query parameters
   * @param body The request body object
   * @param headerParams The header parameters
   * @param formParams The form parameters
   * @param accept The request's Accept header
   * @param contentType The request's Content-Type header
   * @param returnType The return type into which to deserialize the response
   * @return The response body in type of string
   */
  public <T> T invokeAPI(String path, String method, List<Pair> queryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String accept, String contentType, TypeRef returnType) throws ApiException {
    Client client = getClient();

    StringBuilder b = new StringBuilder();
    b.append("?");
    queryParams.add(new Pair("apiKey", this.apiKey));
    for (Pair queryParam : queryParams){
      if (!queryParam.getName().isEmpty()) {
        b.append(escapeString(queryParam.getName()));
        b.append("=");
        b.append(escapeString(queryParam.getValue()));
        b.append("&");
      }
    }

    String querystring = b.substring(0, b.length() - 1);

    Builder builder;
    if (accept == null)
      builder = client.resource(basePath + path + querystring).getRequestBuilder();
    else
      builder = client.resource(basePath + path + querystring).accept(accept);

    for (String key : headerParams.keySet()) {
      builder = builder.header(key, headerParams.get(key));
    }
    for (String key : defaultHeaderMap.keySet()) {
      if (!headerParams.containsKey(key)) {
        builder = builder.header(key, defaultHeaderMap.get(key));
      }
    }

    String encodedFormParams = null;
    if (contentType.startsWith("application/x-www-form-urlencoded")) {
      encodedFormParams = this.getXWWWFormUrlencodedParams(formParams);
    }

    ClientResponse response = null;
    
    String requestBody = "";

    if ("GET".equals(method)) {
      builder.header("x-pay-token", generateXPayToken(path, querystring.substring(1), ""));
      response = (ClientResponse) builder.get(ClientResponse.class);
    } else if ("POST".equals(method)) {
      if (encodedFormParams != null) {
        builder.type(contentType);
        requestBody = encodedFormParams;
      } else if (body == null) {
        requestBody = null;
      } else {
        builder.type(contentType);
        requestBody = serialize(body, contentType);
      }
      builder.header("x-pay-token", generateXPayToken(path, querystring.substring(1), requestBody));
      response = builder.post(ClientResponse.class, requestBody);
    } else if ("PUT".equals(method)) {
      if (encodedFormParams != null) {
        requestBody = encodedFormParams;
        builder.type(contentType);
      } else {
        if (body != null) {
          builder.type(contentType);
        }
        requestBody = serialize(body, contentType);
      }
      builder.header("x-pay-token", generateXPayToken(path, querystring, requestBody));
      response = builder.put(ClientResponse.class, requestBody);
    } else if ("DELETE".equals(method)) {
      if (encodedFormParams != null) {
        builder.header("x-pay-token", generateXPayToken(path, querystring, encodedFormParams));
        response = builder.type(contentType).delete(ClientResponse.class, encodedFormParams);
      } else if(body == null) {
        builder.header("x-pay-token", generateXPayToken(path, querystring, ""));
        response = builder.delete(ClientResponse.class);
      } else {
        requestBody = serialize(body, contentType);
        builder.header("x-pay-token", generateXPayToken(path, querystring, requestBody));
        response = builder.type(contentType).delete(ClientResponse.class);
      }
    } else {
      throw new ApiException(500, "unknown method type " + method);
    }

    if (response.getStatusInfo() == ClientResponse.Status.NO_CONTENT) {
      return null;
    } else if (response.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
      if (returnType == null)
        return null;
      else
        return deserialize(response, returnType);
    } else {
      String message = "error";
      String respBody = null;
      if (response.hasEntity()) {
        respBody = String.valueOf(response.getEntity(String.class));
        message = respBody;
        
        TypeRef errorType = new TypeRef<com.visa.payments.model.Error>() {};
        com.visa.payments.model.Error error = json.deserialize(message, errorType);
        throw new ApiException(
          response.getStatusInfo().getStatusCode(),
          message,
          error,
          response.getHeaders(),
          respBody);
      }
      throw new ApiException(
        response.getStatusInfo().getStatusCode(),
        message,
        response.getHeaders(),
        respBody);
    }
  }

  /**
   * Encode the given form parameters as request body.
   */
  private String getXWWWFormUrlencodedParams(Map<String, Object> formParams) {
    StringBuilder formParamBuilder = new StringBuilder();

    for (Entry<String, Object> param : formParams.entrySet()) {
      String keyStr = param.getKey();
      String valueStr = parameterToString(param.getValue());
      try {
        formParamBuilder.append(URLEncoder.encode(param.getKey(), "utf8"))
            .append("=")
            .append(URLEncoder.encode(valueStr, "utf8"));
        formParamBuilder.append("&");
      } catch (UnsupportedEncodingException e) {
        // move on to next
      }
    }

    String encodedFormParams = formParamBuilder.toString();
    if (encodedFormParams.endsWith("&")) {
      encodedFormParams = encodedFormParams.substring(0, encodedFormParams.length() - 1);
    }

    return encodedFormParams;
  }

  /**
   * Get an existing client or create a new client to handle HTTP request.
   */
  private Client getClient() {
    if(!hostMap.containsKey(basePath)) {
      Client client = Client.create();
      if (timeoutMilliseconds > 0) {
	      client.setConnectTimeout(timeoutMilliseconds);
	    } else {
	  	  client.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
	    }
      if (debugging)
        client.addFilter(new LoggingFilter());
      hostMap.put(basePath, client);
    }
    return hostMap.get(basePath);
  }

  private String generateXPayToken(String resourcePath, String queryParams, String body) {
    String timestamp = (System.currentTimeMillis() / 1000L) + "";
    String preHashString = timestamp + resourcePath + queryParams + body;
    String hash = getDigest(preHashString);
    return "xv2:" + timestamp + ":" + hash;
  }

  private String getDigest(String data) {
    try {
      SecretKeySpec keySpec;
      keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
      Mac sha256HMAC = Mac.getInstance("HmacSHA256");
      sha256HMAC.init(keySpec);
      
      byte[] hashByte = sha256HMAC.doFinal(data.getBytes("UTF-8"));
      return toHex(hashByte);      
    } catch (Exception e) {
      return null;
    }
  }

  private static String toHex(byte[] bytes) {
    BigInteger bi = new BigInteger(1, bytes);
    return String.format("%0" + (bytes.length << 1) + "X", bi);
  }
}
