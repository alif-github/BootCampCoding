package Day5Ujian;

public abstract class Worker {
    private int idKaryawan;
    private String namaKaryawan;
    private double gaji;
    private int Absensi;
    private int jmlCuti = 0;
    private int jmlIzin = 0;

    abstract void absensi();
    abstract void hitungGajiPokok();

    public Worker(int idKaryawan, String namaKaryawan, double gaji, int absensi, int jmlCuti, int jmlIzin) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.gaji = gaji;
        Absensi = absensi;
        this.jmlCuti = jmlCuti;
        this.jmlIzin = jmlIzin;
    }

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public Double getGaji() {
        return gaji;
    }

    public void setGaji(Double gaji) {
        this.gaji = gaji;
    }

    public int getAbsensi() {
        return Absensi;
    }

    public void setAbsensi(int absensi) {
        Absensi = absensi;
    }

    public int getJmlCuti() {
        return jmlCuti;
    }

    public void setJmlCuti(int jmlCuti) {
        this.jmlCuti = jmlCuti;
    }

    public int getJmlIzin() {
        return jmlIzin;
    }

    public void setJmlIzin(int jmlIzin) {
        this.jmlIzin = jmlIzin;
    }
}
