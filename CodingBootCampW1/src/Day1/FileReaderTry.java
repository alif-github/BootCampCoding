package Day1;

import java.io.FileReader;

public class FileReaderTry {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout2.txt");
            int i;

            while((i = fr.read())!=-1){
                System.out.print((char) i);
            }

            fr.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
