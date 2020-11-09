package rtnk.springframework.modpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rtnk.springframework.modpetclinic.model.Owner;
import rtnk.springframework.modpetclinic.model.Vet;
import rtnk.springframework.modpetclinic.services.OwnerService;
import rtnk.springframework.modpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstname("John");
        owner1.setLastname("Bokka");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Jessie");
        owner2.setLastname("Samson");
        ownerService.save(owner2);

        System.out.println("Owners Loaded....");

        Vet vet1 = new Vet();
        vet1.setFirstname("Brie");
        vet1.setLastname("Larson");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Nat");
        vet2.setLastname("Romanoff");
        vetService.save(vet2);

        System.out.println("Vets Loaded....");

    }
}