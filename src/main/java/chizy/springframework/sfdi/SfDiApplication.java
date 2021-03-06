package chizy.springframework.sfdi;

import chizy.springframework.sfdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(SfDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("------------> PRIMARY");
		System.out.println(myController.sayHello());

		System.out.println("------------> Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController)
				ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------------> Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController)
				ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------------> Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)
				ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("------------> From Active Profile");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("------------> From Active Profile for PETS");
		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.whichPetIsTheBest());
	}

}
