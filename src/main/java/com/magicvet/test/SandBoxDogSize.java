package com.magicvet.test;

import com.magicvet.model.Dog;

import java.util.Arrays;
import java.util.Comparator;

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

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });

        for (Dog dog: dogs) {
            System.out.println(dog.getSize());
        }
    }
}
