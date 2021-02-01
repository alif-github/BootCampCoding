package Day3.Exception.nexsoft;

public class Excp {
    public static void main(String[] args) {
        try {
            int a = 50/0;
        }catch (ArithmeticException e){
            System.out.println("Error...");
        }
        finally {
            System.out.println("Masuk sini");
        }
    }
}
