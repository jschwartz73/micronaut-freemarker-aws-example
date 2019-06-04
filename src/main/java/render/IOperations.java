package render;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.views.ModelAndView;

import java.util.Map;

public interface IOperations {
    @Get("/home")
    ModelAndView httpGetHomePage();

    @Post("/json")
    Map<String, Object> jsonPost();

    @Get("/json")
    Map<String, Object> jsonGet();
}
