package com.MahdiDroid.tierklinik.services;

import com.MahdiDroid.tierklinik.model.Owner;
import com.MahdiDroid.tierklinik.model.Pet;

import java.util.Set;

public interface PetService {


    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
