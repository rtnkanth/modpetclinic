package rtnk.springframework.modpetclinic.services;

import rtnk.springframework.modpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long Id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
