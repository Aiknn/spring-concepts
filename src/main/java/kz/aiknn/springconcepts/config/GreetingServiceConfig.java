package kz.aiknn.springconcepts.config;

import kz.aiknn.pets.PetService;
import kz.aiknn.pets.PetServiceFactory;
import kz.aiknn.springconcepts.datasource.FakeDataSource;
import kz.aiknn.springconcepts.repositories.EnglishGreetingRepository;
import kz.aiknn.springconcepts.repositories.EnglishGreetingRepositoryImpl;
import kz.aiknn.springconcepts.services.I18nEnglishGreetingService;
import kz.aiknn.springconcepts.services.I18nSpanishGreetingService;
import kz.aiknn.springconcepts.services.PrimaryGreetingService;
import kz.aiknn.springconcepts.services.PropertyGreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

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

    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcurl}") String jdbcUrl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcUrl);
        return fakeDataSource;
    }
}
