package webService.Lakkam.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webService.Lakkam.Person.Person;
import webService.Lakkam.Person.PersonService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> userDetails(@PathVariable long id) {
        Person person = personService.getUserDetail(id);
        return person != null ? new ResponseEntity<>(person, HttpStatus.OK)
                              : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody Person person) {
        personService.createUser(person);
        return new ResponseEntity<>("Person is successfully added", HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable long id) {
        boolean flag = personService.deleteJob(id);
        if (flag) {
            return new ResponseEntity<>("Person details successfully deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete person details", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allDetails")
    public ResponseEntity<List<Person>> userAllDetails() {
        return new ResponseEntity<>(personService.getAllDetails(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable long id, @RequestBody Person updatePerson) {
        boolean flag = personService.updatePerson(id, updatePerson);
        if (flag) {
            return new ResponseEntity<>("Person details successfully updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update person details", HttpStatus.NOT_FOUND);
        }
    }
}
