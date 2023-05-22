package by.tms;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Andrei Lisouski (Andrlis)
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[0];
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebConfiguration.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
