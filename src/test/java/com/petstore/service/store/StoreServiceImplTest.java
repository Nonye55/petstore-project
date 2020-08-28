package com.petstore.service.store;

import com.petstore.models.Pet;
import com.petstore.models.PetSex;
import com.petstore.models.PetTypes;
import com.petstore.models.Store;
import com.petstore.repository.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@SpringBootTest
@Sql(scripts = {"classpath:db\\insert-store.sql"})

class StoreServiceImplTest {

    Logger log  = Logger.getLogger(getClass().getName());

    @Mock
    StoreRepository storeRepository;

    @Autowired
    StoreRepository concreteStoreRepo;

    @InjectMocks
    Store testStore;
    StoreService storeService;



    @BeforeEach
    void setUp() {
        storeService = new StoreServiceImpl();
        MockitoAnnotations.initMocks(this);
        testStore = new Store();
    }

    @Test
    void save() {

        when(storeRepository.save(testStore)).thenReturn(testStore);
        storeRepository.save(testStore);

        verify(storeRepository,times(1)).save(testStore);
    }

    @Test
    void findById() {

        when(storeRepository.findById(43)).thenReturn(Optional.of(testStore));
        storeRepository.findById(43);

        verify(storeRepository,times(1)).findById(43);
    }

    @Test
    void update() {
        when(storeRepository.save(testStore)).thenReturn(testStore);
        storeRepository.save(testStore);

        verify(storeRepository,times(1)).save(testStore);
    }

    @Test
    void delete() {

        doNothing().when(storeRepository).deleteById(3);
        storeRepository.deleteById(3);
    }

    @Test
    void findAll() {

        List<Store> storeList = storeRepository.findAll();
        when(storeRepository.findAll()).thenReturn(storeList);

        verify(storeRepository,times(1)).findAll();
    }

//    @Test
//    void addPets() {
////        retive stre details
//
//        Store savedStore = concreteStoreRepo.findById(2).orElse(null);
//        assertThat(savedStore).isNull();
//        assert false;
//        assertThat(savedStore.getPets()).hasSize(0);
//
////        add pets to store
//
//        Pet pet = new Pet();
//        pet.setAge(5);
//        pet.setName("Bingo");
//        pet.setSex(PetSex.FEMALE);
//        pet.setTypes(PetTypes.DOG);
//        pet.setBreed("bull dog");
//        pet.setBirthDate(new Date());
//        pet.setPetStore(savedStore);
//
//        savedStore.addPet(pet);
//
//
////        save store
//        concreteStoreRepo.save(savedStore);
//
////        retrive store
//
//         Store savedStore2 = concreteStoreRepo.findById(1).orElse(null);
//
////        verify that store is added
//
//        assert savedStore2 != null;
//        assertThat(savedStore2.getPets()).hasSize(1);
//        assertThat(savedStore2.getPets().get(0)).isNotNull();
//
//    }
}