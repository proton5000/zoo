package org.levelup.lesson8web.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by proton on 01.07.2015.
 */
@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TestRequest implements Serializable {

    private String test;

    public String getTest() {
        return test;
    }

    public TestRequest setTest(String test) {
        this.test = test;
        return this;
    }
}
