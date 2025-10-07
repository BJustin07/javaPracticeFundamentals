public class Kambing extends Animal {
    public Kambing(String name){
        super(name);
    }

    @Override
    public void makeSound(){
        System.out.println(getName() + " mehhhhhehhehhhhhh");
    }

    public void chewGrass(){
        System.out.println(getName() + " is chewing grass");
    }
}
