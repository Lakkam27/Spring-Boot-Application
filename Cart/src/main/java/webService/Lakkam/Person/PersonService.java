package webService.Lakkam.Person;

import java.util.List;

public interface PersonService {
    Person getUserDetail(long id );
    List<Person> getAllDetails();
    void  createUser(Person person);
    boolean deleteJob(Long id);
    boolean updatePerson(long id, Person updatePerson);

}

