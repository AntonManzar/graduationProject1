package graduationProject.services;

import graduationProject.models.Person;
import graduationProject.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Person> showListPerson() {
        return personRepository.findAll();
    }

    public Person showPersonById(int personId) {
        Optional<Person> person = personRepository.findById(personId);
        return person.orElse(null);
    }

    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setPersonRole("ROLE_USER");
        personRepository.save(person);
    }

    @Transactional
    public void editPerson(int personId, Person person) {
        person.setPersonId(personId);
        personRepository.save(person);
    }

    @Transactional
    public void deletePerson(int personId) {
        personRepository.deleteById(personId);
    }

    @Transactional
    public void createNewPerson(Person person) {
        personRepository.save(person);
    }
}
