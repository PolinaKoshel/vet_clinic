package com.magicvet.test;

import com.magicvet.model.Cat;
import com.magicvet.model.Dog;
import com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBoxPetHealth {

    public static void main(String[] args) {

        Dog[] dogs = {

             new Dog(Pet.Health.HEALTHY),
             new Dog(Pet.Health.URGENT_REQUEST),
             new Dog(Pet.Health.GET_WELL),
             new Dog(Pet.Health.DISEASED),
             new Dog(Pet.Health.DISEASED),
             new Dog(Pet.Health.GET_WELL),

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

              new Cat(Pet.Health.GET_WELL),
              new Cat(Pet.Health.URGENT_REQUEST),
              new Cat(Pet.Health.DISEASED),
              new Cat(Pet.Health.DISEASED),
              new Cat(Pet.Health.GET_WELL),

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
