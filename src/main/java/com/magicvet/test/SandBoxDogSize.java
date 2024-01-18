package main.java.com.magicvet.test;

import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.model.Dog;

import java.util.Arrays;

public class SandBoxDogSize {

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.M),
                 new Dog(Dog.Size.S),
                 new Dog(Dog.Size.XL),
                 new Dog(Dog.Size.XL),
                 new Dog(Dog.Size.XS),
                 new Dog(Dog.Size.S),
                 new Dog(Dog.Size.L),

        };

        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog: dogs) {
            System.out.println(dog.getSize());
        }
    }
}
