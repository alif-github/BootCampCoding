package Day1;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterTry {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout3.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write("Welcome to G2");
        buffer.close();
        System.out.println("Success...");
    }
}
