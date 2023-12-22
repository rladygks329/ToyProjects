package com.study.jpa.service;

import com.study.jpa.persistence.Person;
import com.study.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImple implements PersonService{
    @Autowired
    PersonRepository personRepository;

    @Override
    public int join(Person person) {
        personRepository.save(person);
        return 1;
    }

    @Override
    public int update(Person newPerson) {
        Person oldPerson = personRepository.findById(newPerson.getId()).
                orElseThrow(() -> {throw new IllegalStateException("해당하는 회원이없습니다.");});
        oldPerson.setAge(newPerson.getAge());
        oldPerson.setName(newPerson.getName());
        oldPerson.setIsMale(newPerson.getIsMale());
        return 1;
    }

    @Override
    public int quit(long personId) {
        personRepository.deleteById(personId);
        return 0;
    }

    @Override
    public Person find(long id) {
        Person person = personRepository.findById(id).orElseThrow(()->{
            throw new IllegalArgumentException("해당 아이디를 가진 사람을 조회할 수 없습니다.");
        });
        return person;
    }

    @Override
    public List<Person> findAll() {
        List<Person> list = personRepository.findAll();
        return list;
    }
    @Override
    public List<Person> find(String name) {
        List<Person> list = personRepository.findByNameLike(name);
        return list;
    }
}
