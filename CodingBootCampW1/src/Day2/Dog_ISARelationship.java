package Day2;

class Animal {

}

class Mammal extends Animal {

}

class Reptile extends Animal {

}

public class Dog_ISARelationship extends Mammal {
    public static void main(String[] args) {
        Animal a = new Animal();
        Mammal m = new Mammal();
        Dog_ISARelationship d = new Dog_ISARelationship();

        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        System.out.println(d instanceof Animal);
    }
}
