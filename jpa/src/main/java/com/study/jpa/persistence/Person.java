package com.study.jpa.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter // Getter, Setter은 Lombok 라이브러리이다. 각 변수의 Getter, Setter Method를 만들어준다.
@Setter
@ToString
public class Person{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String isMale;
}