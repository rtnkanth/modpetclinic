package rtnk.springframework.modpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rtnk.springframework.modpetclinic.model.*;
import rtnk.springframework.modpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Tony");
        owner1.setLastName("Stark");
        owner1.setAddress("94-140 Aroma Circle");
        owner1.setCity("Chandigarh");
        owner1.setTelephone("9876543210");

        Pet tonysPet = new Pet();
        tonysPet.setPetType(savedDogPetType);
        tonysPet.setOwner(owner1);
        tonysPet.setBirthDate(LocalDate.now());
        tonysPet.setName("Alex");
        owner1.getPets().add(tonysPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Steve");
        owner2.setLastName("Rogers");
        owner2.setAddress("94-142 Benz Circle");
        owner2.setCity("Vijayawada");
        owner2.setTelephone("9432187650");

        Pet stevesPet = new Pet();
        stevesPet.setPetType(savedCatPetType);
        stevesPet.setOwner(owner2);
        stevesPet.setBirthDate(LocalDate.now());
        stevesPet.setName("Lucy");
        owner2.getPets().add(stevesPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(stevesPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Nail Cut");
        visitService.save(catVisit);

        System.out.println("Owners Loaded....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Carol");
        vet1.setLastName("Denvers");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nat");
        vet2.setLastName("Romanoff");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Bruce");
        vet3.setLastName("Banner");
        vet3.getSpecialities().add(savedDentistry);
        vetService.save(vet3);

        System.out.println("Vets Loaded....");
    }
}