package com.cybersource.payments;

public class Configuration {
  private String apiKey;
  private String secretKey;
  private int timeoutMilliseconds;

  private Configuration(String apiKey, String secretKey, int timeoutMilliseconds) {
    this.apiKey = apiKey;
    this.secretKey = secretKey;
    this.timeoutMilliseconds = timeoutMilliseconds;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getSecretKey() {
    return secretKey;
  }

  public int getTimeoutMilliseconds() {
    return timeoutMilliseconds;
  }

  public static final class ConfigurationBuilder {
    private String apiKey;
    private String secretKey;
    private int timeoutMilliseconds;

    public ConfigurationBuilder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public ConfigurationBuilder setSecretKey(String secretKey) {
      this.secretKey = secretKey;
      return this;
    }

    public ConfigurationBuilder setTimeoutMilliseconds(int timeoutMilliseconds) {
      this.timeoutMilliseconds = timeoutMilliseconds;
      return this;
    }

    public Configuration build() {
      return new Configuration(apiKey, secretKey, timeoutMilliseconds);
    }
  }
}
