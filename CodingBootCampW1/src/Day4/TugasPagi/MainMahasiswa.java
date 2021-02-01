package Day4.TugasPagi;

import java.io.*;
import java.util.*;

public class MainMahasiswa {
    static ArrayList<Mahasiswa> data = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);
    Thread thread;

    public static void main(String[] args) {
        MainMahasiswa main = new MainMahasiswa();


        boolean active = true;
        do {
            System.out.println("========================");
            System.out.println("..........MENU..........");
            System.out.println("========================");
            System.out.println("1. Create/Input data\n2. Tampilkan Laporan\n3. Tampilkan di layar & Tulis ke File\n4. Exit");
            System.out.print("pilih : ");
            int pilih = userInput.nextInt();
            switch (pilih) {
                case 1: {
                    InputData();
                    break;
                }
                case 2: {
                    Show();
                    break;
                }
                case 3: {
                    try {
                        main.TampilCetak();
                        main.CetakFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("");
                    active = false;
                }
            }
        } while (active);
    }

    public static void InputData() {
        int id;
        String nama;
        double bing, fis, algo;
        boolean active = true;

        System.out.print("Banyak data yang akan di input : ");
        int lot = userInput.nextInt();
        for (int i = 0; i < lot; i++) {

            do {
                try {
                    Mahasiswa mhs = new Mahasiswa();
                    System.out.println("Data anak ke-" + (i + 1));
                    System.out.println("========================");
                    System.out.print("Masukkan id Mahasiswa : ");
                    id = userInput.nextInt();
                    System.out.print("Masukkan nama Mahasiswa : ");
                    nama = userInput.next();
                    System.out.print("Masukkan nilai b. Inggris : ");
                    bing = userInput.nextDouble();
                    System.out.print("Masukkan nilai fisika : ");
                    fis = userInput.nextDouble();
                    System.out.print("Masukkan nilai algo : ");
                    algo = userInput.nextDouble();
                    mhs.setIdMahasiswa(id);
                    mhs.setNamaMahasiswa(nama);
                    mhs.setbIng(bing);
                    mhs.setFis(fis);
                    mhs.setAlgo(algo);

                    data.add(mhs);
                    active = false;
                } catch (Exception e) {
                    System.out.println("Data yang anda masukkan tidak sesuai!");
                }
                userInput.nextLine();
            } while (active);
        }
    }

    public static void Show() {
        Collections.sort(data,new Sorting());
        System.out.println("========================");
        System.out.println("..........CETAK.........");
        System.out.println("========================");
        System.out.println("No.\tID\tNamaMhs\tBing\tFis\tAlgo");
        for (int i = 0; i < data.size(); i++) {
            System.out.println((i + 1) + "\t" + data.get(i).getIdMahasiswa() + "\t" + data.get(i).getNamaMahasiswa() +
                    "\t" + data.get(i).getbIng() + "\t" + data.get(i).getFis() + "\t" + data.get(i).getAlgo());
        }
    }

    void TampilCetak() throws InterruptedException{
        thread = new Thread(() -> {
            System.out.println(System.currentTimeMillis());
            try {
                System.out.println("========================");
                System.out.println("..........CETAK.........");
                System.out.println("========================");
                System.out.println("No.\tID\tNamaMhs\tBing\tFis\tAlgo");
                for (int i = 0; i < data.size(); i++) {
                    System.out.println((i + 1) + "\t" + data.get(i).getIdMahasiswa() + "\t" + data.get(i).getNamaMahasiswa() +
                            "\t" + data.get(i).getbIng() + "\t" + data.get(i).getFis() + "\t" + data.get(i).getAlgo());
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        thread.start();
        thread.join();

    }

    void CetakFile() throws IOException, InterruptedException {
        thread = new Thread(() -> {
            System.out.println(System.currentTimeMillis());
            try {
                FileWriter w = new FileWriter("C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\Resource\\userdata.properties");
                BufferedWriter b = new BufferedWriter(w);
                b.write("No.\tID\tNamaMhs\tBing\tFis\tAlgo\n");
                for (int i = 0; i < data.size(); i++) {
                    b.write((i + 1) + "\t" + data.get(i).getIdMahasiswa() + "\t" + data.get(i).getNamaMahasiswa() +
                            "\t" + data.get(i).getbIng() + "\t" + data.get(i).getFis() + "\t" + data.get(i).getAlgo() + "\n");
                }
                b.close();
                System.out.println("Success....");
                Thread.sleep(1000);
            } catch (InterruptedException | IOException ex) {
                ex.printStackTrace();
            }
        });

        thread.start();
        thread.join();
    }

    public static void AmbilFile() throws IOException {
        FileReader r = new FileReader("C:\\Users\\user\\IdeaProjects\\2021.01.14_Day4_Alif Yudha S\\src\\main\\java\\Resource\\userdata.properties");
        BufferedReader br = new BufferedReader(r);

        int i;
        while ((i = br.read()) != -1) {
            System.out.print((char) i);
        }
        br.close();
        r.close();
    }
}

class Sorting implements Comparator<Mahasiswa>{

    @Override
    public int compare(Mahasiswa o1, Mahasiswa o2) {
        return o1.getIdMahasiswa() - o2.getIdMahasiswa();
    }
}
