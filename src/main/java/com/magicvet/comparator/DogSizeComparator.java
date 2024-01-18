package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Dog;

import java.util.Comparator;

public class DogSizeComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dog1, Dog dog2) {
        return dog1.getSize().getValue() - dog2.getSize().getValue();
    }

}

