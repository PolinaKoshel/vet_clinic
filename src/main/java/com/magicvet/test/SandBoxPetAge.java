package main.java.com.magicvet.test;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBoxPetAge {

    public static void main(String[] args) {

        Dog[] dogs = {
                new Dog(Pet.Age.two),
                new Dog(Pet.Age.seven),
                new Dog(Pet.Age.five),
                new Dog(Pet.Age.thirteen),
                new Dog(Pet.Age.one),
                new Dog(Pet.Age.fifteen),
                new Dog(Pet.Age.nine),
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
                new Cat(Pet.Age.two),
                new Cat(Pet.Age.seven),
                new Cat(Pet.Age.eight),
                new Cat(Pet.Age.six),
                new Cat(Pet.Age.one),
                new Cat(Pet.Age.five),
                new Cat(Pet.Age.nine),
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
