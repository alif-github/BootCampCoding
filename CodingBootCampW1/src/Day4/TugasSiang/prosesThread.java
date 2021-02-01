package Day4.TugasSiang;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class prosesThread extends Thread {

    Thread thread;
    String st;
    String file = "C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\TugasSiang\\file.txt";
    String fileASC = "C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\TugasSiang\\fileASC.txt";
    String fileDSC = "C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\TugasSiang\\fileDSC.txt";

    public void readFile() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((st = in.readLine()) != null) {
                String[] ar = st.split(",");
                for (int i = 0; i < 10; i++) {
                    System.out.println("Urutan ke-" + (i + 1) + " adalah " + ar[i]);
                }
            }
            System.out.println("--------------------------------------------------");
        } catch (IOException e) {
            System.out.println("File Read Error : " + e);
        }
    }

    public void simpleTh() throws InterruptedException {
        thread = new Thread() {
            @Override
            public void run() {
                readFile();
                System.out.println("Tunggu 5 Detik");
                try {
                    thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };
        thread.start();
        thread.join();
    }

    public void readFileAsc() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((st = in.readLine()) != null) {
                String[] ar = st.split(",");
                Arrays.sort(ar);
                for (int i = 0; i < 10; i++) {
                    System.out.println(ar[i]);
                }
            }
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void rdWriteASc() throws InterruptedException {
        thread = new Thread() {
            @Override
            public void run() {
                readFileAsc();
                System.out.println("Tunggu 5 Detik");
                try {
                    thread.sleep(5000);
                    WriteFileAsc();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };
        thread.start();
        thread.join();
    }

    public void WriteFileAsc() {
        System.out.println("Tulis ASC fileASC.txt");
        System.out.println("Success.....");

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            FileWriter wr = new FileWriter(fileASC);
            wr.write("========================\n");
            wr.write("File ASC !\n");
            wr.write("========================\n");

            while ((st = in.readLine()) != null) {
                String[] ar = st.split(",");
                Arrays.sort(ar);
                for (int i = 0; i < ar.length; i++) {
                    wr.write("(" + ar[i] + ")\n");
                }
            }
            wr.write("========================");
            wr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readFileDsc() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((st = in.readLine()) != null) {
                String[] ar = st.split(",");
                Arrays.sort(ar, Collections.reverseOrder());
                for (int i = 0; i < 10; i++) {
                    System.out.println(ar[i]);
                }
            }
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void WriteFileDsc() {
        System.out.println("Tulis DSC fileDSC.txt");
        System.out.println("Success.....");

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            FileWriter wr = new FileWriter(fileDSC);
            wr.write("========================\n");
            wr.write("File DSC !\n");
            wr.write("========================\n");

            while ((st = in.readLine()) != null) {
                String[] ar = st.split(",");
                Arrays.sort(ar, Collections.reverseOrder());
                for (int i = 0; i < ar.length; i++) {
                    wr.write("(" + ar[i] + ")\n");
                }
            }
            wr.write("========================");
            wr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void rdWriteDSc() throws InterruptedException {
        thread = new Thread() {
            @Override
            public void run() {
                readFileDsc();
                System.out.println("Tunggu 5 Detik");
                try {
                    thread.sleep(5000);
                    WriteFileDsc();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };
        thread.start();
        thread.join();
    }
}
