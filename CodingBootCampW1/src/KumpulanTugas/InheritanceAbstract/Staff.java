package KumpulanTugas.InheritanceAbstract;

public class Staff extends Worker{
    private double tunjMakan;

    public Staff(int idKaryawan, String nama, double tunjPulsa, double gajiPokok, int absen, double tunjMakan) {
        super(idKaryawan, nama, tunjPulsa, gajiPokok, absen);
        this.tunjMakan = tunjMakan;
    }

    public double getTunjMakan() {
        return tunjMakan;
    }

    public void setTunjMakan() {
        this.tunjMakan = super.getAbsen()*20000;
    }

    @Override
    void absensi() {
        this.setAbsen(getAbsen()+1);
    }
}
