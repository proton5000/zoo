package org.levelup.lesson8web.services;

import org.levelup.lesson8web.models.entities.Animal;
import org.levelup.lesson8web.models.web.AnimalDto;
import org.levelup.lesson8web.models.web.ClientResponse;
import org.levelup.lesson8web.models.web.ClientResponseStatus;
import org.levelup.lesson8web.repositories.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proton on 05.07.2015.
 */
@Service
public class AppServiceImpl implements AppService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppServiceImpl.class);

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<AnimalDto> getAnimals() {
        List<AnimalDto> animalDtoList = new ArrayList<AnimalDto>();
        try {
            List<Animal> animals = animalRepository.get();
            for (Animal animal : animals) {
                animalDtoList.add(new AnimalDto()
                        .setId(animal.getId())
                        .setAge(animal.getAge())
                        .setGender(animal.getGender())
                        .setType(animal.getType())
                        .setName(animal.getName()));
            }
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
        }
        return animalDtoList;
    }

    @Override
    public ClientResponse addAnimal(AnimalDto animalDto) {
        ClientResponse response = new ClientResponse();
        try {
            Animal animal = new Animal()
                    .setAge(animalDto.getAge())
                    .setGender(animalDto.getGender())
                    .setName(animalDto.getName())
                    .setType(animalDto.getType());
            animalRepository.save(animal);
            response.setStatus(ClientResponseStatus.SUCCESS);
            response.setId(animal.getId());
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            response.setStatus(ClientResponseStatus.FAIL).setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public ClientResponse delAnimal(Integer animalId) {
        ClientResponse response = new ClientResponse();

        try {
            Animal animal = new Animal().setId(animalId);
            animalRepository.del(animal);
            response.setStatus(ClientResponseStatus.SUCCESS);
        } catch (Exception e) {
            LOGGER.error("{}", e.toString(), e);
            response.setStatus(ClientResponseStatus.FAIL).setMessage(e.getMessage());
        }
        return response;
    }

}
