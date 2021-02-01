package Day2;

class Super_class {
    int num = 20;

    //display method of superclass
    public void display() {
        System.out.println("This is the display method of superclass");
    }
}

public class SuperKeyword extends Super_class {
    int num = 10;

    //display method of sub class
    public void display() {
        System.out.println("This is the display method of subclass");
    }

    public void my_method() {
        //Intantiating subclass
        SuperKeyword sub = new SuperKeyword();

        //Invoking the display() method of sub class
        sub.display();

        //Invoking the display() method of super class
        super.display();

        //printing the value of variable num of subclass
        System.out.println("value of the variable named num in sub class : " + num);

        //printing the value of variable num of superclass
        System.out.println("value of the variable named num in super class : " + super.num);
    }

    public static void main(String[] args) {
        SuperKeyword obj = new SuperKeyword();
        obj.my_method();
    }
}
