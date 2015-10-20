package org.levelup.lesson8web.models.web;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.levelup.lesson8web.models.entities.Gender;
import org.levelup.lesson8web.models.entities.Type;

import java.io.Serializable;

/**
 * Created by proton on 05.07.2015.
 */
@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AnimalDto implements Serializable {

    @JsonProperty
    private Integer id;

    private Gender gender;

    private Type type;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public AnimalDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public AnimalDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Type getType() {
        return type;
    }

    public AnimalDto setType(Type type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public AnimalDto setAge(Integer age) {
        this.age = age;
        return this;
    }
}
