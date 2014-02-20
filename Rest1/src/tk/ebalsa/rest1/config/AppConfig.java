package tk.ebalsa.rest1.config;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.ebalsa.rest1.persistence.UserRepository;

import com.jolbox.bonecp.BoneCPDataSource;



@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "tk.ebalsa.rest1.persistence")
@EnableTransactionManagement
@ComponentScan("tk.ebalsa.rest1")
@PropertySource("classpath:/tk/ebalsa/rest1/config/app.properties")
public class AppConfig {
	
	  @Resource
	  private Environment environment;
	
	 @Bean
	  public DataSource dataSource()  {

		 BoneCPDataSource dataSource = new BoneCPDataSource();

	        dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

	        return dataSource;
	  }

	  @Bean
	  public EntityManagerFactory entityManagerFactory() throws SQLException {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("tk.ebalsa.rest1.model");
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }

	  @Bean
	  public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
	    return entityManagerFactory.createEntityManager();
	  }

	  @Bean
	  public PlatformTransactionManager transactionManager() throws SQLException {

	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	  }

	  @Bean
	  public HibernateExceptionTranslator hibernateExceptionTranslator() {
	    return new HibernateExceptionTranslator();
	  }
}

