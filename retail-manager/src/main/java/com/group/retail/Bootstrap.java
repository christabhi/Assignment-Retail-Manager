package com.group.retail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Boot main application class. Serves as both the runtime application
 * entry point and the central Java configuration class.
 *
 * @author Abhishek Verma
 */

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableCaching
@ComponentScan("com.group.retail.*")
public class Bootstrap {

	protected static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);
	
	/**
     * Entry point for the application.
     * 
     * @param args Command line arguments.
     * @throws Exception Thrown when an unexpected Exception is thrown from the
     *         application.
     */
	public static void main(String[] args) {
		
		logger.info(String.format("Start the Application Container", "Start"));
		SpringApplication.run(Bootstrap.class, args);
	}
	
	/**
     * Create a CacheManager implementation class to be used by Spring where
     * <code>@Cacheable</code> annotations are applied.
     * 
     * @return A CacheManager instance.
     */
	@Bean
    public CacheManager cacheManager() 
	{
        GuavaCacheManager cacheManager = new GuavaCacheManager("application");
        return cacheManager;
    }
}
