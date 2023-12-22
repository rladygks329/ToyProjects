package com.study.jpa.controller;

import com.study.jpa.persistence.Person;
import com.study.jpa.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonService personService;

    @GetMapping
    public String getPerson(Model model){
        logger.info("getPerson() 호출");
        List<Person> list = personService.findAll();
        model.addAttribute("list", list);
        logger.info("size : " +  list.size());
        return "index";
    }

    @PostMapping
    public String postPerson(Person person){
        personService.join(person);
        return "redirect:/index";
    };

    @PutMapping
    public String updatePerson(Person person){
        personService.update(person);
        return "redirect:/index";
    }

    @DeleteMapping String deletePerson(Long personId){
        personService.quit(personId);
        return "redirect:/index";
    }
}
