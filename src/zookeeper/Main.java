package zookeeper;

import com.sun.source.tree.WhileLoopTree;
import zookeeper.enums.MainMenu;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        List<Animal> animals = new ArrayList<>();
        System.out.print("Hello and welcome to bjustin's Zoo! \n");
        System.out.println("Please select action \n");
        Scanner input = new Scanner(System.in);

        while (true){
                try{
                    System.out.println("1 - Add Animals");
                    System.out.println("2 - List Animals");
                    System.out.println("3 - LookUp Animals");
                    System.out.println("4 - View Enclosure of Animals");
                    System.out.println("5 - Exit \n");
                    int choice = input.nextInt();
                    switch (choice){
                    case  1: {
                        while(true){
                            try{
                                System.out.println("Please provide name: ");
                                String animalName = input.next();
                                System.out.println("Please provide type: 1 - Kambing, 2 - Kalapati ");
                                int animalTypeInput = input.nextInt();

                                if (animalTypeInput == 1){
                                    Animal kambing = new Kambing(animalName);
                                    kambing.makeSound();
                                    zoo.addAnimal(kambing);
                                    break;
                                }else if(animalTypeInput == 2){
                                    Animal kalapati = new Kalapati(animalName);
                                    kalapati.makeSound();
                                    zoo.addAnimal(kalapati);
                                    break;
                                }else{
                                    System.out.println("Invalid input(s)");
                                }
                            }catch (java.util.InputMismatchException e) {
                                System.out.println("Invalid INPUT!!! Input should be the integer provided in the options");
                                input.nextLine();
                            }
                        }
                        break;
                    }
                        case 2: {
                           zoo.getAnimals();
                            break;
                        }
                        case 3: {
                            System.out.println("Please provide animal name: ");
                            String animalName = input.next();
                            zoo.lookUpAnimal(animalName);
                            break;
                        }
                        case 4: {
                            System.out.println("Please provide enclosure type: ");
                            String enclosureType = input.next();
                            zoo.viewEnclosure(enclosureType);
                            break;
                        }
                        case  5: {
                            System.out.println("Exiting application...");
                            System.exit(0);
                        }
                        default : {
                            System.out.println("Please use correct input");
                        }
                    }
                }catch (java.util.InputMismatchException e){
                    System.out.println("Invalid INPUT!!! Input should be the integer provided in the options");
                    input.nextLine();
            }

        }


    }
}