package org.levelup.lesson8web.repositories;

import org.levelup.lesson8web.models.entities.Animal;

import java.util.List;

/**
 * Created by proton on 05.07.2015.
 */
public interface AnimalRepository {
    Animal get(Integer id);

    List<Animal> get();

    void save(Animal product);

    void edit(Animal product);

    void del(Animal product);
}
