package com.MahdiDroid.tierklinik.services.map;

import com.MahdiDroid.tierklinik.model.Pet;
import com.MahdiDroid.tierklinik.model.Specialty;
import com.MahdiDroid.tierklinik.model.Vet;
import com.MahdiDroid.tierklinik.services.CrudService;
import com.MahdiDroid.tierklinik.services.SpecialityService;
import com.MahdiDroid.tierklinik.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;




@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private  final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialties().size() > 0  ){
            object.getSpecialties().forEach(s ->{
                if(s.getId() == null){
                    Specialty savedSpecialty = specialityService.save(s);
                    s.setId(savedSpecialty.getId());

                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
