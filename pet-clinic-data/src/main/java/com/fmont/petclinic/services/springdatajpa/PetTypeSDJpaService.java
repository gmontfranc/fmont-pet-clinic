package com.fmont.petclinic.services.springdatajpa;

import com.fmont.petclinic.model.PetType;
import com.fmont.petclinic.repositories.PetTypeRepository;
import com.fmont.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
    
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petType -> petTypes.add(petType));
        return petTypes;
    }

    @Override
    public PetType findById(Long Id) {
        Optional<PetType> optionalPetType = petTypeRepository.findById(Id);
        return optionalPetType.orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long Id) {
        petTypeRepository.deleteById(Id);
    }
}
