package com.study.jpa.service;

import com.study.jpa.persistence.Person;

import java.util.List;

public interface PersonService {
    public int join(Person person);

    public int update(Person person);

    public int quit(long personId);

    public Person find(long id);

    public List<Person> findAll();

    public List<Person> find(String name);
}
