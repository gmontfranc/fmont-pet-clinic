package com.fmont.petclinic.services.springdatajpa;

import com.fmont.petclinic.model.Specialty;
import com.fmont.petclinic.repositories.SpecialtyRepository;
import com.fmont.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialty -> specialties.add(specialty));
        return specialties;
    }

    @Override
    public Specialty findById(Long Id) {
        Optional<Specialty> optionalSpecialty = specialtyRepository.findById(Id);
        return optionalSpecialty.orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long Id) {
        specialtyRepository.deleteById(Id);
    }
}
