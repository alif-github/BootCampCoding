package Day1;

import java.io.FileOutputStream;

public class IOStringTry {
    public static void main(String[] argd) {
        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout.txt");
            String s = "Saya Alif";
            byte b[] = s.getBytes();//Convert String to Byte
            fout.write(b);
            fout.close();
            System.out.println("Success...");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    //Cara untuk menulis di dokumen harus di konversi ke bentuk Byte
}

