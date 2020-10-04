package fmont.petclinic.bootstrap;

import fmont.petclinic.model.Owner;
import fmont.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.VetService;
import services.map.OwnerServiceMap;
import services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner fred = new Owner("Fred","Delmotte");
        fred.setId(1L);

        ownerService.save(fred);

        Owner merel = new Owner("Merel", "Markusse");
        merel.setId(2L);

        ownerService.save(merel);

        System.out.println("Loaded Owners...");

        Vet louise = new Vet("Louise","Unkwown");
        louise.setId(3L);

        vetService.save(louise);

        Vet nicolas = new Vet("Nicolas","GF");
        nicolas.setId(4L);

        vetService.save(nicolas);

        System.out.println("Vet Loaded...");
    }
}
