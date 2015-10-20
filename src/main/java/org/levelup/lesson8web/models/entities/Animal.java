package org.levelup.lesson8web.models.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by proton on 05.07.2015.
 */
@Entity
@Table(name = "animals")
@NamedQueries({
        @NamedQuery(name = "getAll", query = "SELECT a FROM Animal a"),
        @NamedQuery(name = "getById", query = "SELECT a FROM Animal a WHERE a.id = :id")
})
public class Animal implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    private Gender gender;

    private Type type;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Animal setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Animal setType(Type type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Animal setAge(Integer age) {
        this.age = age;
        return this;
    }
}