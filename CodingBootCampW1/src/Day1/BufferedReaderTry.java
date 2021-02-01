package Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderTry {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout3.txt");
        BufferedReader br = new BufferedReader(fr);

        int i;
        while ((i = br.read())!=-1){
            System.out.print((char) i);
        }
        br.close();
        fr.close();
    }
}
