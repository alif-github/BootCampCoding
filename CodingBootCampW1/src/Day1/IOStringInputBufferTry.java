package Day1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class IOStringInputBufferTry {
    public static void main(String[] argd) {
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout1.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            int l;
            while((l = bin.read())!=-1){ //Read All Content!
                System.out.print((char)l);
            }
            System.out.println();
            bin.close();
            fin.close();
            System.out.println("Success...");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}