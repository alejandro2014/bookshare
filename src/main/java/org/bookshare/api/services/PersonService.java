package org.bookshare.api.services;

import org.bookshare.api.model.Person;
import org.bookshare.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void registerPerson(Person person) {
        personRepository.save(person);
    }
}
