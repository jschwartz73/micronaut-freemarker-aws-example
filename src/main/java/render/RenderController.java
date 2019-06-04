package render;


import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.annotation.Controller;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class RenderController implements IOperations {

    private static final Logger log = LoggerFactory.getLogger(RenderController.class);

    @Override
    public ModelAndView mnRenderHomePage() {
        ModelAndView mav = new ModelAndView("pages/home", CollectionUtils.mapOf("loggedIn", true, "username", "schwartech"));
        return mav;
    }

    @Override
    public ModelAndView mnRenderHomePage2() {
        ModelAndView mav = new ModelAndView("pages/home", CollectionUtils.mapOf("loggedIn", true, "username", "jeff"));
        return mav;
    }

    @Override
    public Map<String, Object> customPost() {
        return CollectionUtils.mapOf("loggedIn", true, "username", "sdelamo");
    }
}