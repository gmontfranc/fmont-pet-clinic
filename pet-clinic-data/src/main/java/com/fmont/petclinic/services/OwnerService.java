package com.fmont.petclinic.services;
import com.fmont.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
