package Day1;

import java.io.FileOutputStream;

public class IOTry {
    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\test.txt");
            fout.write(80);
            fout.close();
            System.out.println("Success...");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
