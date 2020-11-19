package rtnk.springframework.modpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtnk.springframework.modpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
