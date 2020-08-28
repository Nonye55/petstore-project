package com.petstore.repository;

import com.petstore.models.Pet;
import com.petstore.models.PetSex;
import com.petstore.models.PetTypes;
import com.petstore.models.Store;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts="classpath:db\\insert-store.sql")
class StoreRepositoryTest {
    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    StoreRepository storeRepository;

    Store  testStore;

    @BeforeEach
    void setUp() {
        testStore = storeRepository.findById(301).orElse(null);
        assertThat(testStore).isNotNull();

        log.info("Test Store data retrieved from database");
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void createNewStoreTest(){

//        Store londonStore =new Store();
//        londonStore.setStoreName("londonstore");
//        londonStore.setState("Lagos");
//        londonStore.setCity("lekki");
//        londonStore.setStoreNumber(354);
//        londonStore.setAddress("24 london street");
//        londonStore.setCountry("Nigeria");
//
//        assertThat(londonStore.getId()).isNull();
//        londonStore = storeRepository.save(londonStore);
//        log.info("After saving store object -->" + londonStore);
//        assertThat(londonStore.getId()).isNotNull();




        Store store = new Store();
        store.setStoreName("Nonye Store");
        store.setState("Lagos");
        store.setCity("Aja");
        store.setStoreNumber(30);
        store.setAddress("3 Ikeja Lagos");
        store.setCountry("Nigeria");


        log.info("Created store object --> " + store);
        assertThat(store.getId()).isNull();


        store = storeRepository.save(store);
        log.info("After saving store object -->" + store);
        assertThat(testStore.getId()).isNotNull();
    }

//    Adding pet to Pet db
    @Test
    void whenAddPetsToStore_thenSaveToDbTest(){

            Pet pet = new Pet();
            pet.setAge(5);
            pet.setName("Bingo");
            pet.setSex(PetSex.FEMALE);
            pet.setTypes(PetTypes.DOG);
            pet.setBreed("bull dog");
            pet.setBirthDate(new Date());
            pet.setPetStore(testStore);
            testStore.addPet(pet);

            testStore = storeRepository.save(testStore);
        log.info("After saving store object -->" + testStore);


//        Fetch a pet from Database
    }

    @Test
    void whenStoreIsRetrieved_thenRetrievedStorePets(){

        Pet pet1= new Pet();
        pet1.setAge(5);
        pet1.setName("Bingo");
        pet1.setSex(PetSex.FEMALE);
        pet1.setTypes(PetTypes.DOG);
        pet1.setBreed("bull dog");
        pet1.setBirthDate(new Date());
        pet1.setPetStore(testStore);


        Pet pet2 = new Pet();
        pet2.setAge(5);
        pet2.setName("Bingo");
        pet2.setSex(PetSex.FEMALE);
        pet2.setTypes(PetTypes.DOG);
        pet2.setBreed("bull dog");
        pet2.setBirthDate(new Date());
        pet2.setPetStore(testStore);

//        add pets tpo store

        testStore.addPet(pet1);
        testStore.addPet(pet2);

//        save to store

        testStore =storeRepository.save(testStore);
        log.info("store object saved to the db -->"+ testStore);

        Store savedStore = storeRepository.findById(testStore.getId()).orElse(null);

        assertThat(savedStore.getPets()).isNotNull();
        assertThat(savedStore.getPets()).hasSize(2);

    }

    @Test
   void   retrivesAllPetsInAStoreTest(){
        Pet pet1= new Pet();
        pet1.setAge(5);
        pet1.setName("Bingo");
        pet1.setSex(PetSex.FEMALE);
        pet1.setTypes(PetTypes.DOG);
        pet1.setBreed("bull dog");
        pet1.setBirthDate(new Date());
        pet1.setPetStore(testStore);


        Pet pet2 = new Pet();
        pet2.setAge(5);
        pet2.setName("Bingo");
        pet2.setSex(PetSex.FEMALE);
        pet2.setTypes(PetTypes.DOG);
        pet2.setBreed("bull dog");
        pet2.setBirthDate(new Date());
        pet2.setPetStore(testStore);

//        add pets tpo store

        testStore.addPet(pet1);
        testStore.addPet(pet2);

//        save to store

        testStore =storeRepository.save(testStore);
        log.info("store object saved to the db -->"+ testStore);

        Store savedStore = storeRepository.findById(testStore.getId()).orElse(null);

        assertThat(savedStore.getPets()).isNotNull();
        assertThat(savedStore.getPets()).hasSize(2);

        List<Pet> petList = savedStore.getPets();
        petList.forEach(System.out::println);

    }


}