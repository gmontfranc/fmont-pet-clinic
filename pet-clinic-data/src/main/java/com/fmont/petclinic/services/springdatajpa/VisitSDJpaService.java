package com.fmont.petclinic.services.springdatajpa;

import com.fmont.petclinic.model.Visit;
import com.fmont.petclinic.repositories.VisitRepository;
import com.fmont.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visit -> visits.add(visit));
        return visits;
    }

    @Override
    public Visit findById(Long Id) {
        Optional<Visit> optionalVisit = visitRepository.findById(Id);
        return optionalVisit.orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long Id) {
        visitRepository.deleteById(Id);
    }
}
