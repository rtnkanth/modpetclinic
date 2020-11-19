package rtnk.springframework.modpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtnk.springframework.modpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
