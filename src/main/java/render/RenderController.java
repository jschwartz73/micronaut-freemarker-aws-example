package render;


import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import render.clients.RenderClient;

import javax.inject.Inject;
import java.util.Map;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class RenderController implements IOperations {

    @Inject
    RenderClient client;

    private static final Logger log = LoggerFactory.getLogger(RenderController.class);

    @Override
    public ModelAndView httpGetHomePage() {
        ModelAndView mav = new ModelAndView("pages/home", jsonGet());
        return mav;
    }

    @Override
    @Post("/json")
    public Map<String, Object> jsonPost() {
        return CollectionUtils.mapOf("loggedIn", true, "username", "jeff");
    }

    @Override
    @Get("/json")
    public Map<String, Object> jsonGet() {
        return CollectionUtils.mapOf("loggedIn", true, "username", "jeff");
    }

    @Get("/consumeGet")
    public Map<String, Object> consumeGet() {
        Map<String, Object> value = client.jsonGet();
        return value;
    }

    @Post("/consumePost")
    public Map<String, Object> consumePost() {
        Map<String, Object> value = client.jsonPost();
        return value;
    }
}