package Day5Ujian;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Staff> dataStf = new ArrayList<>();
    static String email = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    static String password = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
    static final String fileUser = "C:\\Users\\user\\IdeaProjects\\2021.01.15_Ujian_Week1_Alif Yudha S\\src\\main\\java\\com\\ujian\\user.properties";
    static final String fileData = "C:\\Users\\user\\IdeaProjects\\2021.01.15_Ujian_Week1_Alif Yudha S\\src\\main\\java\\com\\ujian\\fileKaryawan.txt";
    static ArrayList<String> allArr = new ArrayList<>();

    public static void main(String[] args) {
//        login();
        //input data awal dari file text
        try {
            ReadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu();
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(fileUser));
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");

            System.out.println("Username : " + user);
            System.out.println("Password : " + pass);
            System.out.println("Di atas adalah contekan user dan password");
            boolean aktif = true;
            do {
                System.out.println("Silahkan Login !");
                System.out.println("=====================");

                System.out.print("Username : ");
                String us = sc.nextLine();

                System.out.print("Password : ");
                String pas = sc.nextLine();

                /* Pattern username sesuai dengan email. */
                Pattern p = Pattern.compile(email);
                Matcher m = p.matcher(us);

                /* Password dengan karakteristik lebih dari 8 character, ada huruf besar dan kecil, memiliki special character */
                Pattern pp = Pattern.compile(password);
                Matcher mp = pp.matcher(pas);

                //Matcher mp1 = pas;
                if (!m.matches()) {
                    System.out.println("Username Tidak Sesuai !");
                } else if (!mp.matches()) {
                    System.out.println("Password Tidak Sesuai !");
                } else if ((m.matches()) && (mp.matches())) {
                    if (user.equals(us) && pass.equals(pas)) {
                        System.out.println("---Berhasil Login---");
                        //input data awal dari file text
                        try {
                            ReadFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        menu();
                        aktif = false;
                    } else {
                        System.out.println("Username Dan Password Salah !");
                    }
                }

                System.out.println();
            } while (aktif);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void menu() {
        boolean active = true;

        do {
            System.out.println("===============================================");
            System.out.println("===================MENU-MENU===================");
            System.out.println("===============================================");
            System.out.println("1. Input Data Karyawan\n2. Edit Data Nama Karyawan\n3. Absensi Karyawan\n4. Izin Karyawan\n" +
                    "5. Hitung Total Gaji\n6. Tampilkan Laporan(per Karyawan)\n7. Laporan & Cetak Laporan\n8. Exit");
            System.out.println("===============================================");
            System.out.print("Pilih Menu : ");
            int choose = 0;
            try {
                choose = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Masukkan Angka");
            }
            switch (choose) {
                case 1: {
                    InputData();
                    break;
                }
                case 2: {
                    EditNama();
                    break;
                }
                case 3: {
                    AbsensiKar();
                    break;
                }
                case 4: {
                    IzinKar();
                    break;
                }
                case 5: {
                    HitungTotGaji();
                    break;
                }
                case 6: {
                    CetakData();
                    PrinttoFile();
                    break;
                }
                case 7: {
                    CetakData();
                    break;
                }
                case 8: {
                    active = false;
                    break;
                }
                case 9: {
//                    ReadFile();
                    break;
                }
                default: {
                    active = false;
                }
            }
        } while (active);
    }

    public static void ReadFile() throws IOException {

        int numLines = 1;
        BufferedReader br = new BufferedReader(new FileReader(fileData));
        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            String[] arr = currentLine.split(",");
            for (int i = 0; i < arr.length; i++) {
                allArr.add(arr[i]);
            }
            numLines++;
        }
        br.close();

        allArr.remove("ID");
        allArr.remove("Nama");
        allArr.remove("GajiPokok");

        int idParse = 0;
        String nama = "";
        double hargaParse = 0.0;
        int b = 0;
        int c = 3;

        for (int a = 1; a < (numLines - 1); a++) {
            for (int i = b; i < c; i++) {
                if (i == b) {
                    idParse = Integer.parseInt(allArr.get(i));
                } else if (i == (b + 1)) {
                    nama = allArr.get(i);
                } else if (i == (b + 2)) {
                    hargaParse = Double.parseDouble(allArr.get(i));
                }
            }
            dataStf.add(new Staff(idParse, nama, hargaParse, 0, 0, 0, 0.0, 0.0, 0.0));
            b += 3;
            c += 3;
        }
    }

    public static int CariData(int findId) {
        int index = -1;
        int i = 0;
        for (Staff stf : dataStf) {
            if (stf.getIdKaryawan() == findId) {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }

    public static void InputData() {
        System.out.print("Masukkan Jumlah Data : ");
        int amount = sc.nextInt();

        for (int i = 0; i < amount; i++) {
            System.out.println("-----------------------------------------------");
            System.out.println("Data Staff ke-" + (i + 1));
            System.out.println("-----------------------------------------------");

            int id = 0;
            boolean active = true;
            int loop = 0;
            do {
                System.out.print("Masukkan id : ");
                id = sc.nextInt();
                int idCompare = CariData(id);
                if (idCompare >= 0) {
                    System.out.println("ID Data sudah digunakan");
                    System.out.println("-----------------------");
                    System.out.println("ID\tNama");
                    System.out.println("-----------------------");
                    System.out.println(dataStf.get(idCompare).getIdKaryawan() + "\t" +
                            dataStf.get(idCompare).getNamaKaryawan());
                    System.out.println("-----------------------");
                    loop++;
                    if (loop == 3) {
                        System.out.println("Kembali ke menu....");
                        menu();
                    }
                } else {
                    System.out.println("ID bisa digunakan");
                    active = false;
                }
            } while (active);

            System.out.print("Masukkan nama (no spasi, jika ada -> Gunakan (-)) : ");
            String nama = sc.next();
            System.out.print("Masukkan gaji pokok : ");
            double gaji = sc.nextDouble();

            dataStf.add(new Staff(id, nama, gaji, 0, 0, 0, 0.0, 0.0, 0.0));
        }
    }

    public static void AbsensiKar() {
        System.out.println("===============================================");
        System.out.println("Input Data Untuk Absen ");
        System.out.println("-----------------------------------------------");
        int indexResult = -1;
        int maxAbsen = -1;

        boolean active = true;
        do {
            try {
                CetakData();
                System.out.print("Masukkan ID anda : ");
                int findId = sc.nextInt();
                indexResult = CariData(findId);
                maxAbsen = dataStf.get(indexResult).getMaxAbsen();
                dataStf.get(indexResult).setMaxAbsen(maxAbsen - 1);
                active = false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ID tidak ditemukan, silahkan coba lagi!");
                System.out.println("---------------------------------------");
            }
            sc.nextLine();
        } while (active);

        System.out.println(maxAbsen);
        if (maxAbsen > 0) {
            if (dataStf.size() > 0) {
                dataStf.get(indexResult).absensi();
                dataStf.get(indexResult).setTjMakan();
                dataStf.get(indexResult).setTjTrans();
//                double gaji = dataStf.get(indexResult).getGaji();
//                dataStf.get(indexResult).setGaji((gaji/22)*dataStf.get(indexResult).getAbsensi());
//                dataStf.get(indexResult).hitungGajiPokok();
                System.out.println("Absen Berhasil, Terimakasih...");
            }
            System.out.println("-----------------------------------------------");
        } else {
            System.out.println("Maaf Anda Tidak Bisa Absen, Ini hari sabtu dan minggu");
        }
    }

    public static void IzinKar() {
        System.out.println("===============================================");
        System.out.println("MENU ADMINISTRASI UNTUK IZIN URGENT & IZIN CUTI");
        System.out.println("===============================================");
        System.out.print("Masukkan ID anda : ");
        int findId = sc.nextInt();
        int indexRslt = CariData(findId);
        int max;

        if (indexRslt >= 0) {
            System.out.println("Data Ditemukan");
            System.out.println("1. Izin Cuti\n2. Izin Mendesak");
            System.out.print("Pilih : ");
            int pilih = sc.nextInt();
            if (pilih == 1) {
                System.out.println("masuk ke cuti");
                System.out.print("Masukkan jumlah cuti : ");
                int jmlhCuti = sc.nextInt();
                dataStf.get(indexRslt).setJmlCuti(jmlhCuti);
                max = dataStf.get(indexRslt).getMaxAbsen();
                dataStf.get(indexRslt).setMaxAbsen(max - jmlhCuti);
            } else if (pilih == 2) {
                System.out.println("Masuk menu Izin Urgent");
                System.out.print("Masukkan jumlah izin urgent (day) : ");
                int banyakCutiUrgent = sc.nextInt();
                dataStf.get(indexRslt).setJmlIzin(banyakCutiUrgent);
                max = dataStf.get(indexRslt).getMaxAbsen();
                dataStf.get(indexRslt).setMaxAbsen(max - banyakCutiUrgent);
            } else {
                System.out.println("Masukkan 1 atau 2");
            }
        }
    }

    public static void HitungTotGaji() {
        System.out.println("===============================================");
        System.out.println("Hitung Gaji Total Anda !");
        System.out.println("-----------------------------------------------");
        System.out.print("Masukkan ID anda : ");
        int findId = sc.nextInt();
        int indexResult = CariData(findId);

//        System.out.print("Gaji Pokok 1 Bulan : "+dataStf.get(indexResult).getGaji());
//        System.out.println();
//        System.out.print("Tunjangan Makan Anda 1 Bulan : "+dataStf.get(indexResult).getTjMakan());
//        System.out.println();
//        System.out.println("Tunjangan Transport Anda 1 Bulan : "+dataStf.get(indexResult).getTjTrans());
//        System.out.println();
//        System.out.println("----------------------------------------------- +");
//        double total = dataStf.get(indexResult).getGaji()+dataStf.get(indexResult).getTjMakan()+
//                dataStf.get(indexResult).getTjTrans();
//        System.out.print("total Gaji : "+total);

    }

    public static void CetakData() {
        System.out.println("===============================================");
        System.out.println("Cetak Data ke Monitor");
        System.out.println("-----------------------------------------------");
        System.out.println("No.\tID\tNama\tGaji_Pokok\thadir\tCuti\tIzin\tTunj_Makan\tTunj_Trans\tTotal_Gaji");
        for (int i = 0; i < dataStf.size(); i++) {
            double total = dataStf.get(i).getGaji() + dataStf.get(i).getTjMakan() + dataStf.get(i).getTjTrans();
//            dataStf.get(i).setTotGaji(total);

            System.out.println((i + 1) + "\t" + dataStf.get(i).getIdKaryawan() + "\t" + dataStf.get(i).getNamaKaryawan() + "\t" +
                    dataStf.get(i).getGaji() + "\t" + dataStf.get(i).getAbsensi() + "\t" + dataStf.get(i).getJmlCuti() + "\t" +
                    dataStf.get(i).getJmlIzin() + "\t" + dataStf.get(i).getTjMakan() + "\t" + dataStf.get(i).getTjTrans() + "\t" +
                    total);
        }
        System.out.println("-----------------------------------------------");
        System.out.println("*Disclaimer");
        System.out.println("Jika Gaji pokok tidak sesuai, itu karena hasil perhitungan matematis dengan faktor kehadiran anda");
    }

    public static void PrinttoFile() {
    }

    public static void EditNama() {
        System.out.println("===============================================");
        System.out.println("MENU EDIT NAMA KARYAWAN");
        System.out.println("===============================================");
        System.out.print("Masukkan ID anda : ");
        int findId = sc.nextInt();
        int indexRslt = CariData(findId);

        if (indexRslt >= 0) {
            System.out.println("Data Ditemukan");
            System.out.println("==============================");
            System.out.print("Input Data Nama Baru : ");
            String nama = sc.next();
            dataStf.get(indexRslt).setNamaKaryawan(nama);
            System.out.println("Success sunting nama....");
        } else {
            System.out.println("Data Tidak Ditemukan");
        }

    }
}
