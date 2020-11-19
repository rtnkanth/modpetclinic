package rtnk.springframework.modpetclinic.services;

import rtnk.springframework.modpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
