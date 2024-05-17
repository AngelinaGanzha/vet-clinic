package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.model.Dog;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
    Dog [] dogs = {
            new Dog(Dog.m),
            new Dog(Dog.s),
            new Dog(Dog.xl),
            new Dog(Dog.m),
    };
    Arrays.sort(dogs, new DogSizeComparator());
    for (Dog dog : dogs) {
        System.out.println(dog.getSize());
    }
    }
}
