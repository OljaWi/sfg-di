package guru.spring.framework.di.controllers;

import guru.spring.framework.di.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller //declaring class as Controller
public class I18nController { //I18n = 'Internetionalized'

    private final GreetingService greetingService;

    public I18nController(@Qualifier("i18nService") GreetingService greetingService) { //takes the name of the Service
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
