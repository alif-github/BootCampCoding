package Day2;

class Animal4 {
    public void move() {
        System.out.println("Animals can move");
    }
}

class Dog4 extends Animal4 {
    public void move() {
        super.move();
        System.out.println("Dogs can walk and run");
    }
}

public class Super_Overriding {
    public static void main(String[] args) {
        Animal4 b = new Dog4();
        b.move();
    }
}
