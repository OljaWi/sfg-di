package guru.spring.framework.di.config;

import guru.spring.framework.di.repositories.EnglishGreetingRepository;
import guru.spring.framework.di.repositories.EnglishGreetingRepositoryImpl;
import guru.spring.framework.di.services.ConstructorGreetingService;
import guru.spring.framework.di.services.I18nEnglishGreetingService;
import guru.spring.framework.di.services.I18nSpanishGreetingService;
import guru.spring.framework.di.services.PrimaryGreetingService;
import guru.spring.framework.di.services.PropertyInjectedGreetingService;
import guru.spring.framework.di.services.SetterInjectedGreetingService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Configuration //This is going to define different Beans
public class GreetingServiceConfig {

  @Bean
  ConstructorGreetingService constructorGreetingService(){
    return new ConstructorGreetingService();

  }

  @Bean //Spring creates this bean and the Beans name will be the name of the method: propertyInjectedGreetingService
  PropertyInjectedGreetingService propertyInjectedGreetingService(){
    return new PropertyInjectedGreetingService();
  }

  @Bean
  SetterInjectedGreetingService setterInjectedGreetingService(){
    return new SetterInjectedGreetingService();
  }

  @Primary
  @Bean
  PrimaryGreetingService primaryGreetingService(){
    return new PrimaryGreetingService();
  }

  @Bean
  EnglishGreetingRepository englishGreetingRepository(){
    return new EnglishGreetingRepositoryImpl();
  }

  @Profile("EN") //Connecting the Service to a profile, profile must be activated in application.properties
  @Bean("i18nService")
  I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
    return new I18nEnglishGreetingService(englishGreetingRepository);
  }

  @Profile({"ES", "default"}) //declaring spanish profile as default profile(if no default profile existing and no profile activated->ERROR)
  @Bean("i18nService")
  I18nSpanishGreetingService i18nSpanishGreetingService(){
    return new I18nSpanishGreetingService();
  }



}
