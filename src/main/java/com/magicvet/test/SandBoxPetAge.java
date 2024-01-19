package main.java.com.magicvet.test;

import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBoxPetAge {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Age.two),
                new Dog(Dog.Age.twelve),
                new Dog(Dog.Age.eight),
                new Dog(Dog.Age.six),
                new Dog(Dog.Age.one),
                new Dog(Dog.Age.ten),
                new Dog(Dog.Age.nine),
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
    }
}
