package kz.aiknn.springconcepts;

import kz.aiknn.springconcepts.controllers.ConstructorInjectedController;
import kz.aiknn.springconcepts.controllers.PropertyInjectedController;
import kz.aiknn.springconcepts.controllers.SetterInjectedController;
import kz.aiknn.springconcepts.services.GreetingServiceKazakh;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringConceptsApplication {

	public static void main(String[] args) {
		/*
		System.out.println("Without Spring - to activate you need uncomment and delete spring code below the code");

		SpringApplication.run(SpringConceptsApplication.class, args);

		PropertyInjectedController controller = new PropertyInjectedController();
		controller.greetingService = new GreetingServiceKazakh();
		System.out.println(controller.getGreeting());

		SetterInjectedController controller1 = new SetterInjectedController();
		controller1.setGreetingService(new GreetingServiceKazakh());
		System.out.println(controller1.getGreeting());

		ConstructorInjectedController controller2 =
				new ConstructorInjectedController(new GreetingServiceKazakh());
		System.out.println(controller2.getGreeting());
		*/

		ApplicationContext ctx = SpringApplication.run(SpringConceptsApplication.class, args);

		System.out.println("Property injected controller");
		PropertyInjectedController controller = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(controller.getGreeting());
		System.out.println("---------------------------");

		System.out.println("Setter injected controller");
		SetterInjectedController controller1 = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(controller1.getGreeting());
		System.out.println("---------------------------");

		System.out.println("Constructor injected controller");
		ConstructorInjectedController controller2 = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(controller2.getGreeting());
		System.out.println("---------------------------");

	}

}
