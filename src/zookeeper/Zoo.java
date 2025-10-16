package zookeeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {
    private List<Animal> animals;
    private Map<String, Animal> animalLookup;
    private HashMap<String, List<Animal>> animalEnclosure;

    public Zoo(){
        animals = new ArrayList<>();
        animalLookup = new HashMap<>();
        animalEnclosure = new HashMap<>();
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

    public void addAnimal(Animal animal) throws InvalidAnimalException, ZooFullException {
        if (animal == null || animal.getName() == null || animal.getName().isEmpty())  {
            throw new InvalidAnimalException("Invalid/Null animal!");
        }
        animals.add(animal);
        addAnimalLookup(animal.getName(), animal);
        String type = "";
        if (animal instanceof Kambing){
            type = "Mammal";
        } else if (animal instanceof Kalapati) {
            type = "Bird";
        }else{
            type = "Alien";
        }

        List<Animal> enclosure = animalEnclosure.get(type);
        if (enclosure == null){
            enclosure = new ArrayList<>();
            animalEnclosure.put(type, enclosure);
            System.out.println("Successfully added animal to enclosure! : " + type );
        }
        if (!isAnimalEnclosureFull(enclosure,type)){
            enclosure.add(animal);
        }
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

    public void viewEnclosure(String type){
        if (animalEnclosure.containsKey(type)){
            List<Animal> enclosure = animalEnclosure.get(type);
            for (Animal animal : enclosure){
                System.out.println("Animal " + animal.getName() + " is in this enclosure: " + type);
            }
        }else{
            System.out.println("Animal " + type + " not found!");
            return;
        }
    }

    public boolean isAnimalEnclosureFull(List<Animal> enclosure, String enclosureType) throws ZooFullException{
        //cap to max 5 animals per enclosure
        Integer animalEnclosureSize = enclosure.size();
        if (animalEnclosureSize < 6) {
            System.out.println("Remaining space for: " + enclosureType + " is: " + (5-animalEnclosureSize));
            return false;
        } else {
            throw new ZooFullException("Enclosure for: " + enclosureType + " is full!");
        }
    }
}
