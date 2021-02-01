package KumpulanTugas.InheritanceAbsen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Staff> dataStaff = new ArrayList<Staff>();
        boolean ulang = true;

        do {
            System.out.println("MENU");
            System.out.println("1. Input Data Staff");
            System.out.println("2. Absensi");
            System.out.println("3. Tampilkan Laporan Staff");
            System.out.print("Pilih : ");
            int pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Masukan Jumlah Karyawan : ");
                    int jumlah = sc.nextInt();
                    for (int i = 0; i < jumlah; i++) {
                        System.out.println("Masukkan data Karyawan");
                        System.out.print("ID karyawan : ");
                        int id = sc.nextInt();
                        System.out.print("Nama        : ");
                        String nama = sc.next();
                        System.out.print("Jabatan     : ");
                        String jabatan = sc.next();
                        dataStaff.add(new Staff(id, nama,0, jabatan));
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.print("Masukkan ID Karyawan :");
                    int idk = sc.nextInt();
                    for (Staff staff : dataStaff ) {
                        if (staff.getIdKaryawan() == idk) {
                            staff.tambahAbsen();
                            break;
                        } else {
                            System.out.println("Data Karyawan Tidak Ditemukan");
                        }
                    }
                    break;

                case 3:
                    for (int i = 0; i < dataStaff.size(); i++) {
                        for (int j = 0; j < dataStaff.size() - 1; j++) {
                            Staff temp = dataStaff.get(j);
                            if (dataStaff.get(j + 1).getIdKaryawan() < dataStaff.get(j).getIdKaryawan()) {
                                dataStaff.set(j, dataStaff.get(j + 1));
                                dataStaff.set(j + 1, temp);
                            }
                        }
                    }
                    System.out.println("=======================================");
                    System.out.println("ID\t\tNama\t\tJabatan\t\t\tAbsensi");
                    System.out.println("=======================================");
                    for (Staff staff : dataStaff){
                        System.out.println(staff.getIdKaryawan()+"\t\t"+staff.getNama()+"\t\t"+staff.getJabatan()+"\t\t\t"+staff.absensi);
                    }
                    System.out.println("=======================================");
                    break;
                default:
                    ulang = false;
                    break;
            }
        }while (ulang) ;
    }
}

