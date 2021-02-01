package KumpulanTugas.ThreadPoolThread;

import java.io.*;
import java.io.IOException;

public class Thread extends java.lang.Thread {
    public void run() {
        try (BufferedReader in = new BufferedReader(new FileReader
                ("C:\\Users\\user\\IdeaProjects\\KumpulanTugas_Week1_Bootcamp\\src\\main\\java\\ThreadPoolThread\\file.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] ar = str.split(",");
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " (Start) = " + ar[i]);
                    processmessage();
                    System.out.println(Thread.currentThread().getName() + " (End)");
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    private void processmessage() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
