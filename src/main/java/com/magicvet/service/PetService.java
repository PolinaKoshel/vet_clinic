package com.magicvet.service;

import com.magicvet.Main;
import com.magicvet.model.Cat;
import com.magicvet.model.Dog;
import com.magicvet.model.Pet;

import java.util.Optional;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";


    public Pet registerNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if(DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }

        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE)? new Cat(): new Dog();
        pet.setType(type);

        System.out.print("Age by letters (ONE/ TWO/ etc.): ");
        String age = Main.SCANNER.nextLine();
        pet.setAge(Pet.Age.fromString(age));

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        System.out.print("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        System.out.print("State of health (URGENT_REQUEST/ DISEASED/ GET_WELL/ HEALTHY): ");
        String healthState = Main.SCANNER.nextLine();
        pet.setHealth(Pet.Health.fromString(healthState));

        if(type.equals(DOG_TYPE))  {
            System.out.println("Size (XS / S / M / L / XXL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.fromString(size));
        }
        return pet;
    }
}
