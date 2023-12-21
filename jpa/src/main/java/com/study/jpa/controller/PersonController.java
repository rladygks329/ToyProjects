package com.study.jpa.controller;

import com.study.jpa.persistence.Person;
import com.study.jpa.repository.PersonRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public String getHtml(){
        Optional<Person> person = personRepository.findById(1L);
        person.ifPresent(person1 -> {
            logger.info(person1.toString());
        });
        return "index";
    }
}
