package Day2;

interface Animal1 {
}

class Mammal1 implements Animal1 {
}

public class Dog_ImplementsKeyword extends Mammal1 {
    public static void main(String[] args) {
        Mammal1 m = new Mammal1();
        Dog_ImplementsKeyword d = new Dog_ImplementsKeyword();

        System.out.println(m instanceof Animal1);
        System.out.println(d instanceof Mammal1);
        System.out.println(d instanceof Animal1);

    }
}

