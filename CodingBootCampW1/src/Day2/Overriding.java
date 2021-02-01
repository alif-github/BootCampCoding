package Day2;

class Animal2 {
    public void move() {
        System.out.println("Animals can move");
    }
}

class Dog extends Animal2 {
    @Override
    public void move() {
        System.out.println("Dogs can walk and run");
    }

    public void bark() {
        System.out.println("Dogs can bark");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Animal2 a = new Animal2(); //Animal reference and object
        Animal2 b = new Dog(); //Animal reference but dog object

        a.move();
        b.move();
//        b.bark();
    }
}
