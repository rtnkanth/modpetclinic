package rtnk.springframework.modpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import rtnk.springframework.modpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
