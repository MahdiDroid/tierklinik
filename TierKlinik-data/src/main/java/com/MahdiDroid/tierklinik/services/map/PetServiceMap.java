package com.MahdiDroid.tierklinik.services.map;

import com.MahdiDroid.tierklinik.model.Owner;
import com.MahdiDroid.tierklinik.model.Pet;
import com.MahdiDroid.tierklinik.services.CrudService;
import com.MahdiDroid.tierklinik.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
