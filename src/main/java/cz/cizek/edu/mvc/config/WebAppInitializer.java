package cz.cizek.edu.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author jiricizek <jiri.cizek@cleverlance.com>
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        servletContext.addListener(new ContextLoaderListener(getRootContext()));

        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet",
                new DispatcherServlet(getDispatcherContext()));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/Users/jiricizek/Desktop");

        dispatcherServlet.setMultipartConfig(multipartConfigElement);
    }

    private AnnotationConfigWebApplicationContext getRootContext() {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setConfigLocations("cz.cizek.edu.mvc.config.root");

        return ctx;
    }

    private AnnotationConfigWebApplicationContext getDispatcherContext() {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setConfigLocations("cz.cizek.edu.mvc.config.web");

        return ctx;
    }

}
