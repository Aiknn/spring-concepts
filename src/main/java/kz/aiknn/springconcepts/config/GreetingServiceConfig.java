package kz.aiknn.springconcepts.config;

import kz.aiknn.springconcepts.services.PropertyGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    PropertyGreetingService propertyGreetingService(){
        return new PropertyGreetingService();
    }
}
