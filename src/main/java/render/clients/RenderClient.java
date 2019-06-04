package render.clients;

import io.micronaut.http.client.annotation.Client;
import render.IOperations;

@Client(id="my-client", path = "/Prod/jeff")
public interface RenderClient extends IOperations {
}