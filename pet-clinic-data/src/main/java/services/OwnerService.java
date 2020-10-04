package services;
import fmont.petclinic.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);


}
