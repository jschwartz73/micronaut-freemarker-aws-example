package render;

/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;
import io.micronaut.context.ApplicationContext;
import io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for the AWS_PROXY default implementation
 */

public class MicronautAwsProxyTest {

    private static MicronautLambdaContainerHandler handler;

    static {
        try {
            handler = MicronautLambdaContainerHandler.getAwsProxyHandler(
                ApplicationContext.build()
                    .properties(Collections.singletonMap(
                        "micronaut.security.enabled", true
                    ))
            );
        } catch (ContainerInitializationException e) {
            throw new RuntimeException("Test failed to start: " + e.getMessage(), e);
        }
    }

    private static Context lambdaContext = new MockLambdaContext();

    private boolean isAlb;

    public MicronautAwsProxyTest() {
        isAlb = false;
    }

    public static Collection<Object> data() {
        return Arrays.asList(new Object[] { false, true });
    }

    private AwsProxyRequestBuilder getRequestBuilder(String path, String method) {
        AwsProxyRequestBuilder builder = new AwsProxyRequestBuilder(path, method);
        if (isAlb) builder.alb();

        return builder;
    }

    @Test
    public void textHtmlResponse() {
        AwsProxyRequest request = getRequestBuilder("/home", "GET")
            .header("Content-Type", "text/html")
            .build();

        AwsProxyResponse output = handler.proxy(request, lambdaContext);

        assertEquals(200, output.getStatusCode());

        System.out.println(output.getBody());
        assertTrue(output.getBody().contains("sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="));

    }

}