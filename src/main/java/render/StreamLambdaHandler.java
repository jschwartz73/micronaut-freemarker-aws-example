package render;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.*;
import com.amazonaws.services.lambda.runtime.*;
import io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class StreamLambdaHandler implements RequestStreamHandler {
    private static MicronautLambdaContainerHandler handler; // <1>
    static {
        try {
//            System.setProperty("micronaut.environments", "function");
            handler = MicronautLambdaContainerHandler.getAwsProxyHandler();
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Micronaut", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {

        String in = IOUtils.toString(inputStream);

        System.out.println("RAW.IN: " + in);

        InputStream is2 = IOUtils.toInputStream(in);

        handler.proxyStream(is2, outputStream, context); // <2>
    }
}