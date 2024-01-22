package main.java.com.magicvet.test;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBoxPetHealth {

    public static void main(String[] args) {

        Dog[] dogs = {

             new Dog(Pet.Health.healthy),
             new Dog(Pet.Health.urgent_request),
             new Dog(Pet.Health.get_well),
             new Dog(Pet.Health.diseased),
             new Dog(Pet.Health.diseased),
             new Dog(Pet.Health.get_well),

        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getHealth().getValue() - o2.getHealth().getValue();
            }
        } );

        for(Dog dog: dogs) {
            System.out.println(dog.getHealth());
        }

        System.out.println("\n");

        Cat[] cats = {

              new Cat(Pet.Health.get_well),
              new Cat(Pet.Health.urgent_request),
              new Cat(Pet.Health.diseased),
              new Cat(Pet.Health.diseased),
              new Cat(Pet.Health.get_well),

        };

        Arrays.sort(cats, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getHealth().getValue() - o2.getHealth().getValue();
            }
        } );

        for(Cat cat: cats) {
            System.out.println(cat.getHealth());
        }

    }
}
