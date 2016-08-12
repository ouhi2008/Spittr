package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(MyConfig.class)
@ImportResource("classpath:beans.xml")
@ComponentScan(basePackages = {"spittr"},
		excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value=EnableWebMvc.class)})

public class RootConfig {

}
