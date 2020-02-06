package org.bookshare.api.controllers;

import org.bookshare.api.model.Person;
import org.bookshare.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        personService.registerPerson(person);
    }
}
