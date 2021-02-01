package KumpulanTugas.ThreadPoolThread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class KelasAsc extends java.lang.Thread {

    String [] ar;

    public void run() {
        try (BufferedReader in = new BufferedReader(new FileReader
                ("C:\\Users\\user\\IdeaProjects\\KumpulanTugas_Week1_Bootcamp\\src\\main\\java\\ThreadPoolThread\\file.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                ar = str.split(",");
                for (int i = 0; i < 10; i++) {
                    Arrays.sort(ar);
                    fileAsc();
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    public void fileAsc() {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\user\\IdeaProjects\\KumpulanTugas_Week1_Bootcamp\\src\\main\\java\\ThreadPoolThread\\fileASC.txt"); //test2 is a new file made here
            fw.write("Data Hasil Ascending\n");
            for (int i = 0; i < 10; i++) {
                fw.write(ar[i] + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class KelasDsc extends java.lang.Thread {

    String [] ar;

    public void run() {
        try (BufferedReader in = new BufferedReader(new FileReader
                ("C:\\Users\\user\\IdeaProjects\\KumpulanTugas_Week1_Bootcamp\\src\\main\\java\\ThreadPoolThread\\file.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                ar = str.split(",");
                for (int i = 0; i < 10; i++) {
                    Arrays.sort(ar, Collections.reverseOrder());
                    fileDsc();
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    public void fileDsc() {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\user\\IdeaProjects\\KumpulanTugas_Week1_Bootcamp\\src\\main\\java\\ThreadPoolThread\\fileDSC.txt"); //test2 is a new file made here
            fw.write("Data Hasil Descending\n");
            for (int i = 0; i < 10; i++) {
                fw.write(ar[i] + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class MainThread {

    static Scanner sc = new Scanner(System.in);

    static void menuUtama() throws Exception {
        boolean pilihan = true;
        while (pilihan) {
            System.out.println("========================================");
            System.out.println("------------------MENU------------------");
            System.out.println("========================================");
            System.out.println("1. Simple Thread");
            System.out.println("2. Pool Thread");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan : ");
            int pil = 0;
            try {
                pil = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Masukkan Angka (1) sampai (5)!");
            }
            sc.nextLine();
            switch (pil) {
                case 1:
                    java.lang.Thread simpleThread = new java.lang.Thread();
                    simpleThread.start();
                    simpleThread.join();
                    break;
                case 2:
                    ExecutorService executor = Executors.newFixedThreadPool(2);
                    for (int i = 0; i < 4; i++) {
                        java.lang.Thread pool = new java.lang.Thread();
                        executor.execute(pool);
                    }
                    executor.shutdown();
                    while (!executor.isTerminated()) {
                    }
                    System.out.println("Finished all threads");
                    break;
                case 3:
                    java.lang.Thread simpleThread2 = new java.lang.Thread();
                    simpleThread2.start();
                    simpleThread2.join();
                    KelasAsc printAsc = new KelasAsc();
                    printAsc.start();
                    printAsc.join();
                    KelasDsc printDsc = new KelasDsc();
                    printDsc.start();
                    printDsc.join();
                    break;
                case 4:
                    System.out.println("================================================================");
                    System.out.println("----------------------Program Selesai---------------------------");
                    System.out.println("================================================================");
                    pilihan = false;
                    break;
                default:
                    System.out.println("Pilihan Anda Tidak Tersedia");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        menuUtama();
    }
}
