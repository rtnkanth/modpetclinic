package rtnk.springframework.modpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtnk.springframework.modpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
