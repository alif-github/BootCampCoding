package Day3.ImplementException.nexsoft;


import java.io.IOException;

public class ExceptionIm {
    int maximumUmur = 20;
    int umurPengunjung = 16;

    void p() {
        try {
            if (umurPengunjung <= maximumUmur) {
                throw new IOException("Pengunjung dibawah umur, tidak boleh masuk"); //checked exception
            } else {
                System.out.println("Pengunjung dibolehkan masuk");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("exception handled");
        }
    }

    public static void main(String[] args) {
        ExceptionIm obj = new ExceptionIm();
        obj.p();
        System.out.println("normal flow...");
    }
}
