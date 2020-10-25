package com.fmont.petclinic.services.springdatajpa;

import com.fmont.petclinic.model.Vet;
import com.fmont.petclinic.repositories.VetRepository;
import com.fmont.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vet -> vets.add(vet));
        return vets;
    }

    @Override
    public Vet findById(Long Id) {
        Optional<Vet> optionalVet = vetRepository.findById(Id);
        return optionalVet.orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long Id) {
        vetRepository.deleteById(Id);
    }
}
