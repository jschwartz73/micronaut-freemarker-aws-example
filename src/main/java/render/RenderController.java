package render;


import freemarker.template.Configuration;
import io.micronaut.context.env.Environment;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.ViewsConfiguration;
import io.micronaut.views.freemarker.FreemarkerFactory;
import io.micronaut.views.freemarker.FreemarkerViewsRendererConfiguration;
import io.micronaut.views.freemarker.MyFreemarkerFactoryHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class RenderController {
    @Inject
    private Environment environment;

    public RenderController(Environment environment) {
        this.environment = environment;
        log.info("GOT AN ENVIRONMENT");
    }

    private static final Logger log = LoggerFactory.getLogger(RenderController.class);

    @Get("/home")
    @Produces(value=MediaType.TEXT_HTML)
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ModelAndView displayHomePage() {
        MyFreemarkerFactoryHelper myFreemarkerFactoryHelper = new MyFreemarkerFactoryHelper();

        Configuration config = myFreemarkerFactoryHelper.getConfiguration(environment);
        log.info("CONFIG: {}", config);

        ModelAndView mav = new ModelAndView("pages/home", CollectionUtils.mapOf("loggedIn", true, "username", "sdelamo"));
        return mav;
    }

}