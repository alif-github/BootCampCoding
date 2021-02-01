package Day5Ujian;

public class Staff extends Worker {
    private double tjMakan;
    private double tjTrans;
    private double totGaji;
    private int maxAbsen = 22;

    public Staff(int idKaryawan, String namaKaryawan, double gaji, int absensi, int jmlCuti, int jmlIzin, double tjMakan, double tjTrans, double totGaji) {
        super(idKaryawan, namaKaryawan, gaji, absensi, jmlCuti, jmlIzin);
        this.tjMakan = tjMakan;
        this.tjTrans = tjTrans;
        this.totGaji = totGaji;
    }

    public int getMaxAbsen() {
        return maxAbsen;
    }

    public void setMaxAbsen(int maxAbsen) {
        this.maxAbsen = maxAbsen;
    }

    public double getTjMakan() {
        return tjMakan;
    }

    public void setTjMakan() {

        this.tjMakan = 220000.0 - ((220000.0 / 22) * (maxAbsen - getAbsensi()));
    }

    public double getTjTrans() {
        return tjTrans;
    }

    public void setTjTrans() {

        this.tjTrans = 440000.0 - ((440000.0 / 22) * (maxAbsen - getAbsensi()));
    }

    public double getTotGaji() {
        return totGaji;
    }

    public void setTotGaji(double totGaji) {
        this.totGaji = totGaji;
    }

    @Override
    void absensi() {
        this.setAbsensi(getAbsensi() + 1);
    }

    @Override
    void hitungGajiPokok() {
        this.setGaji((getGaji()/22) * maxAbsen);
    }
}
