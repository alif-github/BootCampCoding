package Day1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class IOStringBufferTry {
    public static void main(String[] argd) {
        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout1.txt");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            String s = "Welcome To the Jungle";
            byte b[] = s.getBytes();//Convert String to Byte
            bout.write(b);
            bout.flush();
            bout.close();
            fout.close();
            System.out.println("Success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //buffer untuk data yang sangat besar agar di cetak sedikit sedikit(Pelan pelan dulu)
}
