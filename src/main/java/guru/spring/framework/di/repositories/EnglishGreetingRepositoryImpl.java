package guru.spring.framework.di.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

  @Override
  public String getGreeting() {
    return "Hello! - EN";
  }
}
