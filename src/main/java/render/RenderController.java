package render;


import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class RenderController {
    private static final Logger log = LoggerFactory.getLogger(RenderController.class);

    @Get("/home")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ModelAndView displayHomePage() {
        ModelAndView mav = new ModelAndView("pages/home", CollectionUtils.mapOf("loggedIn", true, "username", "sdelamo"));
        return mav;
    }

}