//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome! \n");

        Animal kambing = new Kambing("testingKAmbing");
        Animal kalapati = new Kalapati("BirdyBirdWapWap");
        Kalapati kalapati2 = new Kalapati("DaSecondBirdyWapWap");

        kalapati.makeSound();
        kambing.makeSound();
        kalapati2.makeSound();
        kalapati2.sendMessage("Burat buraat", "Justin");

        kalapati.petAnimal("Alejandro");
        kambing.petAnimal("Mengmeng");
    }
}