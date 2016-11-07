package com.cybersource.payments;

import com.cybersource.payments.ApiClient;
import com.cybersource.payments.ApiException;
import com.cybersource.payments.Configuration;
import com.cybersource.payments.Pair;
import com.cybersource.payments.TypeRef;
import com.cybersource.payments.Configuration.ConfigurationBuilder;
import com.cybersource.payments.model.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.core.header.InBoundHeaders;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ApiClientTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private static ApiClient client;
    private static WebResource mockResource;
    private static Client mockClient;
    private static Builder mockBuilder;

    @BeforeClass
    public static void setup() {
        Configuration.ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setApiKey("apikey")
               .setSecretKey("secretkey");
        Configuration config = builder.build();
        client = new ApiClient(config);
        client.setBasePath("test");

        mockResource = mock(WebResource.class);
        mockClient = mock(Client.class);
        mockBuilder = mock(Builder.class);
        when(mockBuilder.header(anyString(), anyString())).thenReturn(mockBuilder);
        when(mockResource.getRequestBuilder()).thenReturn(mockBuilder);
        when(mockClient.resource(anyString())).thenReturn(mockResource);  
    }

    @Test
    public void testErrorResponse() throws ApiException, URISyntaxException, IOException {
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("Error.json").toURI());
        String error = new String(Files.readAllBytes(file.toPath())); 

        ClientResponse mockResponse = mock(ClientResponse.class);
        when(mockResponse.getStatusInfo()).thenReturn(ClientResponse.Status.BAD_REQUEST);
        when(mockResponse.hasEntity()).thenReturn(true);
        when(mockResponse.getEntity(String.class)).thenReturn(error);
        when(mockBuilder.get(any(Class.class))).thenReturn(mockResponse);

        client.getHostMap().put("test", mockClient);

        exception.expect(ApiException.class);
        try {
            client.invokeAPI(
                "payments/v1/authorizations",
                "GET", new ArrayList<Pair>(),
                new ArrayList<Pair>(),
                new HashMap<String, String>(),
                new HashMap<String, Object>(),
                null,
                "application/json",
                new TypeRef<AuthorizationCollection>(){});            
        } catch(ApiException e) {
            assertTrue(e.getError() instanceof com.cybersource.payments.model.Error);
            throw e;
        }
    }

    @Test
    public void testNoResponse() throws ApiException {
        ClientResponse mockResponse = mock(ClientResponse.class);
        when(mockResponse.getStatusInfo()).thenReturn(ClientResponse.Status.NO_CONTENT);
        when(mockBuilder.get(any(Class.class))).thenReturn(mockResponse);
        client.getHostMap().put("test", mockClient);
        AuthorizationCollection auths = client.invokeAPI(
                "payments/v1/authorizations",
                "GET", new ArrayList<Pair>(),
                new ArrayList<Pair>(),
                new HashMap<String, String>(),
                new HashMap<String, Object>(),
                null,
                "application/json",
                new TypeRef<AuthorizationCollection>(){});
        assertEquals(auths, null);    
    }

    @Test
    public void testMalformedResponse() throws ApiException {
        String malformedResponse = "{"; 

        ClientResponse mockResponse = mock(ClientResponse.class);
        InBoundHeaders headers = new InBoundHeaders();
        List<String> contentTypes = new ArrayList<String>();
        contentTypes.add("application/json");
        headers.put("Content-Type", contentTypes);

        when(mockResponse.getStatusInfo()).thenReturn(ClientResponse.Status.OK);
        when(mockResponse.hasEntity()).thenReturn(true);
        when(mockResponse.getEntity(String.class)).thenReturn(malformedResponse);
        when(mockResponse.getHeaders()).thenReturn(headers);
        when(mockBuilder.get(any(Class.class))).thenReturn(mockResponse);

        client.getHostMap().put("test", mockClient);

        try {
            client.invokeAPI(
                "payments/v1/authorizations",
                "GET", new ArrayList<Pair>(),
                new ArrayList<Pair>(),
                new HashMap<String, String>(),
                new HashMap<String, Object>(),
                null,
                "application/json",
                new TypeRef<AuthorizationCollection>(){});            
        } catch(ApiException e) {
            assertEquals(e.getCode(), 500);
        }
    }

    @Test
    public void testOkResponse() throws ApiException, URISyntaxException, IOException {
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("Authorization.json").toURI());
        String response = new String(Files.readAllBytes(file.toPath())); 

        ClientResponse mockResponse = mock(ClientResponse.class);
        InBoundHeaders headers = new InBoundHeaders();
        List<String> contentTypes = new ArrayList<String>();
        contentTypes.add("application/json");
        headers.put("Content-Type", contentTypes);

        when(mockResponse.getStatusInfo()).thenReturn(ClientResponse.Status.CREATED);
        when(mockResponse.hasEntity()).thenReturn(true);
        when(mockResponse.getEntity(String.class)).thenReturn(response);
        when(mockResponse.getHeaders()).thenReturn(headers);
        when(mockBuilder.post(any(Class.class), anyString())).thenReturn(mockResponse);

        client.getHostMap().put("test", mockClient);

        Authorization auth = client.invokeAPI(
                "payments/v1/authorizations",
                "POST", new ArrayList<Pair>(),
                new ArrayList<Pair>(),
                new HashMap<String, String>(),
                new HashMap<String, Object>(),
                null,
                "application/json",
                new TypeRef<Authorization>(){});

        assertTrue(auth instanceof Authorization);
    }
}
