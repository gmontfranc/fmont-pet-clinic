package com.fmont.petclinic.bootstrap;

import com.fmont.petclinic.model.Owner;
import com.fmont.petclinic.services.OwnerService;
import com.fmont.petclinic.services.VetService;
import com.fmont.petclinic.model.Vet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner fred = new Owner("Fred","Delmotte");

        ownerService.save(fred);

        Owner merel = new Owner("Merel", "Markusse");

        ownerService.save(merel);

        System.out.println("Loaded Owners...");

        Vet louise = new Vet("Louise","Unkwown");

        vetService.save(louise);

        Vet nicolas = new Vet("Nicolas","GF");

        vetService.save(nicolas);

        System.out.println("Vet Loaded...");
    }
}
