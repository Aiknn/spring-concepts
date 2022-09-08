package kz.aiknn.springconcepts.controllers;

import kz.aiknn.springconcepts.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
