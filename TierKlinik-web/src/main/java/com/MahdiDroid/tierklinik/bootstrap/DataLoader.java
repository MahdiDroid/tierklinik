package com.MahdiDroid.tierklinik.bootstrap;

import com.MahdiDroid.tierklinik.model.Owner;
import com.MahdiDroid.tierklinik.model.Vet;
import com.MahdiDroid.tierklinik.services.OwnerService;
import com.MahdiDroid.tierklinik.services.VetService;
import com.MahdiDroid.tierklinik.services.map.OwnerServiceMap;
import com.MahdiDroid.tierklinik.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("watson");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("laila");
        owner2.setLastName("eilk");

        ownerService.save(owner2);

        System.out.println("owners loaded .");

        Vet vet1 = new Vet();

        vet1.setFirstName("sam");
        vet1.setLastName(("axess"));

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("jack");
        vet2.setLastName(("parson"));

        vetService.save(vet2);
        System.out.println("vet loaded .");


    }
}
