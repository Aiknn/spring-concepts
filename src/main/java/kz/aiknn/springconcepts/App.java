package kz.aiknn.springconcepts;

import kz.aiknn.springconcepts.controllers.ConstructorInjectedController;
import kz.aiknn.springconcepts.controllers.PropertyInjectedController;
import kz.aiknn.springconcepts.controllers.SetterInjectedController;
import kz.aiknn.springconcepts.services.GreetingServiceKazakh;

public class App {
    public static void main(String[] args) {
        PropertyInjectedController controller = new PropertyInjectedController();
        controller.greetingService = new GreetingServiceKazakh();
        System.out.println(controller.getGreeting());
        System.out.println("-------");

        SetterInjectedController controller1 = new SetterInjectedController();
        controller1.setGreetingService(new GreetingServiceKazakh());
        System.out.println(controller1.getGreeting());
        System.out.println("-------");

        ConstructorInjectedController controller2 =
                new ConstructorInjectedController(new GreetingServiceKazakh());
        System.out.println(controller2.getGreeting());
    }
}
