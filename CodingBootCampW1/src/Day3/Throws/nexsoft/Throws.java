package Day3.Throws.nexsoft;

import java.io.IOException;

public class Throws {
    void m() throws IOException {
        throw new IOException("device error");
    }

    void n() throws IOException {
        m();
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("exception handled");
        }
    }

    public static void main(String[] args) {
        Throws obj = new Throws();
        obj.p();
        System.out.println("normal flow...");
    }
}
