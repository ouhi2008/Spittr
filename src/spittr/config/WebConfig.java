package spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter{
//    @Bean
//    public ViewResolver viewResolver() { //配置JSP视图解析器
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
//        //可以在JSP页面中通过${}访问beans
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); //配置静态文件处理
    }
    
    /*
	 * Configure MessageSource to provide internationalized messages
	 * 
	 */
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] {"/WEB-INF/layout/tiles.xml"});
		tiles.setCheckRefresh(true);
		return tiles;
	}
	
	@Bean
	public ViewResolver viewResolver(){
		return new TilesViewResolver();
	}
}