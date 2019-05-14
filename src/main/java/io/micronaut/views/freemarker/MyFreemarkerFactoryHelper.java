package io.micronaut.views.freemarker;

import freemarker.template.Configuration;
import io.micronaut.context.env.Environment;
import io.micronaut.views.ViewsConfiguration;

public class MyFreemarkerFactoryHelper {

    public MyFreemarkerFactoryHelper() { }

    public Configuration getConfiguration(Environment environment) {
        //        io.micronaut.views.freemarker.VersionTypeConverter

        FreemarkerViewsRendererConfiguration fmVRC = new FreemarkerViewsRendererConfiguration() {
            @Override
            public String getDefaultExtension() {
                return "ftl";
            }

            @Override
            public freemarker.template.Version getIncompatibleImprovements() {
                return new freemarker.template.Version(2, 3, 0);
            }
        };

        ViewsConfiguration vc = new ViewsConfiguration() {
            @Override
            public String getFolder() {
                return "views";
            }
        };

        FreemarkerFactory ff = new FreemarkerFactory();
        Configuration config = ff.getConfiguration(fmVRC, vc, environment);

        System.out.println("GOT CONFIG");
        return config;
    }
}
