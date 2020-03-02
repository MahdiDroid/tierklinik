package com.MahdiDroid.tierklinik.services;

import com.MahdiDroid.tierklinik.model.Pet;
import com.MahdiDroid.tierklinik.model.Vet;

import java.util.Set;

public interface VetService {


    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
