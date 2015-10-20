package org.levelup.lesson8web.controllers;

import org.levelup.lesson8web.models.web.AnimalDto;
import org.levelup.lesson8web.models.web.ClientResponse;
import org.levelup.lesson8web.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by proton on 05.07.2015.
 */
@Controller
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/define/animals", method = RequestMethod.GET)
    @ResponseBody
    public List<AnimalDto> defineAnimals() {
        return appService.getAnimals();
    }

    @RequestMapping(value = "/add/animal", method = RequestMethod.POST)
    @ResponseBody
    public ClientResponse addAnimal(@RequestBody AnimalDto animal) {
        return appService.addAnimal(animal);
    }

    @RequestMapping(value = "/del/animal", method = RequestMethod.POST)
    @ResponseBody
    public ClientResponse delAnimal(@RequestBody AnimalDto animal) {
        return appService.delAnimal(animal.getId());
    }
}
