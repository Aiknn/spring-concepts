package kz.aiknn.springconcepts.services;

import kz.aiknn.springconcepts.repositories.EnglishGreetingRepository;

//@Profile({"ES", "default"})
//@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nSpanishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }


    @Override
    public String sayGreeting() {

        return "Hola Mundo  - ES";
    }
}
