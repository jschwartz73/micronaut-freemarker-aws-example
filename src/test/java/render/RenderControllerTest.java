package render;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;


@MicronautTest
public class RenderControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testDisplayPage() throws Exception {
        HttpRequest request = HttpRequest.GET("/home");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertTrue(body.contains("Picture"));
    }

}
