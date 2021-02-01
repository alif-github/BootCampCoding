package KumpulanTugas.InheritanceAbstract;

public abstract class Worker {
    private int idKaryawan;
    private String nama;
    private double tunjPulsa;
    private double gajiPokok;
    private int absen;
    abstract void absensi();

    public Worker(int idKaryawan, String nama, double tunjPulsa, double gajiPokok, int absen) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.tunjPulsa = tunjPulsa;
        this.gajiPokok = gajiPokok;
        this.absen = absen;
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

    public double getTunjPulsa() {
        return tunjPulsa;
    }

    public void setTunjPulsa(double tunjPulsa) {
        this.tunjPulsa = tunjPulsa;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public int getAbsen() {
        return absen;
    }

    public void setAbsen(int absen) {
        this.absen = absen;
    }
}
