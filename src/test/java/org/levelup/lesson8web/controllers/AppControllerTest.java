package org.levelup.lesson8web.controllers;

import org.levelup.lesson8web.models.entities.Animal;
import org.levelup.lesson8web.models.web.AnimalDto;
import org.levelup.lesson8web.models.web.ClientResponse;
import org.levelup.lesson8web.services.AppService;
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

/**
 * Created by proton on 28.07.2015.
 */
public class AppControllerTest {
    private Assertion assertion = new Assertion();

    @Mock
    private AppService appService;

    @InjectMocks
    public AppController appController;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @DataProvider
    public Object[][] testAnimals() {
        List<AnimalDto> response = appController.defineAnimals();

        return new Object[][]{
                {response, response.size()}
        };
    }

    @Test(dataProvider = "testAnimals")
    public void testAnimalsDataProvider(List<Animal> request, int expectedSize) {
        assertion.assertNotNull(request);
        assertion.assertEquals(request.size(), new ArrayList<AnimalDto>().size());
    }

    @Test
    public void defineAnimals() {
        Mockito.when(appService.getAnimals()).thenReturn(new ArrayList<AnimalDto>());
        List<AnimalDto> response = appController.defineAnimals();
        assertion.assertNotNull(response);
        assertion.assertEquals(response.size(), new ArrayList<AnimalDto>().size());
    }

    @Test
    public void addAnimal() {
        Mockito.when(appService.addAnimal(new AnimalDto())).thenReturn(new ClientResponse());
        appController.addAnimal(new AnimalDto());
    }

    @Test
    public void delAnimal() {
        Mockito.when(appService.delAnimal(new AnimalDto().getId())).thenReturn(new ClientResponse());
        ClientResponse response = appController.delAnimal(new AnimalDto());
        assertion.assertNotNull(response);
    }
}