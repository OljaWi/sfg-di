package guru.spring.framework.di.controllers;

import com.springframework.pets.PetService;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {

  private final PetService petService;

  public PetController(PetService petService) {
    this.petService = petService;
  }

  public String whichIstTheBestPet(){

    return petService.getPetType();
  }
}
