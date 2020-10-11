package com.fmont.petclinic.bootstrap;

import com.fmont.petclinic.model.*;
import com.fmont.petclinic.services.OwnerService;
import com.fmont.petclinic.services.PetTypeService;
import com.fmont.petclinic.services.SpecialtyService;
import com.fmont.petclinic.services.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Car");

        PetType savedCat = petTypeService.save(cat);


        Owner fred = new Owner("Fred", "Delmotte");
        fred.setAddress("Woluwe");
        fred.setCity("Bruxelles");
        fred.setTelephone("123456789");

        Pet fredsPet = new Pet();
        fredsPet.setPetType(savedCat);
        fredsPet.setOwner(fred);
        fredsPet.setBirthDate(LocalDate.now());
        fredsPet.setName("Ollie");
        fred.getPets().add(fredsPet);
        ownerService.save(fred);

        Owner merel = new Owner("Merel", "Markusse");
        merel.setAddress("Grotesteenweg");
        merel.setCity("Antwerpen");
        merel.setTelephone("321654");

        Pet merelsPet = new Pet();
        merelsPet.setPetType(savedDog);
        merelsPet.setName("Dunno");
        merelsPet.setBirthDate(LocalDate.now());
        merelsPet.setOwner(merel);

        merel.getPets().add(merelsPet);

        ownerService.save(merel);

        System.out.println("Loaded Owners...");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty saveDentistry = specialtyService.save(dentistry);

        Vet louise = new Vet("Louise", "Unkwown");
        louise.getSpecialties().add(savedRadiology);

        vetService.save(louise);

        Vet nicolas = new Vet("Nicolas", "GF");
        nicolas.getSpecialties().add(savedSurgery);

        vetService.save(nicolas);

        System.out.println("Vet Loaded...");
    }
}
