package kz.aiknn.springconcepts.config;

import kz.aiknn.springconcepts.services.I18nEnglishGreetingService;
import kz.aiknn.springconcepts.services.I18nSpanishGreetingService;
import kz.aiknn.springconcepts.services.PrimaryGreetingService;
import kz.aiknn.springconcepts.services.PropertyGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    PropertyGreetingService propertyGreetingService(){

        return new PropertyGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(){
        return new I18nEnglishGreetingService();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }
}
