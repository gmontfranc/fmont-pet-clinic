package com.fmont.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    private Set<Pet> pets;
    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
        pets = new HashSet<>();
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
