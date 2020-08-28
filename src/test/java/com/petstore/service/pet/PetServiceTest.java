package com.petstore.service.pet;

import com.petstore.models.Pet;
import com.petstore.repository.PetRepository;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class PetServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetService petService;

    Pet testPet;

    @BeforeEach
    void setUp() {
        petService = new PetServiceImpl();

        testPet = new Pet();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        when(petService.save(testPet)).thenReturn(testPet);
        petService.save(testPet);

        verify(petRepository,times(1)).save(testPet);

    }

    @Test
    void findById() {
        when(petService.findById(200)).thenReturn(Optional.of(testPet));
        petService.findById(200);

        verify(petRepository,times(1)).findById(200);


    }

    @Test
    void update() {

        when (petService.update(testPet)).thenReturn(testPet);
        petService.update(testPet);

        verify(petRepository,times(1)).save(testPet);

    }

    @Test
    void delete() {
        doNothing().when(petRepository).delete(testPet);
        petService.delete(200);

        verify(petRepository,times(1)).deleteById(200);
    }

    @Test
    void findAll() {
        List<Pet>petList = new ArrayList<>();
        when(petService.findAll()).thenReturn(petList);
        petService.findAll();

        verify(petRepository,times(1)).findAll();

    }
}