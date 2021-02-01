package Day1;

import java.io.FileInputStream;

public class IOStringReadTry {
    public static void main(String[] argd) {
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout.txt");
            int i = fin.read();
            System.out.println((char)i); //Read Single Character!

            int l = 0;
            while((l = fin.read())!=-1){ //Read All Content!
                System.out.print((char)l);
            }
            System.out.println();
            fin.close();
            System.out.println("Success...");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}