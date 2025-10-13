package zookeeper;

public abstract class Animal {
    private String name;

    public Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void makeSound();

    public void petAnimal(String petName){
        System.out.println("Petting: " + petName + " until he runs out of breath");
    }

}

