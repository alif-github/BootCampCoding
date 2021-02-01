package Day2;

class SuperClass {
    int age; //protected

    SuperClass(int age) {
        this.age = age;
    }

    public void getAge() {
        System.out.println("The value of the variable named age in super class is : " + age);
    }
}

public class SuperclassConstructor extends SuperClass {
    int id;

    SuperclassConstructor(int id, int age) {
        super(age);
        this.id = id;
    }

    public static void main(String[] args) {
        SuperclassConstructor s = new SuperclassConstructor(24, 21);
        s.getAge();
    }
}
