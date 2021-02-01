package Day4.TugasSiang;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadx {

    static prosesThread thr = new prosesThread();

    public static void main(String[] args) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        boolean active = true;

        do {
            System.out.println("========================================");
            System.out.println("------------------MENU------------------");
            System.out.println("========================================");
            System.out.println("1. Buat Simple Thread tampil 10 data");
            System.out.println("2. Buat Thread Pool 10 data");
            System.out.println("3. Cetak Hasil Thread");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan : ");
            int pil = userInput.nextInt();

            switch (pil) {
                case 1: {
                    thr.simpleTh();
                    break;
                }
                case 2: {
                    ExecutorService executor = Executors.newFixedThreadPool(5);
                    for (int i = 0; i < 2; i++){
                        Runnable pool = new ThreadPool();
                        executor.execute(pool);
                    }
                    executor.shutdown();
                    while (!executor.isTerminated()) {
                    }
                    System.out.println("Semua Selesai");
                    break;
                }
                case 3: {
                    boolean loop = true;
                    do {
                        System.out.println("Pilih : \n1. Ascending\n2. Descending");
                        System.out.print("Pilihan : ");
                        try {
                            int choose = userInput.nextInt();
                            if (choose == 1) {
                                thr.rdWriteASc();
                                loop = false;
                            } else if (choose == 2) {
                                thr.rdWriteDSc();
                                loop = false;
                            } else {
                                System.out.println("Masukkan 1 atau 2");
                            }
                        } catch (Exception e) {
                            System.out.println("Salah Input! harus angka");
                        }
                        userInput.nextLine();
                    } while (loop);
                    break;
                }
                case 4: {
                    active = false;
                    break;
                }
                default: {
                    System.out.println("Wrong");
                }
            }
        } while (active);
    }
}

////
////        td.GenerateNumber();
////        try {
////            td.toFile();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        td.FiletoDesc();
////        //td.FiletoAsc();
////        td.StringtoInt();
////
//
//    }
//
//    void GenerateNumber() {
//        int a = 1001;
//        for (int i = 0; i < 100; i++) {
//            if (i < 99) {
//                str = str + String.valueOf(a) + ",";
//            } else if (i == 99) {
//                str = str + String.valueOf(a);
//            }
//            a++;
//        }
//        System.out.println(str);
//    }
//
//    void toFile() throws IOException {
//        FileWriter fr = new FileWriter("C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\ResourceTxt\\angka.properties");
//        BufferedWriter br = new BufferedWriter(fr);
//        br.write(str);
//        br.close();
//    }
//
//    void FiletoDesc() {
//        try {
//            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\ResourceTxt\\angka.properties"));
//            String st;
//            while ((st = in.readLine()) != null) {
//                ar = st.split(",");
//                Arrays.sort(ar,Collections.reverseOrder());
//            }
//        } catch (IOException e) {
//            System.out.println("File Read Error");
//        }
//        System.out.println("File to console Success...");
//    }
//
//    void FiletoAsc(){
//        try {
//            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\ResourceTxt\\angka.properties"));
//            String st;
//            while ((st = in.readLine()) != null) {
//                ar = st.split(",");
//                Arrays.sort(ar);
//            }
//        } catch (IOException e) {
//            System.out.println("File Read Error");
//        }
//        System.out.println("File to console Success...");
//    }
//
//    void StringtoInt() {
//        result = new int[ar.length];
//        int temp;
//        //Arrays.sort(result);
//
//        for (int i = 0; i < ar.length; i++) {
//            try {
//                result[i] = Integer.parseInt(ar[i]);
//            } catch (NumberFormatException n) {
//                n.printStackTrace();
//            }
//        }
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//        System.out.println("String to Int Array Success...");
//    }
