package com.MahdiDroid.tierklinik.bootstrap;

import com.MahdiDroid.tierklinik.model.*;
import com.MahdiDroid.tierklinik.services.OwnerService;
import com.MahdiDroid.tierklinik.services.PetTypeService;
import com.MahdiDroid.tierklinik.services.SpecialityService;
import com.MahdiDroid.tierklinik.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count !=0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology =specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialityService.save(surgery);


        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry =specialityService.save(dentistry);


        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("watson");
        owner1.setAddress("222 sisle strasse");
        owner1.setCity("Istanbul");
        owner1.setTelephone("3333333333333");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Risiko");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("laila");
        owner2.setLastName("eilk");
        owner2.setAddress("777 sisle strasse");
        owner2.setCity("ankara");
        owner2.setTelephone("91455678");

        Pet fionaPet = new Pet();
        fionaPet.setOwner(owner2);
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setName("pekipeki");
        fionaPet.setPetType(savedCatPetType);
        owner1.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.println("owners loaded .");

        Vet vet1 = new Vet();

        vet1.setFirstName("sam");
        vet1.setLastName(("axess"));
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("jack");
        vet2.setLastName(("parson"));
        vet2.getSpecialties().add(savedDentistry);


        vetService.save(vet2);
        System.out.println("vet loaded .");
    }
}
