package Day1;

import java.io.FileWriter;

public class FileWriterTry {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout2.txt");
            fw.write("Welcome to Home");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success....");
    }
}
