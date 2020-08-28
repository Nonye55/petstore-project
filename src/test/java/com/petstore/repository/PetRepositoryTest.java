package com.petstore.repository;

import com.petstore.models.Pet;
import com.petstore.models.PetSex;
import com.petstore.models.PetTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts ={ "classpath:db\\insert-pet.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class PetRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

 @Autowired
    PetRepository petRepository;

    Pet  testPetData;

    @BeforeEach
    void setUp() {

        testPetData = petRepository.findById(200).orElse(null);
        assertThat(testPetData).isNotNull();

        log.info("Test pet data retrieved from database");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPetObject_thenSaveTODatabaseTest() {
        Pet pet = new Pet();
        pet.setAge(5);
        pet.setName("Lucky");
        pet.setSex(PetSex.FEMALE);
        pet.setTypes(PetTypes.DOG);
        pet.setBreed("bull dog");
        pet.setBirthDate(new Date());

        log.info("Created pet object --> " + pet);
        assertThat(pet.getId()).isNull();

        //save pet object to the database

        pet = petRepository.save(pet);
        log.info("After saving pet object -->" + pet);
        assertThat(pet.getId()).isNotNull();
    }
     @Test
        void whenFindAllIsCalled_thenRetrievePetsListTest(){
         List<Pet> allPets = petRepository.findAll();
         assertThat(allPets.size()).isEqualTo(5);
         log.info(" All pets After saving pet object -->" + allPets);
//         assertThat(allPets).contains(testPetData);



     }

     @Test
        void whenPetDetailsIsUpdated_theUpdateDatabaseDetails(){
        assertThat(testPetData .getName()).isEqualTo("body");
        testPetData.setName("omagag");

        testPetData = petRepository.save(testPetData);
        assertThat(testPetData.getName()).isEqualTo("omagag");

     }
    @Test
    void whenDeleteisCalled_thenDeletePetdataTest(){
        List<Pet> allPets = petRepository.findAll();
        assertThat(allPets).isNotNull();
        assertThat(allPets.size()).isEqualTo(5);

         Pet savedPet = petRepository.findById(202).orElse(null);
         assertThat(savedPet).isNotNull();
         petRepository.deleteById(202);

         Pet deletedPet = petRepository.findById(202).orElse(null);
         assertThat(deletedPet).isNull();

         allPets=petRepository.findAll();
         assertThat(allPets).isNotNull();
         assertThat(allPets.size()).isEqualTo(4);
;
    }




    }

