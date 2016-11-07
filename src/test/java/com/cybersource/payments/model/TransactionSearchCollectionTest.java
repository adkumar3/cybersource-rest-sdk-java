package com.cybersource.payments.model;

import com.cybersource.payments.ApiException;
import com.cybersource.payments.JSON;
import com.cybersource.payments.TypeRef;
import com.cybersource.payments.model.TransactionSearchCollection;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.Thread;
import java.net.URISyntaxException;
import java.nio.file.Files;


public class TransactionSearchCollectionTest {

    String serialized;

    @Before
    public void setup() throws URISyntaxException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("TransactionSearchCollection.json").toURI());
        serialized = new String(Files.readAllBytes(file.toPath())); 
    }

    @Test
    public void testDeserialize() throws ApiException, IllegalAccessException, InvocationTargetException {
        TypeRef typeRef = new TypeRef<com.cybersource.payments.model.TransactionSearchCollection>() {};
        JSON json = new JSON();
        TransactionSearchCollection instanceOfTransactionSearchCollection = json.deserialize(serialized, typeRef);
        Method[] methods = TransactionSearchCollection.class.getMethods();

        for(Method method : methods){
            if (!Modifier.isPublic(method.getModifiers())) {
                continue;
            }
            if (method.getDeclaringClass() == TransactionSearchCollection.class && method.getName().startsWith("get")) {
                assertTrue(method.invoke(instanceOfTransactionSearchCollection) != null);
            }
        }
	}
}
