package kz.aiknn.springconcepts.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceKazakh implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Salem";
    }
}
