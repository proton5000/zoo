package org.levelup.lesson8web.repositories;

import org.levelup.lesson8web.models.entities.Animal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by proton on 05.07.2015.
 */
@Repository
@Transactional
public class AnimalRepositoryImpl implements AnimalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Animal get(Integer id) {
        return (Animal) entityManager.
                createNamedQuery("getById").
                setParameter("id", id).
                getSingleResult();
    }

    @Override
    public List<Animal> get() {
        return entityManager.createNamedQuery("getAll").getResultList();
    }

    @Override
    public void save(Animal animal) {
        entityManager.persist(animal);
    }

    @Override
    public void edit(Animal animal) {
        entityManager.merge(animal);
    }

    @Override
    public void del(Animal animal) {
        entityManager.remove(get(animal.getId()));
    }
}

