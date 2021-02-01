package Day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AnotherISNBufferedReader {
    public static void main(String[] args) throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String name = "";
        while (!name.equalsIgnoreCase("stop")){
            System.out.print("Enter Data : ");
            name = br.readLine();
            System.out.println("data is : "+name);
        }
        br.close();
        r.close();
    }
}
