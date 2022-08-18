package guru.spring.framework.di;

import guru.spring.framework.di.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//This is no longer needed, because there are no Components to scan, as we configured the spring beans in config class
//@ComponentScan(basePackages={"com.springframework.pets", "guru.spring.framework.di"})
@SpringBootApplication
public class DiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DiApplication.class, args);

		PetController petController=(PetController) ctx.getBean("petController", PetController.class);
		System.out.println("-------The Best Pet is:--------");
		System.out.println(petController.whichIstTheBestPet());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");

		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("----------Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("----------Property");

		PropertyInjectedController propertyInjectedController=(PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----------Setter");
		SetterInjectedController setterInjectedController =(SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----------Constructor");
		ConstructorInjectedController constructorInjectedController=(ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
