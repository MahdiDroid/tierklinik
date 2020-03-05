package com.MahdiDroid.tierklinik.services.map;

import com.MahdiDroid.tierklinik.model.Owner;
import com.MahdiDroid.tierklinik.model.Pet;
import com.MahdiDroid.tierklinik.services.CrudService;
import com.MahdiDroid.tierklinik.services.OwnerService;
import com.MahdiDroid.tierklinik.services.PetService;
import com.MahdiDroid.tierklinik.services.PetTypeService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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

        if(object.getPets() != null){
            object.getPets().forEach(pet -> {
                if (pet.getPetType() != null){
                    if (pet.getPetType().getId() == null){
                        pet.setPetType((petTypeService.save(pet.getPetType())));
                    }


                }else{
                    throw  new RuntimeException("pet Type is requird");
                }
                if (pet.getId()== null){
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }

            });

            return super.save(object);
        }else{
            return null;
        }

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
