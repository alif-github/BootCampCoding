package KumpulanTugas.InheritanceAbsen;

public abstract class Worker {
    private int idKaryawan;
    private String nama;
    public int absensi;

    public Worker(int idKaryawan, String nama, int absensi) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
    }

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
