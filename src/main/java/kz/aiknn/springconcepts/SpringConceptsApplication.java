package kz.aiknn.springconcepts;

import kz.aiknn.springconcepts.controllers.ConstructorInjectedController;
import kz.aiknn.springconcepts.controllers.PropertyInjectedController;
import kz.aiknn.springconcepts.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringConceptsApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringConceptsApplication.class, args);

        PropertyInjectedController controller = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(controller.getGreeting());

        SetterInjectedController controller1 = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(controller1.getGreeting());

        ConstructorInjectedController controller2 = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(controller2.getGreeting());
    }
}
