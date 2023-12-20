package com.study.jpa.repository;

import com.study.jpa.persistence.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {
    List<Person> findListPersonList(String description);
}
