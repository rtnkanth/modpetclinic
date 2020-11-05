package rtnk.springframework.modpetclinic.services;

import rtnk.springframework.modpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long Id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
