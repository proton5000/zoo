package org.levelup.lesson8web.models.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by proton on 07.07.2015.
 */
@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ClientResponse implements Serializable {

    private ClientResponseStatus status;

    private String message;

    private Integer id;

    public ClientResponseStatus getStatus() {
        return status;
    }

    public ClientResponse setStatus(ClientResponseStatus status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ClientResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public ClientResponse setId(Integer id) {
        this.id = id;
        return this;
    }
}
