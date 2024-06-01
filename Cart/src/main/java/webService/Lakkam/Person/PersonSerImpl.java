package webService.Lakkam.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonSerImpl implements PersonService {

    private final PersonRepository personRepository;
    private long nextId = 1L;

    @Autowired
    public PersonSerImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getUserDetail(long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllDetails() {
        return personRepository.findAll();
    }

    @Override
    public void createUser(Person person) {
        person.setId(nextId++);
        personRepository.save(person);
    }

    @Override
    public boolean deleteJob(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePerson(long id, Person updatePerson) {
        return personRepository.findById(id).map(person -> {
            person.setEmail(updatePerson.getEmail());
            person.setPassword(updatePerson.getPassword());
            person.setUsername(updatePerson.getUsername());
            personRepository.save(person);
            return true;
        }).orElse(false);
    }
}
