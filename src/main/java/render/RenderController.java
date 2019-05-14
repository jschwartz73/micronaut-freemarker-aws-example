package render;


import io.micronaut.core.io.Writable;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.freemarker.FreemarkerViewsRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.io.StringWriter;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class RenderController {

    @Inject
    private FreemarkerViewsRenderer freemarkerViewsRenderer;

    public RenderController(FreemarkerViewsRenderer freemarkerViewsRenderer) {
        this.freemarkerViewsRenderer = freemarkerViewsRenderer;
        log.info("GOT AN FVR: {}", freemarkerViewsRenderer);
    }

    private static final Logger log = LoggerFactory.getLogger(RenderController.class);

    @Get("/homeManualRender")
    @Produces(value=MediaType.TEXT_HTML)
    @Secured(SecurityRule.IS_ANONYMOUS)
    public String manualRenderHomePage() {
        ModelAndView mav = new ModelAndView("pages/home", CollectionUtils.mapOf("loggedIn", true, "username", "sdelamo"));

        Writable w = freemarkerViewsRenderer.render("pages/home", mav.getModel());

        StringWriter sw = new StringWriter();
        try {
            w.writeTo(sw);
        } catch (IOException e) {
            log.error("Error writing template", e);
        }

        return sw.toString();
    }

    @Get("/home")
    @Produces(value=MediaType.TEXT_HTML)
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ModelAndView mnRenderHomePage() {
        ModelAndView mav = new ModelAndView("pages/home", CollectionUtils.mapOf("loggedIn", true, "username", "sdelamo"));
        return mav;
    }
}