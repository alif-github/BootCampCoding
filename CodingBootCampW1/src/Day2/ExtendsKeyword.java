package Day2;

class Calculation {
    int z;

    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers : " + z);
    }

    public void Subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference between the given numbers : " + z);
    }
}

public class ExtendsKeyword extends Calculation {

    public void multiplication(int x, int y) {
        z = x * y;
        System.out.println("The product of the given numbers : " + z);
    }

    public static void main(String[] args) {
        int a = 20, b = 10;
        ExtendsKeyword demo = new ExtendsKeyword();
        demo.addition(a, b);
        demo.Subtraction(a, b);
        demo.multiplication(a, b);
    }
}
