package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    //criou um atributo da interface PersonRepository
    private PersonRepository personRepository;

    //injecao de dependencia
    @Autowired //indica para inspring injetar uma implementacao do tipo repository
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //criar um livro por isso usa post
    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savePerson.getId())
                .build();
    }
}
