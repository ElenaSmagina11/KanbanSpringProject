package com.myproject.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.myproject.dao.AccountDAO;
import com.myproject.dao.DeveloperDAO;
import com.myproject.dao.EmployerDAO;
import com.myproject.dao.KanbanDAO;
import com.myproject.dao.impl.AccountDAOImpl;
import com.myproject.dao.impl.DeveloperDAOImpl;
import com.myproject.dao.impl.EmployerDAOImpl;
import com.myproject.dao.impl.KanbanDAOImpl;

@Configuration
@ComponentScan("com.myproject.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:ds-hibernate-cfg.properties")
public class ApplicationContextConfig {

	// The Environment class serves as the property holder
	// and stores all the properties loaded by the @PropertySource
	@Autowired
	private Environment env;

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasenames(new String[] { "messages/validator" });
		return rb;
	}

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// Config for Upload.
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();

		// Set Max Size...
		// commonsMultipartResolver.setMaxUploadSize(...);

		return commonsMultipartResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: ds-hibernate-cfg.properties
		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));
		System.out.println("## getDataSource: " + dataSource);
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
			throws Exception {
		Properties properties = new Properties();

		// See: ds-hibernate-cfg.properties
		properties.put("hibernate.dialect",
				env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql",
				env.getProperty("hibernate.show_sql"));
		properties.put("current_session_context_class",
				env.getProperty("current_session_context_class"));

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		// Package contain entity classes
		factoryBean.setPackagesToScan(new String[] { "com.myproject.entity" });
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		SessionFactory sf = factoryBean.getObject();
		System.out.println("## getSessionFactory: " + sf);
		return sf;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
		return transactionManager;
	}

	// @Bean(name = "accountDAO")
	public AccountDAO getApplicantDAO() {
		return new AccountDAOImpl();
	}

	@Bean(name = "productDAO")
	public EmployerDAO getProductDAO() {
		return new EmployerDAOImpl();
	}

	@Bean(name = "accountDAO")
	public AccountDAO getAccountDAO() {
		return new AccountDAOImpl();
	}

	@Bean(name = "developerDAO")
	public DeveloperDAO getDeveloperDAO() {
		return new DeveloperDAOImpl();
	}

	@Bean(name = "employerDAO")
	public EmployerDAO getEmployerDAO() {
		return new EmployerDAOImpl();
	}

	@Bean(name = "kanbanDAO")
	public KanbanDAO getKanbanDAO() {
		return new KanbanDAOImpl();
	}

}