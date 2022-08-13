package guru.spring.framework.di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN") //Connecting the Service to a profile, profile must be activated in application.properties
@Service("i18nService") //class declared as Service with the name i18nService
public class I18nEnglishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello! - EN";
    }
}
