package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { //根容器
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { //Spring mvc容器
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() { //DispatcherServlet映射,从"/"开始
        return new String[] { "/" };
    }
}