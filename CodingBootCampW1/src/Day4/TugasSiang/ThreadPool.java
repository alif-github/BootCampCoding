package Day4.TugasSiang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThreadPool implements Runnable {
    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new FileReader
                ("C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\TugasSiang\\file.txt"))) {
            String st;
            while ((st = in.readLine()) != null) {
                String[] ar = st.split(",");
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
