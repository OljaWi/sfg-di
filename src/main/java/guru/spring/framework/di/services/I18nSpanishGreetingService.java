package guru.spring.framework.di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES", "default"}) //declaring spanish profile as default profile(if no default profile existing and no profile activated->ERROR)
@Service("i18nService") //is going to be the name of the Service
public class I18nSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Holá! - ES";
    }
}
