package zookeeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {
    private List<Animal> animals;
    private Map<String, Animal> animalLookup;

    public Zoo(){
        animals = new ArrayList<>();
        animalLookup = new HashMap<>();
    }

    public void getAnimals() {
        if (animals.isEmpty()){
            System.out.println("No animals in the zoo yet!");
            return;
        }
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
        addAnimalLookup(animal.getName(), animal);
        System.out.println("Successfully added animal: " + animal.getName());
        return;
    }

    public void addAnimalLookup(String animalName, Animal animal) {
        animalLookup.put(animalName, animal);
    }

    public void lookUpAnimal(String animalName){
        if (animalLookup.containsKey(animalName)){
            Animal animal = animalLookup.get(animalName);
            animal.getName();
            animal.makeSound();
        }else{
            System.out.println("Animal " + animalName + " not found!");
            return;
        }
    }
}
