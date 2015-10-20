package org.levelup.lesson8web.services;

import org.levelup.lesson8web.models.web.AnimalDto;
import org.levelup.lesson8web.models.web.ClientResponse;
import java.util.List;

/**
 * Created by proton on 05.07.2015.
 */
public interface AppService {

    List<AnimalDto> getAnimals();


    ClientResponse addAnimal(AnimalDto animal);

    ClientResponse delAnimal(Integer animalId);
}