package zookeeper;

public class Kalapati extends Animal{

    public Kalapati(String name){
        super(name);
    }

    public void makeSound(){
        System.out.println(getName() + " pakaaakPakaaak");
    }

    public String sendMessage(String message, String recipient){
        return "Message is being sent to: " + recipient + " message is: " + message;
    }
}
