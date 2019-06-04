package render.clients;

import io.micronaut.http.client.annotation.Client;
import render.IOperations;

@Client(id="my-client")
public interface RenderClient extends IOperations {
}