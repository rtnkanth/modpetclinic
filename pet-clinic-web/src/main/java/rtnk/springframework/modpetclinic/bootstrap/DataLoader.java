package rtnk.springframework.modpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rtnk.springframework.modpetclinic.model.Owner;
import rtnk.springframework.modpetclinic.model.Vet;
import rtnk.springframework.modpetclinic.services.OwnerService;
import rtnk.springframework.modpetclinic.services.VetService;
import rtnk.springframework.modpetclinic.services.map.OwnerServiceMap;
import rtnk.springframework.modpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("John");
        owner1.setLastname("Bokka");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstname("Jessie");
        owner2.setLastname("Samson");
        ownerService.save(owner2);

        System.out.println("Owners Loaded....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Brie");
        vet1.setLastname("Larson");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstname("Nat");
        vet2.setLastname("Romanoff");
        vetService.save(vet2);

        System.out.println("Vets Loaded....");

    }
}