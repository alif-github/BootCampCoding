package Day3.ExceptionOther.nexsoft;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    void method() throws IOException {
        Scanner userInput = new Scanner(System.in);
        int a;
        int b;

        System.out.print("Masukkan a : ");
        a = userInput.nextInt();
        System.out.print("Masukkan b : ");
        b = userInput.nextInt();

        if (a > b) {
            System.out.println("device operation performed");
        } else {
            throw new IOException("device error");
        }
    }

    public static void main(String[] args) throws IOException {
        Test m = new Test();

        try {
            m.method();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Normal Flow...");
    }
}
