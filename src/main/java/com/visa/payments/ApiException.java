package com.visa.payments;

import com.visa.payments.model.Error;
import java.util.Map;
import java.util.List;

public class ApiException extends Exception {
  private int code = 0;
  private String message = null;
  private Map<String, List<String>> responseHeaders = null;
  private String responseBody = null;
  private Error error;

  public ApiException() {}

  public ApiException(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public ApiException(int code, String message, Error error) {
    this(code, message);
    this.error = error;
  }

  public ApiException(int code, String message, Map<String, List<String>> responseHeaders, String responseBody) {
    this.code = code;
    this.message = message;
    this.responseHeaders = responseHeaders;
    this.responseBody = responseBody;
  }

  public ApiException(int code, String message, Error error, Map<String, List<String>> responseHeaders, String responseBody) {
    this(code, message, error);
    this.responseHeaders = responseHeaders;
    this.responseBody = responseBody;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  /**
   * Get the response deserialized as an Error object.
   */ 
  public Error getError() {
    return error;
  }

  /**
   * Get the HTTP response headers.
   */
  public Map<String, List<String>> getResponseHeaders() {
    return responseHeaders;
  }

  /**
   * Get the HTTP response body.
   */
  public String getResponseBody() {
    return responseBody;
  }
}
