package by.tms.calc;

import by.tms.calc.storage.OperationStorage;
import by.tms.calc.storage.UserStorage;
import by.tms.calc.storage.dao.OperationTemplateJDBC;
import by.tms.calc.storage.dao.UserTemplateJDBC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * @author Andrei Lisouski (Andrlis)
 */
@Configuration
@ComponentScan(basePackages = "by.tms")
@EnableWebMvc
public class WebConfiguration {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver internalResourceViewResolver
        = new InternalResourceViewResolver();
    internalResourceViewResolver.setPrefix("/pages/");
    internalResourceViewResolver.setSuffix(".jsp");
    return internalResourceViewResolver;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/spring_calc");
    dataSource.setUsername("postgres");
    dataSource.setPassword("root");

    return dataSource;
  }

  @Bean
  public UserStorage userStorage(DataSource dataSource){
    return new UserTemplateJDBC(dataSource);
  }

  @Bean
  public OperationStorage operationStorage(DataSource dataSource){
    return new OperationTemplateJDBC(dataSource);
  }
}
