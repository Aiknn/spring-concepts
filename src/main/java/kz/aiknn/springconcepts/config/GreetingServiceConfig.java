package kz.aiknn.springconcepts.config;

import kz.aiknn.pets.PetService;
import kz.aiknn.pets.PetServiceFactory;
import kz.aiknn.springconcepts.repositories.EnglishGreetingRepository;
import kz.aiknn.springconcepts.repositories.EnglishGreetingRepositoryImpl;
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

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nSpanishGreetingService(englishGreetingRepository);
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }
}
