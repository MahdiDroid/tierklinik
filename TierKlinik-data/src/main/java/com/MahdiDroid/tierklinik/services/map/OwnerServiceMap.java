package com.MahdiDroid.tierklinik.services.map;

import com.MahdiDroid.tierklinik.model.Owner;
import com.MahdiDroid.tierklinik.services.CrudService;
import com.MahdiDroid.tierklinik.services.OwnerService;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
