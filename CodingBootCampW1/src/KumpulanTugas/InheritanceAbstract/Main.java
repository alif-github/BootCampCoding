package KumpulanTugas.InheritanceAbstract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static InputStreamReader r = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(r);
    static ArrayList<Staff> dataStaff = new ArrayList<>();
    static ArrayList<Manager> dataManager = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        boolean active = true;

        do {
            System.out.println("===============================================");
            System.out.println("===================MENU-MENU===================");
            System.out.println("===============================================");
            System.out.println("1. Input Data Karyawan\n2. Absensi Karyawan\n3. Hitung Tunjangan\n4. Hitung Total Gaji\n" +
                    "5. Laporan Gaji");
            System.out.println("===============================================");
            System.out.print("Pilih Menu : ");
            int choose = Integer.parseInt(br.readLine());
            switch (choose) {
                case 1: {
                    InputData();
                    break;
                }
                case 2: {
                    AbsensiData();
                    break;
                }
                case 3: {
                    HitungTunjangan();
                    break;
                }
                case 4: {
                    HitungTotal();
                }
                case 5: {
                    LaporanData();
                    break;
                }
                default: {
                    active = false;
                }
            }
        } while (active);
    }

    public static void InputData() throws IOException {
        boolean active = true;

        do {
            System.out.println("===============================================");
            System.out.println("Input Data sebagai (Jabatan) ");
            System.out.println("1. Manager\n2. Staff");
            System.out.println("-----------------------------------------------");
            System.out.print("Pilih : ");
            int choose = Integer.parseInt((br.readLine()));
            if (choose == 1) {
                InputManager();
                active = false;
            } else if (choose == 2) {
                InputStaff();
                active = false;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        } while (active);
        System.out.println("-----------------------------------------------");
    }

    public static void InputStaff() throws IOException {
        System.out.print("Masukkan Jumlah Data : ");
        int amount = Integer.parseInt((br.readLine()));

        for (int i = 0; i < amount; i++) {
            System.out.println("-----------------------------------------------");
            System.out.println("Data Staff ke-" + (i + 1));
            System.out.println("-----------------------------------------------");
            System.out.print("Masukkan id : ");
            int idInput = Integer.parseInt(br.readLine());
            System.out.print("Masukkan nama : ");
            String namaInput = br.readLine();
            System.out.print("Masukkan tunjangan pulsa : ");
            double tpulsaInput = Double.parseDouble(br.readLine());
            System.out.print("Masukkan gaji : ");
            double gajiInput = Double.parseDouble(br.readLine());

            dataStaff.add(new Staff(idInput, namaInput, tpulsaInput, gajiInput, 0, 0));
        }
    }

    public static void InputManager() throws IOException {
        System.out.print("Masukkan Jumlah Data : ");
        int amount = Integer.parseInt((br.readLine()));

        for (int i = 0; i < amount; i++) {
            System.out.println("-----------------------------------------------");
            System.out.println("Data Staff ke-" + (i + 1));
            System.out.println("-----------------------------------------------");
            System.out.print("Masukkan id : ");
            int idInput = Integer.parseInt(br.readLine());
            System.out.print("Masukkan nama : ");
            String namaInput = br.readLine();
            System.out.print("Masukkan tunjangan pulsa : ");
            double tpulsaInput = Double.parseDouble(br.readLine());
            System.out.print("Masukkan gaji : ");
            double gajiInput = Double.parseDouble(br.readLine());
            System.out.print("Masukkan tunjangan entertainment : ");
            double tentertaint = Double.parseDouble(br.readLine());

            dataManager.add(new Manager(idInput, namaInput, tpulsaInput, gajiInput, 0, 0.0, tentertaint));
        }
    }

    public static void AbsensiData() throws IOException {
        boolean active = true;

        do {
            System.out.println("===============================================");
            System.out.println("Input Data Untuk Absen ");
            System.out.println("1. Manager\n2. Staff");
            System.out.println("-----------------------------------------------");
            System.out.print("Pilih : ");
            int choose = Integer.parseInt((br.readLine()));
            if (choose == 1) {
                AbsenManager();
                active = false;
            } else if (choose == 2) {
                AbsenStaff();
                active = false;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        } while (active);
        System.out.println("-----------------------------------------------");
    }

    public static void AbsenStaff() throws IOException {
        System.out.print("Cari Berdasarkan ID : ");
        int id = Integer.parseInt(br.readLine());

        if (dataStaff.size() > 0) {
            for (int i = 0; i < dataStaff.size(); i++) {
                if (dataStaff.get(i).getIdKaryawan() == id) {
                    dataStaff.get(i).absensi();
                    dataStaff.get(i).setTunjMakan();
                    System.out.println("Absen Success....");
                    break;
                }
            }
        }
    }

    public static void AbsenManager() throws IOException {
        System.out.print("Cari Berdasarkan ID : ");
        int id = Integer.parseInt(br.readLine());

        if (dataManager.size() > 0) {
            for (int i = 0; i < dataManager.size(); i++) {
                if (dataManager.get(i).getIdKaryawan() == id) {
                    dataManager.get(i).absensi();
                    dataManager.get(i).setTunjTransport();
                    System.out.println("Absen Success....");
                    break;
                }
            }
        }
    }

    public static void LaporanData() {
        System.out.println("======================================================");
        System.out.println("Tabel Data untuk Staff");
        System.out.println("======================================================");
        System.out.println("ID\tNama\tAbsen\tTunj_Pulsa\tTunj_Makan\tGaji_Pokok");
        System.out.println("======================================================");
        for (int i = 0; i < dataStaff.size(); i++) {
            System.out.println(dataStaff.get(i).getIdKaryawan() + "\t" + dataStaff.get(i).getNama() + "\t" +
                    dataStaff.get(i).getAbsen() + "\t" + dataStaff.get(i).getTunjPulsa() + "\t" +
                    dataStaff.get(i).getTunjMakan() + "\t" + dataStaff.get(i).getGajiPokok());
        }
        System.out.println("======================================================");

        System.out.println();
        System.out.println();

        System.out.println("======================================================");
        System.out.println("Tabel Data untuk Manager");
        System.out.println("======================================================");
        System.out.println("ID\tNama\tAbsen\tTunj_Pulsa\tTunj_Trans\tTunj_Entertaint\tGaji_Pokok");
        System.out.println("======================================================");
        for (int i = 0; i < dataManager.size(); i++) {
            double total = dataManager.get(i).getTunjEntertaint() * 500000;
            System.out.println(dataManager.get(i).getIdKaryawan() + "\t" + dataManager.get(i).getNama() + "\t" +
                    dataManager.get(i).getAbsen() + "\t" + dataManager.get(i).getTunjPulsa() + "\t" +
                    dataManager.get(i).getTunjTransport() + "\t" + total + "\t" +
                    dataManager.get(i).getGajiPokok());
        }
        System.out.println("======================================================");
    }

    public static void HitungTunjangan() throws IOException {
        boolean active = true;

        do {
            System.out.println("===============================================");
            System.out.println("Input Data Untuk Hitung Tunjangan");
            System.out.println("1. Manager\n2. Staff");
            System.out.println("-----------------------------------------------");
            System.out.print("Pilih : ");
            int choose = Integer.parseInt((br.readLine()));
            if (choose == 1) {
                TunjanganMg();
                active = false;
            } else if (choose == 2) {
                TunjanganSt();
                active = false;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        } while (active);
        System.out.println("-----------------------------------------------");
    }

    public static void TunjanganMg() throws IOException {
        System.out.print("Cari Berdasarkan ID : ");
        int id = Integer.parseInt(br.readLine());

        if (dataManager.size() > 0) {
            for (int i = 0; i < dataManager.size(); i++) {
                if (dataManager.get(i).getIdKaryawan() == id) {
                    double totTunjangan = dataManager.get(i).getTunjEntertaint() + dataManager.get(i).getTunjPulsa() + dataManager.get(i).getTunjTransport();
                    System.out.println("-----------------------------------------------");
                    System.out.println("Detail Tunjangan yang di dapat : ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("Tunjangan Entertaint : " + dataManager.get(i).getTunjEntertaint());
                    System.out.println("Tunjangan Pulsa : " + dataManager.get(i).getTunjPulsa());
                    System.out.println("Tunjangan Transport : " + dataManager.get(i).getTunjTransport());
                    System.out.println("-----------------------------------------------  + ");
                    System.out.println("Total : " + totTunjangan);
                    break;
                }
            }
        }
    }

    public static void TunjanganSt() throws IOException {
        System.out.print("Cari Berdasarkan ID : ");
        int id = Integer.parseInt(br.readLine());

        if (dataStaff.size() > 0) {
            for (int i = 0; i < dataStaff.size(); i++) {
                if (dataStaff.get(i).getIdKaryawan() == id) {
                    double totTunjangan = dataStaff.get(i).getTunjPulsa() + dataStaff.get(i).getTunjMakan();
                    System.out.println("-----------------------------------------------");
                    System.out.println("Detail Tunjangan yang di dapat : ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("Tunjangan Makan : " + dataStaff.get(i).getTunjMakan());
                    System.out.println("Tunjangan Pulsa : " + dataStaff.get(i).getTunjPulsa());
                    System.out.println("-----------------------------------------------  + ");
                    System.out.println("Total : " + totTunjangan);
                    break;
                }
            }
        }
    }

    public static void HitungTotal() throws IOException {
        boolean active = true;

        do {
            System.out.println("===============================================");
            System.out.println("Input Data Untuk Hitung Total (Gaji + Tunjangan)");
            System.out.println("1. Manager\n2. Staff");
            System.out.println("-----------------------------------------------");
            System.out.print("Pilih : ");
            int choose = Integer.parseInt((br.readLine()));
            if (choose == 1) {
                HitungTotalMg();
                active = false;
            } else if (choose == 2) {
                HitungTotalSt();
                active = false;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        } while (active);
        System.out.println("-----------------------------------------------");
    }

    public static void HitungTotalMg() throws IOException {
        System.out.print("Cari Berdasarkan ID : ");
        int id = Integer.parseInt(br.readLine());

        if (dataManager.size() > 0) {
            for (int i = 0; i < dataManager.size(); i++) {
                if (dataManager.get(i).getIdKaryawan() == id) {
                    double totTunjangan = dataManager.get(i).getTunjEntertaint() + dataManager.get(i).getTunjPulsa() + dataManager.get(i).getTunjTransport();
                    double gaji = dataManager.get(i).getGajiPokok();
                    double total = gaji + totTunjangan;
                    System.out.println("-----------------------------------------------");
                    System.out.println("Detail Gaji yang di dapat : ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("Tunjangan Entertaint : " + dataManager.get(i).getTunjEntertaint());
                    System.out.println("Tunjangan Pulsa : " + dataManager.get(i).getTunjPulsa());
                    System.out.println("Tunjangan Transport : " + dataManager.get(i).getTunjTransport());
                    System.out.println("Gaji Pokok : " + dataManager.get(i).getGajiPokok());
                    System.out.println("-----------------------------------------------  + ");
                    System.out.println("Total : " + total);
                    break;
                }
            }
        }
    }

    public static void HitungTotalSt() throws IOException{
        System.out.print("Cari Berdasarkan ID : ");
        int id = Integer.parseInt(br.readLine());

        if (dataStaff.size() > 0) {
            for (int i = 0; i < dataStaff.size(); i++) {
                if (dataStaff.get(i).getIdKaryawan() == id) {
                    double totTunjangan = dataStaff.get(i).getTunjPulsa() + dataStaff.get(i).getTunjMakan();
                    double gaji = dataStaff.get(i).getGajiPokok();
                    double total = gaji + totTunjangan;
                    System.out.println("-----------------------------------------------");
                    System.out.println("Detail Gaji yang di dapat : ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("Tunjangan Makan : " + dataStaff.get(i).getTunjMakan());
                    System.out.println("Tunjangan Pulsa : " + dataStaff.get(i).getTunjPulsa());
                    System.out.println("Gaji Pokok : " + dataStaff.get(i).getGajiPokok());
                    System.out.println("-----------------------------------------------  + ");
                    System.out.println("Total : " + total);
                    break;
                }
            }
        }
    }
}
