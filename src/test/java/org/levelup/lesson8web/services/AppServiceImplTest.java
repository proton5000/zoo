package org.levelup.lesson8web.services;

import org.levelup.lesson8web.models.entities.Animal;
import org.levelup.lesson8web.models.web.AnimalDto;
import org.levelup.lesson8web.repositories.AnimalRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by proton on 26.07.2015.
 */
public class AppServiceImplTest {

    private Assertion assertion = new Assertion();

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AppServiceImpl appService;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @DataProvider
    public Object[][] testAnimals() {
        List<AnimalDto> response1 = appService.getAnimals();
        List<Animal> response2 = createEmptyRequest();
        return new Object[][]{
                {response1, response1.size()},
                {response2, 0}
        };
    }

    @Test(dataProvider = "testAnimals")
    public void testAnimalsDataProvider(List<AnimalDto> request, int expectedSize) {
        assertion.assertNotNull(request);
        assertion.assertEquals(request.size(), expectedSize);
    }

    @Test
    public void getAnimalTest() {
        Mockito.when(animalRepository.get(1)).thenReturn(new Animal());
        appService.getAnimals();
    }

    @Test
    public void getAnimalsTest1() {
        Mockito.when(animalRepository.get()).thenReturn(createRequest());
        List<AnimalDto> response = appService.getAnimals();
        assertion.assertNotNull(response);
        assertion.assertEquals(response.size(), 1);
    }

    @Test
    public void getAnimalsTest2() {
        when(animalRepository.get()).thenReturn(createEmptyRequest());
        List<AnimalDto> response = appService.getAnimals();
        assertion.assertNotNull(response);
        assertion.assertEquals(response.size(), 0);
    }

    @Test
    public void getAnimalsTest3() {
        when(animalRepository.get()).thenThrow(Exception.class);
        List<AnimalDto> response = appService.getAnimals();
        assertion.assertNotNull(response);
        assertion.assertEquals(response.size(), 0);
    }

    private List<Animal> createEmptyRequest() {
        return new ArrayList<>();
    }

    private List<Animal> createRequest() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal().setName("vasya").setAge(1));
        return animals;
    }
}