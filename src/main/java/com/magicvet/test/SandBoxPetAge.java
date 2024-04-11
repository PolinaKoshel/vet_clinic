package com.magicvet.test;

import com.magicvet.model.Cat;
import com.magicvet.model.Dog;
import com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBoxPetAge {

    public static void main(String[] args) {

        Dog[] dogs = {
                new Dog(Pet.Age.TWO),
                new Dog(Pet.Age.SEVEN),
                new Dog(Pet.Age.FIVE),
                new Dog(Pet.Age.THIRTEEN),
                new Dog(Pet.Age.ONE),
                new Dog(Pet.Age.FIFTEEN),
                new Dog(Pet.Age.NINE),
        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getAge().getValue() - o2.getAge().getValue();
            }
        } );

        for(Dog dog: dogs) {
            System.out.println(dog.getAge());
        }

        System.out.println("\n");

        Cat[] cats = {
                new Cat(Pet.Age.TWO),
                new Cat(Pet.Age.SEVEN),
                new Cat(Pet.Age.EIGHT),
                new Cat(Pet.Age.SIX),
                new Cat(Pet.Age.ONE),
                new Cat(Pet.Age.FIVE),
                new Cat(Pet.Age.NINE),
        };

        Arrays.sort(cats, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getAge().getValue() - o2.getAge().getValue();
            }
        } );

        for(Cat cat: cats) {
            System.out.println(cat.getAge());
        }

    }
}
