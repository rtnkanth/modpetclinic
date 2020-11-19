package rtnk.springframework.modpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtnk.springframework.modpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
