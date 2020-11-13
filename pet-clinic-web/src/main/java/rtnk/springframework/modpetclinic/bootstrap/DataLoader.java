package rtnk.springframework.modpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rtnk.springframework.modpetclinic.model.Owner;
import rtnk.springframework.modpetclinic.model.Pet;
import rtnk.springframework.modpetclinic.model.PetType;
import rtnk.springframework.modpetclinic.model.Vet;
import rtnk.springframework.modpetclinic.services.OwnerService;
import rtnk.springframework.modpetclinic.services.PetTypeService;
import rtnk.springframework.modpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");;
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstname("Tony");
        owner1.setLastname("Stark");
        owner1.setAddress("94-140 SriRam Nagar");
        owner1.setCity("Guntur");
        owner1.setTelephone("9876543210");
        ownerService.save(owner1);

        Pet tonysPet = new Pet();
        tonysPet.setPetType(savedDogPetType);
        tonysPet.setOwner(owner1);
        tonysPet.setBirthDate(LocalDate.now());
        tonysPet.setName("Alex");
        owner1.getPets().add(tonysPet);

        Owner owner2 = new Owner();
        owner2.setFirstname("Steve");
        owner2.setLastname("Rogers");
        owner2.setAddress("94-142 Benz Circle");
        owner2.setCity("Vijayawada");
        owner2.setTelephone("9432187650");
        ownerService.save(owner2);

        Pet stevesPet = new Pet();
        stevesPet.setPetType(savedCatPetType);
        stevesPet.setOwner(owner2);
        stevesPet.setBirthDate(LocalDate.now());
        stevesPet.setName("Lucy");
        owner1.getPets().add(stevesPet);

        System.out.println("Owners Loaded....");

        Vet vet1 = new Vet();
        vet1.setFirstname("Carol");
        vet1.setLastname("Denvers");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Nat");
        vet2.setLastname("Romanoff");
        vetService.save(vet2);

        System.out.println("Vets Loaded....");

    }
}