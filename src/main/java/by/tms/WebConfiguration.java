package by.tms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Andrei Lisouski (Andrlis)
 */
@Configuration
@ComponentScan(basePackages = "by.tms")
public class WebConfiguration {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver internalResourceViewResolver
        = new InternalResourceViewResolver();
    internalResourceViewResolver.setPrefix("/pages/");
    internalResourceViewResolver.setSuffix(".jsp");
    return internalResourceViewResolver;
  }
}
