package com.petstore.service.store;

import com.petstore.models.Pet;
import com.petstore.models.Store;
import com.petstore.service.exception.StoreObjectNotPresentException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StoreService {

    Store save(Store store);

   Optional< Store> findById(Integer petId);

    Store update(Store store);

    void delete(Integer storeId);

    List<Store> findAll();


//    to add pet to the store

    Store addPets(Pet pet,Integer storeId) throws StoreObjectNotPresentException;


//    To fine all pets

    List<Pet> findStorePets(Integer storeId) throws StoreObjectNotPresentException;
}
