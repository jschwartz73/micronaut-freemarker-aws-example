package render;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.views.ModelAndView;

import java.util.Map;

public interface IOperations {
    @Get("/home")
    ModelAndView mnRenderHomePage();

    @Post("/home")
    ModelAndView mnRenderHomePage2();

    @Post("/post")
    Map<String, Object> customPost();
}
